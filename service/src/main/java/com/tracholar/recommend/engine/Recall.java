package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.RecallResult;

import java.util.List;

public interface Recall {
    List<RecallResult> recall(IUser user, IContext ctx);
}
