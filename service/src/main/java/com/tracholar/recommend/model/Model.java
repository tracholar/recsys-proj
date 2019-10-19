package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.feature.Feature;

import java.util.List;

/**
 * 模型是对机器学习模型和策略模型的统一抽象
 */
public interface Model<P extends PredictResult> extends HasId<String> {
    List<P> predict(List<List<Feature>> features);
}
