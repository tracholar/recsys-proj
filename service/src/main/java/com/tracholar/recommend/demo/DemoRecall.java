package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.User;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.engine.RecallResult;
import com.tracholar.recommend.engine.Recall;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class DemoRecall implements Recall, ABTestable {
    private ABTestKey abTestKey;

    @Override
    public List<RecallResult> recall(User user, Context ctx){
        List<RecallResult> results = new ArrayList<>();
        results.add(new DemoRecallResult("123"));
        results.add(new DemoRecallResult("234"));
        return results;
    }


}
