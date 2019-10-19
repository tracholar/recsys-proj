package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.feature.Feature;

import java.util.List;

public interface ContextFeature<ID> extends IContext<ID>, HasFeatures {
}
