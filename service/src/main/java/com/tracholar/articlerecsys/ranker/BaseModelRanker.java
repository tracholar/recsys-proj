package com.tracholar.articlerecsys.ranker;

import com.alibaba.fastjson.JSONObject;
import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.feature.ArticleFeatureFeatcher;
import com.tracholar.articlerecsys.model.RandomModel;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.model.ModelProxy;
import com.tracholar.recommend.model.PredictResult;
import com.tracholar.recommend.model.SimpleModelProxy;
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
        extends ModelRanker<Article, Article, Article> {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    protected void logFeatures(UserFeature u, List<ItemFeature> i, ContextFeature c){
        JSONObject data = new JSONObject();
        data.put("user", u);
        data.put("items", i);
        data.put("ctx", c);

        // 打日志
        logger.info(data.toJSONString());
    }

    protected List<Article> createResult(List<Article> preds){
        List<Article> results = preds.stream()
                .sorted(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                float s1 = o1.getScore().getScore();
                float s2 = o2.getScore().getScore();
                if(s1 == s2) return 0;
                if(s1 > s2) return 1;
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
