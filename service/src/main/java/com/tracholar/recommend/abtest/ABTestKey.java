package com.tracholar.recommend.abtest;

import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.JsonableData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ABTestKey extends JsonableData {
    @JSONField(ordinal = 1)
    private String layerKey;
    @JSONField(ordinal = 2)
    private String flowKey;
}
