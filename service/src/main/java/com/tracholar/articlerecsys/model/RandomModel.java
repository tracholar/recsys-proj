package com.tracholar.articlerecsys.model;

import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.model.ParallelModel;
import com.tracholar.recommend.model.SimpleScore;
import lombok.Getter;

import java.util.List;

@Getter
public class RandomModel extends ParallelModel<SimpleScore> {
    private String id = "randomModel";

    protected SimpleScore predictRaw(List<Feature> feats){
        return new SimpleScore((float)Math.random());
    }
}
