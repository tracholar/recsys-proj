package com.tracholar.recommend;

import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;

public class TestAutoConfigEngine {
    @Test
    public void test1() throws Exception{
        URLClassLoader classLoader = new URLClassLoader(new URL[]{
                new URL("")
        });
        Class cls = classLoader.loadClass("com.tracholar.tutorial.ArticleRecEngine");
        cls.newInstance();
    }
}
