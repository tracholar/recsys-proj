package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.IUser;

import java.util.List;

/**
 * @Author: tracholar.github.io
 * 从外部来看，推荐引擎就是传入1个用户和一个上下文信息，你给我返回一个item的推荐列表。
 * getName这个接口都不见得是必须的，可以取去掉。
 */
public interface RecEngine {
    String getName();
    List<IItem> recommend(IUser user, IContext ctx);
}
