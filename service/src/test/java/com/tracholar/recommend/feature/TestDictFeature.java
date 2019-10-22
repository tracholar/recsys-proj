package com.tracholar.recommend.feature;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDictFeature {
    @Test
    public void test1(){
        List<Feature> f = new ArrayList<>();
        f.add(new ScalarFeature("age", 25f));
        f.add(new CatFeature<>("gender", "man"));
        GroupFeature feature = new GroupFeature(1,"profile", f);
        System.out.println(feature.flatten());
        System.out.println(feature.toSparseVector());

        System.out.println(feature.toJson());
        System.out.println(feature.toLibsvmFormat(100));
        System.out.println(feature.toLibFFMFormat(100));
    }
}
