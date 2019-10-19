package com.tracholar.recommend.engine;

import com.alibaba.fastjson.JSON;
import com.tracholar.recommend.engine.config.ConfigUtils;
import com.tracholar.recommend.engine.config.RecEngineConfig;
import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Getter
public class JsonConfigRecEngine extends ConfigurableSimpleRecEngine {
    private RecEngineConfig config;

    private JsonConfigRecEngine(){};

    public JsonConfigRecEngine(RecEngineConfig config) throws EngineInitialException{
        super.init(config);
    }

    public static JsonConfigRecEngine load(InputStream is) throws Exception {
        RecEngineConfig config = JSON.parseObject(is, RecEngineConfig.class);
        return new JsonConfigRecEngine(config);
    }
    public static JsonConfigRecEngine load(String json) throws Exception {
        RecEngineConfig config = JSON.parseObject(json, RecEngineConfig.class);
        return new JsonConfigRecEngine(config);
    }
}
