package com.tracholar.articlerecsys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.engine.*;

import java.io.InputStream;

public class ArticleRecEngine extends ConfigurableSimpleRecEngine{
    @JSONField
    private String config = "/article-rec-sys/engine.json";

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public ArticleRecEngine() throws Exception{
        InputStream is = getClass().getResourceAsStream(config);
        init(is);
    }


    public static void main(String[] args) throws Exception{
        RecEngine engine = new ArticleRecEngine();
        System.out.println(engine);

        User user = new User(123L);

        System.out.println(engine.recommend(user, new ReqContext("ADF-HJKH")));
    }
}
