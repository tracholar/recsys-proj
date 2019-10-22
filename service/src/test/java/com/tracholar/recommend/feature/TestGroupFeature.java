package com.tracholar.recommend.feature;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGroupFeature {
    @Test
    public void test1(){
        List<Feature> f = new ArrayList<>();
        f.add(new ScalarFeature("age", 25f));
        f.add(new CatFeature<>("gender", "man"));
        GroupFeature feature = new GroupFeature(new Group(1,"profile"), f);
        System.out.println(feature.flatten());
        System.out.println(feature.toSparseVector());

        System.out.println(feature.toJson());
        System.out.println(feature.toLibsvmFormat(100));
        System.out.println(feature.toLibFFMFormat(100));
        System.out.println(feature.toGroupSparseVector(32));
    }

    @Test
    public void testSerilize(){
        GroupFeature feature = new GroupFeature(new Group(2, "gf"));
        feature.add(new ScalarFeature("ctr", 0.23f));
        feature.add(new CatFeature("cityid", 45));

        String json = feature.toJson();
        System.out.println(json);

        GroupFeature feature1 = JSON.parseObject(json, GroupFeature.class);
        System.out.println(feature1.toJson());

        Assert.assertEquals(feature.getId(), feature1.getId());

        for(int i=0; i<feature.getValue().size(); i++){
            Feature f1 = feature.getValue().get(i);
            Feature f2 = feature1.getValue().get(i);
            Assert.assertEquals(f1.getId(), f2.getId());
            Assert.assertEquals(f1.getValue(), f2.getValue());
        }


    }
}
