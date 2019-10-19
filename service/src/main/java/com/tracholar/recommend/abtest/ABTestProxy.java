package com.tracholar.recommend.abtest;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.User;

public interface ABTestProxy {
    boolean match(User user, Context ctx, ABTestKey key);
}
