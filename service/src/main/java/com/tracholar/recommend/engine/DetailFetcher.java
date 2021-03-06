package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.HasId;

import java.util.List;

/**
 * @author tracholar.github.io
 * 获取`HasId`的详情，可以是用户、item任何有id的东西的详情
 * @param <I> 获取详情对应的实体，比如用户、商品等
 */
public interface DetailFetcher<ID extends HasId, I extends HasId> {
    List<I> fetch(List<ID> arr);
}
