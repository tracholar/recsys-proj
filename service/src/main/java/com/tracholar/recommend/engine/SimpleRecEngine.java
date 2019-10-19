package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.*;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.abtest.ABTestable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tracholar.github.io
 * SimpleRecEngin 抽象了整个推荐系统的流水线，将各个模块（如召回、排序、AB测试等）组装起来。
 * 但是它并不知道如何获取这些模块，而将这些模块的获取留给子类实现。
 */
public abstract class SimpleRecEngine implements RecEngine {
    abstract protected List<Recall> getRecalls();
    abstract protected List<Merge> getMerges();
    abstract protected List<Filter> getFilters();
    abstract protected List<Ranker> getRankers();
    abstract protected List<ReRanker> getReRankers();

    abstract protected ABTestProxy getAbTestProxy();
    abstract protected DetailFetcher getDetailFetcher();


    private <T> List<T> filterByABTest(IUser user, IContext ctx, List<T> arr){
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
    private <T> T getByABTest(IUser user, IContext ctx, List<T> arr){
        List<T> filtered = filterByABTest(user, ctx, arr);
        assert filtered.size() == 1;
        return filtered.get(0);
    }


    private List<RecallResult> doRecall(IUser user, IContext ctx){
        Map<Recall, List<RecallResult>> results = new HashMap<>();
        for(Recall strategy : filterByABTest(user, ctx, getRecalls())){
            List<RecallResult> res = strategy.recall(user, ctx);
            if(res == null) continue;
            results.put(strategy, res);
        }

        Merge merge = getByABTest(user, ctx, getMerges());
        return merge.merge(results);
    }

    private List<RecallResult> doFilter(IUser user, List<RecallResult> results, IContext ctx){
        for(Filter f : filterByABTest(user, ctx, getFilters())){
            results = f.filter(user, results, ctx);
        }
        return results;
    }

    public List<IItem> recommend(IUser user, IContext ctx){
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
