package com.tracholar.recommend.engine.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.data.JsonableData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ComponentConfig extends JsonableData {
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(name = "class", ordinal = 2)
    private String className;
    @JSONField(ordinal = 3)
    private ABTestKey abTestKey;
    @JSONField(ordinal = 4)
    private JSONObject args;

}
