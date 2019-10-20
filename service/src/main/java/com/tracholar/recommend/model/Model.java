package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.data.HasScore;
import com.tracholar.recommend.feature.Feature;

import java.util.List;

/**
 * 模型是对机器学习模型和策略模型的统一抽象
 * 模型不关心业务逻辑和业务数据，在它眼里只有特征Feature和预测结果HasScore
 */
public interface Model<S extends HasScore> extends HasId<String> {
    List<S> predict(List<List<Feature>> features);
}
