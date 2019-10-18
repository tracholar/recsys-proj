package com.tracholar.recommend.demo;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;

public class DemoABTestProxy implements ABTestProxy {
    @Override
    public boolean match(User user, Context ctx, ABTestKey key){
        // all match
        return true;
    }

}
