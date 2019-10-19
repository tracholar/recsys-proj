package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.HasId;

import java.util.List;

public interface DetailFetcher<T extends HasId> {
    List<T> fetchDetail(List<HasId> arr);
}
