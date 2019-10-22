package com.tracholar.recommend.feature;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class TestScalarFeature {
    @Test
    public void test1(){
        ScalarFeature f = new ScalarFeature("ctr", 0.3f);
        String json = f.toJson();
        System.out.println(json);
        ScalarFeature f1 = JSONObject.parseObject(json, ScalarFeature.class);
        System.out.println(f1);

        Assert.assertEquals(f.getId(), f1.getId());
        Assert.assertEquals(f.getValue(), f1.getValue());
    }
}
