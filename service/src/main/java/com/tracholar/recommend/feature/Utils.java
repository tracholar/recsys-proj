package com.tracholar.recommend.feature;


import com.alibaba.fastjson.JSON;

public class Utils {
    private static long m = 1<<32 - 1;
    public static long getFid(String id) {
        long k = MurmurHash.getInstance().hash(id.getBytes(), 10, 2019);
        k &= m;
        return k;
    }

    public static long getFid(long id) {
        return id >> 32;
    }

    public Feature fromJson(String json, Class cls) {
        return (Feature)JSON.parseObject(json, cls);
    }

}
