package com.tracholar.tutorial;

import com.alibaba.fastjson.JSON;
import com.tracholar.recommend.engine.RecEngine;
import com.tracholar.tutorial.data.Item;
import com.tracholar.tutorial.data.ReqContext;
import com.tracholar.tutorial.data.User;

import java.util.List;

public class ArticleRecEngine {
    private RecEngine engine;

    public ArticleRecEngine() throws Exception {
        // TODO 初始化 engine

    }

    public List<Item> recommend(User user, ReqContext ctx) {
        // TODO 推荐文章
        return null;
    }



    public static void main(String[] args) throws Exception{
        User user = new User("123", "dafad-fad-f-asdf-a-sd");

        ArticleRecEngine engine = new ArticleRecEngine();
        List<Item> items = engine.recommend(user, new ReqContext("ADF-HJKH"));

        System.out.println(JSON.toJSONString(items, true));

    }
}
