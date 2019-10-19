package com.tracholar.articlerecsys.ranker;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.model.RandomModel;
import com.tracholar.recommend.model.SimpleModelProxy;
import lombok.Getter;

@Getter
public class RandomModelRanker extends BaseModelRanker {
    private SimpleModelProxy<Article> modelProxy = new SimpleModelProxy<>(new RandomModel());
}
