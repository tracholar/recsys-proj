package com.tracholar.recommend.feature.dag;

import com.tracholar.recommend.feature.Feature;

import java.util.List;
import java.util.Map;

public interface IDagEngine {
    Map<String, Feature> calc(List<IDagNode> nodes);
}
