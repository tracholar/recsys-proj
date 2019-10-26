package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.IUser;

import java.util.List;

/**
 * @author: tracholar.github.io
 * 从外部来看，推荐引擎就是传入1个用户和一个上下文信息，你给我返回一个item的推荐列表。
 */
public interface RecEngine<U extends IUser, I extends IItem, C extends IContext> {
    List<I> recommend(U user, C ctx);
}
