package com.tracholar.recommend.engine;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;

import java.util.List;

public interface RecallStrategy {
    List<RecallResult> recall(User user, Context ctx);
}
