package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.data.RecallResult;

import java.util.List;

public interface Ranker<R extends RecallResult, RR extends RankResult> {
    List<RR> rank(IUser user, List<R> results, IContext ctx);
}
