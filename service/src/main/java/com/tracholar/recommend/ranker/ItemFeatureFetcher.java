package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.engine.DetailFetcher;

import java.util.List;


public interface ItemFeatureFetcher<I> {
    List<ItemFeature> fetch(List<I> arr);
}
