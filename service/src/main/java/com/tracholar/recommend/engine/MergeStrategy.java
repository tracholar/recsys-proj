package com.tracholar.recommend.engine;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;

import java.util.List;
import java.util.Map;

public interface MergeStrategy {
    List<RecallResult> merge(Map<RecallStrategy, List<RecallResult>> results);

}
