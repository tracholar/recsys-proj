package com.tracholar.recommend.ranker;

import com.tracholar.recommend.feature.Feature;

import java.util.List;

public interface HasFeatures {
    List<Feature> getFeatures();
}
