package com.tracholar.articlerecsys.ranker;

import com.tracholar.articlerecsys.model.RandomModel;
import com.tracholar.recommend.model.SimpleModelProxy;
import com.tracholar.recommend.model.SimpleScore;
import lombok.Getter;

@Getter
public class RandomModelRanker extends BaseModelRanker {
    private SimpleModelProxy<SimpleScore> modelProxy = new SimpleModelProxy<>(new RandomModel());
}
