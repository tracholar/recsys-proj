package com.tracholar.recommend.model;

import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.model.Model;
import com.tracholar.recommend.model.PredictResult;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ParallelModel<P extends PredictResult> implements Model<P> {
    protected abstract P predictRaw(List<Feature> feats);
    public List<P> predict(List<List<Feature>> features){
        return features.parallelStream()
                .map(this::predictRaw)
                .collect(Collectors.toList());
    }
}
