package com.tracholar.recommend.merge;

import com.tracholar.recommend.engine.Merge;
import com.tracholar.recommend.engine.Recall;
import com.tracholar.recommend.data.RecallResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicMerge<R extends RecallResult> implements Merge<R> {
    // 简单合并
    @Override
    public List<R> merge(Map<Recall, List<R>> results){
        List<R> mergedList = new ArrayList<>();
        for(List<R> r : results.values()) {
            mergedList.addAll(r);
        }

        return mergedList;
    }
}
