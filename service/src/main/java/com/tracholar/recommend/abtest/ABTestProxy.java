package com.tracholar.recommend.abtest;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;

public interface ABTestProxy {
    boolean match(IUser user, IContext ctx, ABTestKey key);
}
