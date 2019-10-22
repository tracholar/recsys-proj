package com.tracholar.recommend.feature;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class TestCatFeature {
    @Test
    public void test1(){
        CatFeature f = new CatFeature<>("city", 1);
        String json = f.toJson();
        System.out.println(json);
        CatFeature f1 = JSONObject.parseObject(json, CatFeature.class);
        System.out.println(f1);

        Assert.assertEquals(f.getId(), f1.getId());
        Assert.assertEquals(f.getValue(), f1.getValue());
    }
}
