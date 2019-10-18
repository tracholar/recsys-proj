package com.tracholar.recommend;

public interface Configurable<T> {
    boolean init(T conf);
}
