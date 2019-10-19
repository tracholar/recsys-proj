package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.RankResult;

import java.util.List;

public interface ReRanker<R extends RankResult> {
    List<R> reRank(IUser user, List<R> results, IContext ctx);
}
