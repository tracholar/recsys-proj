package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ListFeature<T> extends Feature<List<T>> {
    @JSONField
    private String id;
    @JSONField
    private List<T> value;

    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        for(int i = 0; i < value.size(); i++) {
            T v = value.get(i);
            map.put(id + ":" + v, 1.0f);
        }
        return map;
    }
}
