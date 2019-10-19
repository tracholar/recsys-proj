package com.tracholar.articlerecsys;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.engine.DetailFetcher;

import java.util.ArrayList;
import java.util.List;

public class ArticleFetcher implements DetailFetcher<Article> {

    public List<Article> fetch(List<HasId> arr){
        List<Article> articles = new ArrayList<>();
        for(HasId<String> s : arr) {
            articles.add(new Article(s.getId(), "文章标题"));
        }

        return articles;
    }

}
