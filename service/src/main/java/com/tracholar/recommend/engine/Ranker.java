package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;

import java.util.List;

public interface Ranker {
    List<RankResult> rank(IUser user, List<RecallResult> results, IContext ctx);
}
