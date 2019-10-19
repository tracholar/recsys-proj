package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class GroupFeature extends Feature<List<Feature>> {
    @JSONField
    private String id;
    @JSONField
    private List<Feature> value;

    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        for(Feature v : value) {
            Map<String, Float> fv = v.flatten();
            for(String kk : fv.keySet()) {
                map.put(id + ":" + kk, fv.get(kk));
            }
        }
        return map;
    }
}
