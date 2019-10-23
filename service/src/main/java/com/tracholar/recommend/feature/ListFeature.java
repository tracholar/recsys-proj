package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ListFeature<T> extends Feature<List<T>> {
    @JSONField
    private String id;
    @JSONField
    private List<T> value;

    public ListFeature(String id) {
        this.id = id;
        this.value = new LinkedList<>();
    }
    public boolean add(T v) {
        return value.add(v);
    }
    public boolean addAll(List<T> v) {
        return value.addAll(v);
    }
    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        for(int i = 0; i < value.size(); i++) {
            T v = value.get(i);
            map.put(id + ":" + v, 1.0f);
        }
        return map;
    }

    public GroupFeature toGroupFeature(int gid){
        List<Feature> fs = value.stream()
                .filter(e -> e != null)
                .map(e -> new ScalarFeature(e.toString(), 1.0f))
                .collect(Collectors.toList());
        return new GroupFeature(new Group(gid, id), fs);
    }
}
