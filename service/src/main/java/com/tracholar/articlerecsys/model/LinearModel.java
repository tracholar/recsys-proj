package com.tracholar.articlerecsys.model;

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
public class LinearModel extends ParallelModel<SimpleScore>
        implements Configable<JSONObject> {
    private Map<String, Float> w = new HashMap<>();
    private float b = 0;
    public void init(JSONObject conf) throws Exception {
        log.info("LinearModel conf:{}", conf);
    }

    protected SimpleScore predictRaw(List<Feature> feats){
        Map<String, Float> featMap = Utils.toMap(feats);

        log.info("featMap: {}", featMap);
        log.info("libsvm: {}", Utils.toSparseVector(feats).toLibsvm());

        float score = b;
        for(String k : featMap.keySet()) {
            if(w.containsKey(k)) score += w.get(k) * featMap.get(k);
        }

        return new SimpleScore(score);
    }
}
