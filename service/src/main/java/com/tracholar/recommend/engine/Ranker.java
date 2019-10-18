package com.tracholar.recommend.engine;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;

import java.util.List;

public interface Ranker {
    List<RankResult> rank(User user, List<RecallResult> results, Context ctx);
}
