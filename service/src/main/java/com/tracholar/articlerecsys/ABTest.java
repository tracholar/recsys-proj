package com.tracholar.articlerecsys;

import com.alibaba.fastjson.util.TypeUtils;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import org.apache.hadoop.util.hash.MurmurHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ABTest implements ABTestProxy {
    private MurmurHash hash = new MurmurHash();
    int bucketNum = 10;

    private String getBucketId(User user, String layerKey) {
        int seed = TypeUtils.castToInt(layerKey);
        int v = hash.hash(user.getDeviceId().getBytes(), 10, seed);
        v = Math.abs(v % bucketNum);
        return v + "";
    }
    @Override
    public boolean match(IUser user, IContext ctx, ABTestKey key){
        // all match
        if(key == null) return true;// 如果没有设置， 则全部匹配

        String bucketId = getBucketId((User) user, key.getLayerKey());
        List<String> flow = Arrays.asList(key.getFlowKey().split(","));
        return flow.contains(bucketId);
    }
}
