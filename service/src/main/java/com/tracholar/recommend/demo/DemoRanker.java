package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.User;
import com.tracholar.recommend.engine.RankResult;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.engine.RecallResult;

import java.util.ArrayList;
import java.util.List;

public class DemoRanker implements Ranker {
    @Override
    public List<RankResult> rank(User user, List<RecallResult> results, Context ctx){
        List<RankResult> rs = new ArrayList<>();
        for(int i=0; i<results.size(); i++){
            rs.add(new DemoRankResult(results.get(i).getId(), 0.1f, i));
        }

        return rs;
    }
}
