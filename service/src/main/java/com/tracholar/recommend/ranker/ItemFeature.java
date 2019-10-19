package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.feature.Feature;

import java.util.List;
import java.util.Map;

public interface ItemFeature extends IItem {
    Map<IItem, List<Feature>> getFeatures();
}
