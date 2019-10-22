package com.tracholar.recommend.data;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public abstract class JsonableData implements Serializable {
    @Override
    public String toString() {
        return toJson();
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
