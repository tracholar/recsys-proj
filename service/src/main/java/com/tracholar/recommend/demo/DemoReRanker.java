package com.tracholar.recommend.demo;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;
import com.tracholar.recommend.engine.RankResult;
import com.tracholar.recommend.engine.ReRanker;

import java.util.List;

public class DemoReRanker implements ReRanker {
    @Override
    public List<RankResult> reRank(User user, List<RankResult> results, Context ctx){
        return results;
    }
}
