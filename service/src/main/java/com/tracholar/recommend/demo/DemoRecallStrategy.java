package com.tracholar.recommend.demo;

import com.tracholar.recommend.Context;
import com.tracholar.recommend.User;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.engine.RecallResult;
import com.tracholar.recommend.engine.RecallStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class DemoRecallStrategy implements RecallStrategy, ABTestable {
    private ABTestKey abTestKey;

    @Override
    public List<RecallResult> recall(User user, Context ctx){
        List<RecallResult> results = new ArrayList<>();
        results.add(new DemoRecallResult("123"));
        results.add(new DemoRecallResult("234"));
        return results;
    }


}
