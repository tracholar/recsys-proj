package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.RecallResult;

import java.util.List;
import java.util.Map;

public interface Merge<R extends RecallResult> {
    List<R> merge(Map<Recall, List<R>> results);
}
