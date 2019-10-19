package com.tracholar.articlerecsys.model;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.model.ParallelModel;
import com.tracholar.recommend.model.PredictResult;
import com.tracholar.recommend.model.SimpleScore;
import lombok.Getter;

import java.util.List;

@Getter
public class RandomModel extends ParallelModel<Article> {
    private String id = "randomModel";

    protected Article predictRaw(List<Feature> feats){
        Article article = new Article();
        article.setScore(new SimpleScore((float) Math.random()));

        return article;
    }
}
