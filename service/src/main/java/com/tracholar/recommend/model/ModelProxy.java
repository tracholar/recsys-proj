package com.tracholar.recommend.model;

import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;

import java.util.List;

/**
 * ModelProxy 接受一个用户多个item 进行预测。
 * 因为Model只能一次预测一条样本。
 */
public interface ModelProxy<P extends PredictResult> {
    List<P> predict(UserFeature u, List<ItemFeature> i, ContextFeature c);
}
