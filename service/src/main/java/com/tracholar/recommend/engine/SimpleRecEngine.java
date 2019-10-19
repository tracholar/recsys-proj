package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.Item;
import com.tracholar.recommend.data.User;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.abtest.ABTestable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SimpleRecEngine implements RecEngine {
    abstract protected List<Recall> getRecalls();
    abstract protected List<Merge> getMerges();
    abstract protected List<Filter> getFilters();
    abstract protected List<Ranker> getRankers();
    abstract protected List<ReRanker> getReRankers();

    abstract protected ABTestProxy getAbTestProxy();
    abstract protected DetailFetcher getDetailFetcher();


    private <T> List<T> filterByABTest(User user, Context ctx, List<T> arr){
        List<T> strategies = new ArrayList<>();
        for(T s : arr){
            if(s instanceof ABTestable){
                ABTestKey key = ((ABTestable) s).getAbTestKey();
                if(! getAbTestProxy().match(user, ctx, key)){
                    continue;
                }

            }
            strategies.add(s);
        }
        return strategies;
    }
    private <T> T getByABTest(User user, Context ctx, List<T> arr){
        List<T> filtered = filterByABTest(user, ctx, arr);
        assert filtered.size() == 1;
        return filtered.get(0);
    }


    private List<RecallResult> doRecall(User user, Context ctx){
        Map<Recall, List<RecallResult>> results = new HashMap<>();
        for(Recall strategy : filterByABTest(user, ctx, getRecalls())){
            List<RecallResult> res = strategy.recall(user, ctx);
            if(res == null) continue;
            results.put(strategy, res);
        }

        Merge merge = getByABTest(user, ctx, getMerges());
        return merge.merge(results);
    }

    private List<RecallResult> doFilter(User user, List<RecallResult> results, Context ctx){
        for(Filter f : filterByABTest(user, ctx, getFilters())){
            results = f.filter(user, results, ctx);
        }
        return results;
    }

    public List<Item> recommend(User user, Context ctx){
        // recall
        List<RecallResult> results = doRecall(user, ctx);

        // filter
        results = doFilter(user, results, ctx);

        // rank
        List<RankResult> rankResults = getByABTest(user, ctx, getRankers()).rank(user, results, ctx);

        // re-rank
        rankResults = getByABTest(user, ctx, getReRankers())
                .reRank(user, rankResults, ctx);

        // fetch details
        return getDetailFetcher().fetchDetail(rankResults);
    }

}
