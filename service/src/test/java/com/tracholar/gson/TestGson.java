package com.tracholar.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TestGson {
    @Test
    public void test1(){
        Gson gson = new Gson();
        System.out.println(gson.fromJson("\"1:34,sdf:434\"", String.class));
    }

    @Test
    private void test2(){
        Gson gson = new Gson();
        List list = new LinkedList();
    }
}
