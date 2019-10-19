package com.tracholar.recommend.feature;

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
    }
}
