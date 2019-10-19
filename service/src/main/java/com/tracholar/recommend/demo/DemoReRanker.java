package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.RankResult;
import com.tracholar.recommend.engine.ReRanker;

import java.util.List;

public class DemoReRanker implements ReRanker {
    @Override
    public List<RankResult> reRank(IUser user, List<RankResult> results, IContext ctx){
        return results;
    }
}
