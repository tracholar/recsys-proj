package com.tracholar.recommend.feature;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestListFeature {
    @Test
    public void test1(){
        List<String> session = new ArrayList<>();
        session.add("china");
        session.add("japen");
        ListFeature<String> f = new ListFeature<>("session", session);
        System.out.println(f.flatten());
        System.out.println(f.toSparseVector());
        System.out.println(f.toSparseVector().toLibsvm());

        String json = f.toJson();
        System.out.println(json);
        ListFeature f1 = JSONObject.parseObject(json, ListFeature.class);
        Assert.assertEquals(f.getId(), f1.getId());
        Assert.assertEquals(f.getValue(), f1.getValue());
    }

    @Test
    public void test2(){
        ListFeature<String> f = new ListFeature<>("title");
        f.add("媒体");
        f.add("关注");
        System.out.println(f);
    }

}
