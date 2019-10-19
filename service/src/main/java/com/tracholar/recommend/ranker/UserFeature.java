package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.feature.Feature;

import java.util.List;

public interface UserFeature<ID> extends IUser<ID>, HasFeatures {
}
