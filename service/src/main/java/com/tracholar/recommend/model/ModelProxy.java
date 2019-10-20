package com.tracholar.recommend.model;

import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;

import java.util.List;

/**
 * ModelProxy 接受一个用户多个item 进行预测。
 * 输入是业务逻辑的特征数据格式
 */
public interface ModelProxy<P extends Score> {
    List<P> predict(UserFeature u, List<ItemFeature> i, ContextFeature c);
}
