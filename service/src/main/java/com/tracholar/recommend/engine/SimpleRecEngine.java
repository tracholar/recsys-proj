package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.*;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.abtest.ABTestable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private Logger logger = LoggerFactory.getLogger(getClass());


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
    private <T> T getByABTest(IUser user, IContext ctx, List<T> arr)
            throws ComponentNotFoundException{
        List<T> filtered = filterByABTest(user, ctx, arr);

        if(filtered.size() == 0){
            throw new ComponentNotFoundException();
        }
        return filtered.get(0);
    }


    private List<RecallResult> doRecall(IUser user, IContext ctx)
        throws ComponentNotFoundException{
        Map<Recall, List<RecallResult>> results = new HashMap<>();
        for(Recall strategy : filterByABTest(user, ctx, getRecalls())){
            logger.info("Match recall {}", strategy.getClass().getName());

            try {
                List<RecallResult> res = strategy.recall(user, ctx);
                if (res == null) {
                    logger.info("Strategy {} recall null", strategy.getClass().getName());
                    continue;
                }
                results.put(strategy, res);

                logger.info("Strategy {} recall #{} items.", strategy.getClass().getName(), res.size());
            }catch (Exception e){
                logger.error("Recall strategy {} failed. {}", strategy.getClass().getName(), e);
            }
        }

        Merge merge = getByABTest(user, ctx, getMerges());
        return merge.merge(results);
    }

    private List<RecallResult> doFilter(IUser user, List<RecallResult> results, IContext ctx){
        for(Filter f : filterByABTest(user, ctx, getFilters())){
            logger.info("Match filter {}", f.getClass().getName());
            int begine = results.size();

            results = f.filter(user, results, ctx);

            logger.info("{} filter #{} items.", f.getClass().getName(), begine - results.size() );
        }
        return results;
    }

    public List<IItem> recommend(IUser user, IContext ctx){
        try {

            logger.debug("user={}, ctx={}", user, ctx);

            // recall
            List<RecallResult> results = doRecall(user, ctx);
            logger.info("召回 #{} items.", results.size());

            // filter
            results = doFilter(user, results, ctx);
            logger.info("过滤后剩下 #{} items.", results.size());

            // rank
            Ranker ranker = getByABTest(user, ctx, getRankers());
            logger.info("Match ranker {}", ranker.getClass().getName());
            List<RankResult> rankResults = ranker.rank(user, results, ctx);
            logger.info("排序后剩下 #{} items.", rankResults.size());

            // re-rank
            rankResults = getByABTest(user, ctx, getReRankers())
                    .reRank(user, rankResults, ctx);

            logger.info("Re-ranker 后剩下 #{} items.", rankResults.size());
            // fetch details
            return getDetailFetcher().fetch(rankResults);
        }catch (ComponentNotFoundException e){
            logger.error("{}", e);
        }
        return null;
    }

}
