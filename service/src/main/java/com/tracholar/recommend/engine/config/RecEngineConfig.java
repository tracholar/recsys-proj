package com.tracholar.recommend.engine.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.engine.RecEngine;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Getter
@Setter
public class RecEngineConfig extends JsonableData {
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private String abtest;
    @JSONField(ordinal = 3)
    private String detailFetcher;

    @JSONField(ordinal = 4)
    private List<ComponentConfig> recalls;
    @JSONField(ordinal = 5)
    private List<ComponentConfig> merges;
    @JSONField(ordinal = 6)
    private List<ComponentConfig> filters;
    @JSONField(ordinal = 7)
    private List<ComponentConfig> rankers;
    @JSONField(ordinal = 8)
    private List<ComponentConfig> reRankers;

    @Override
    public String toString(){
        return JSON.toJSONString(this, true);
    }
}
