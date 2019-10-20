package com.tracholar.recommend.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleScore<V extends Comparable<V>> implements Score<V> {
    @JSONField
    private V value;

    @Override
    public int compareTo(V s) {
        return value.compareTo(s);
    }
}
