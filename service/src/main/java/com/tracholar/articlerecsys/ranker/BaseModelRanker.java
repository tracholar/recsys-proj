package com.tracholar.articlerecsys.ranker;

import com.alibaba.fastjson.JSONObject;
import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.feature.ArticleFeatureFeatcher;
import com.tracholar.recommend.model.SimpleScore;
import com.tracholar.recommend.ranker.*;
import lombok.AccessLevel;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Getter(AccessLevel.PROTECTED)
public abstract class BaseModelRanker
        extends ModelRanker<Article, Article, SimpleScore> {

    @Override
    protected List<Article> createResult(List<SimpleScore> preds, List<Article> articles){
        // 设置得分
        for(int i = 0; i<articles.size(); i++){
            articles.get(i).setScore(preds.get(i));
        }
        List<Article> results = articles.stream()
                .sorted(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                float s1 = o1.getScore().getValue();
                float s2 = o2.getScore().getValue();
                if(s1 == s2) return 0;
                if(s1 < s2) return 1;
                return -1;
            }
        }).collect(Collectors.toList());
        for(int i=0; i<results.size(); i++){
            results.get(i).setRank(i);
        }
        return results;
    }

    private UserFeatureFetcher userFeatFetcher = new ArticleFeatureFeatcher();
    private ItemFeatureFetcher itemFeatFetcher = new ArticleFeatureFeatcher();
    private ContextFeatureFetcher contextFeatFetcher = new ArticleFeatureFeatcher();

}
