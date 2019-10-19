package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;

public class DemoABTestProxy implements ABTestProxy {
    @Override
    public boolean match(IUser user, IContext ctx, ABTestKey key){
        // all match
        return true;
    }

}
