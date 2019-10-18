package com.tracholar.recommend.abtest;

import com.alibaba.fastjson.JSONObject;
import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;

public interface ABTestProxy {
    boolean match(User user, Context ctx, ABTestKey key);
}
