package com.tracholar.tutorial.model;

import com.alibaba.fastjson.JSONObject;
import com.tracholar.recommend.engine.config.Configable;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.feature.Utils;
import com.tracholar.recommend.model.ParallelModel;
import com.tracholar.recommend.model.SimpleScore;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LinearModel extends ParallelModel<SimpleScore> {
    private Map<String, Float> w = new HashMap<>();
    private float b = 0;


    protected SimpleScore predictRaw(List<Feature> feats){
        // TODO 实现模型预测

        return null;
    }
}
