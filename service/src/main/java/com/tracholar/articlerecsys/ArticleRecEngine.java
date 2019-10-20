package com.tracholar.articlerecsys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.engine.*;

import java.util.ArrayList;
import java.util.List;

public class ArticleRecEngine {
    @JSONField
    private String configFile = "/article-rec-sys/engine.json";

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    private JsonConfigRecEngine engine;

    public ArticleRecEngine() throws Exception {
        engine = JsonConfigRecEngine.load(getClass().getResourceAsStream(configFile));
    }

    public List<Article> recommend(User user, ReqContext ctx) {
        List<IItem> res = engine.recommend(user, ctx);
        List<Article> articles = new ArrayList<>();
        for(IItem item : res) {
            articles.add((Article)item);
        }
        return articles;
    }



    public static void main(String[] args) throws Exception{
        User user = new User("123", "dafad-fad-f-asdf-a-sd");

        ArticleRecEngine engine = new ArticleRecEngine();
        List<Article> articles = engine.recommend(user, new ReqContext("ADF-HJKH"));

        System.out.println(JSON.toJSONString(articles, true));

    }
}
