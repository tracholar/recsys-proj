package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.engine.ReRanker;
import com.tracholar.recommend.engine.config.Autoload;

import java.util.List;

@Autoload
public class DemoReRanker implements ReRanker<RankResult> {
    @Override
    public List<RankResult> reRank(IUser user, List<RankResult> results, IContext ctx){
        return results;
    }
}
