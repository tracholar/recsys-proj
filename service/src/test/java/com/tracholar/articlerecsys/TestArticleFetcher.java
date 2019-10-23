package com.tracholar.articlerecsys;

import com.alibaba.fastjson.JSON;
import com.tracholar.articlerecsys.data.Article;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TestArticleFetcher {
    @Test
    public void test1(){
        ArticleFetcher fetcher = new ArticleFetcher();
        List<Article> ids = new LinkedList<>();
        ids.add(new Article("5"));
        ids.add(new Article("10"));
        List<Article> articles = fetcher.fetch(ids);
        articles.stream().forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }
}
