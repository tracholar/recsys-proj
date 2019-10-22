package com.tracholar.tutorial;

import com.alibaba.fastjson.util.TypeUtils;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.tutorial.data.User;
import org.apache.hadoop.util.hash.MurmurHash;

import java.util.Arrays;
import java.util.List;

public class ABTest implements ABTestProxy {

    @Override
    public boolean match(IUser user, IContext ctx, ABTestKey key){
        //TODO match
        return true;
    }
}
