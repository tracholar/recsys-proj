package com.tracholar.recommend.engine.config;

public interface Configable<T> {
    void init(T conf) throws Exception;
}
