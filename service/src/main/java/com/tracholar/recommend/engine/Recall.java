package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.User;

import java.util.List;

public interface Recall {
    List<RecallResult> recall(User user, Context ctx);
}
