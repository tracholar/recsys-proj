package com.tracholar.recommend.feature.dag;

import com.tracholar.recommend.feature.Feature;
import org.apache.commons.lang3.SerializationUtils;

import java.util.HashMap;

public class DepNodeMap extends HashMap<String, Feature> {
    /**
     * 重写get方法，防止在node内部修改了传入的参数
     * @param key
     * @return
     */
    @Override
    public Feature get(Object key) {
        return SerializationUtils.clone(super.get(key));
    }
}
