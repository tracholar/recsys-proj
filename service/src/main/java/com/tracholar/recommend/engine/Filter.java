package com.tracholar.recommend.engine;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;

import java.util.List;

public interface Filter {
    List<RecallResult> filter(User user, List<RecallResult> results, Context ctx);
}
