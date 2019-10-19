package com.tracholar.recommend.engine;

import java.util.List;
import java.util.Map;

public interface Merge {
    List<RecallResult> merge(Map<Recall, List<RecallResult>> results);

}
