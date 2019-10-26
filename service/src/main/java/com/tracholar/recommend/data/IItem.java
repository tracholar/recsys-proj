package com.tracholar.recommend.data;

import java.io.Serializable;

/**
 * IItem 是指推荐引擎返回的item
 * @param <ID> ID 的数据类型，通常是Long或者String
 */
public interface IItem<ID> extends HasId<ID>, Serializable {
}
