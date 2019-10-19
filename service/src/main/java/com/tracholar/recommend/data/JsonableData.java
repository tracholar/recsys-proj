package com.tracholar.recommend.data;

import com.alibaba.fastjson.JSON;

public abstract class JsonableData {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
