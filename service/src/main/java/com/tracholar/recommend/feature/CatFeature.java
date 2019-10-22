package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class CatFeature<T> extends Feature<T> {
    @JSONField
    private String id;
    @JSONField
    private T value;

    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        if(value != null) {
            map.put(id + ":" + value, 1.0f);
        }
        return map;
    }
}
