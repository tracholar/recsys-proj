package com.tracholar.recommend.engine;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.Item;
import com.tracholar.recommend.RecEngine;
import com.tracholar.recommend.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SimpleRecEngine implements RecEngine {
    private String name;

    public SimpleRecEngine(){
        name = getClass().getSimpleName();
    }
    public String getName(){
        return name;
    }
    abstract List<RecallStrategy> getRecallStrategies(User user, Context ctx);
    abstract MergeStrategy getMergeStrategy(User user, Context ctx);

    private List<RecallResult> doRecall(User user, Context ctx){
        Map<RecallStrategy, List<RecallResult>> results = new HashMap<>();
        for(RecallStrategy strategy : getRecallStrategies(user, ctx)){
            List<RecallResult> res = strategy.recall(user, ctx);
            results.put(strategy, res);
        }

        MergeStrategy mergeStrategy = getMergeStrategy(user, ctx);
        return mergeStrategy.merge(results);
    }

    abstract List<RecallResult> filter(User user, List<RecallResult> results, Context ctx);
    abstract List<RankResult> rank(User user, List<RecallResult> results,  Context ctx);
    abstract List<Item> fetchDetail(List<RankResult> results);

    public List<Item> recommend(User user, Context ctx){
        List<RecallResult> results = doRecall(user, ctx);
        results = filter(user, results, ctx);
        List<RankResult> rankResults = rank(user, results, ctx);
        return fetchDetail(rankResults);
    }

}
