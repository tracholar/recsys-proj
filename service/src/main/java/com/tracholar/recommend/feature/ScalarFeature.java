package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class ScalarFeature extends Feature<Float>{
    @JSONField
    private String id;
    @JSONField
    private Float v;

    public String getId(){
        return id;
    }
    public Float getValue() {
        return v;
    }
    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        if(v != null) {
            map.put(id, v);
        }
        return map;
    }
}
