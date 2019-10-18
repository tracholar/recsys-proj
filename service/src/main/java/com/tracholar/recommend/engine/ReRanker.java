package com.tracholar.recommend.engine;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;

import java.util.List;

public interface ReRanker {
    List<RankResult> reRank(User user, List<RankResult> results, Context ctx);
}
