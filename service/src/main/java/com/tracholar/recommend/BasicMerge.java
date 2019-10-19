package com.tracholar.recommend;

import com.tracholar.recommend.engine.Merge;
import com.tracholar.recommend.engine.Recall;
import com.tracholar.recommend.engine.RecallResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicMerge implements Merge {
    // 简单合并
    @Override
    public List<RecallResult> merge(Map<Recall, List<RecallResult>> results){
        List<RecallResult> mergedList = new ArrayList<>();
        for(List<RecallResult> r : results.values()) {
            mergedList.addAll(r);
        }

        return mergedList;
    }
}
