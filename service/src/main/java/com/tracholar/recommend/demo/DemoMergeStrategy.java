package com.tracholar.recommend.demo;

import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.engine.MergeStrategy;
import com.tracholar.recommend.engine.RecallResult;
import com.tracholar.recommend.engine.RecallStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DemoMergeStrategy implements MergeStrategy {

    // 简单合并
    @Override
    public List<RecallResult> merge(Map<RecallStrategy, List<RecallResult>> results){
        List<RecallResult> mergedList = new ArrayList<>();
        for(List<RecallResult> r : results.values()) {
            mergedList.addAll(r);
        }

        return mergedList;
    }
}
