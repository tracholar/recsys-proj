package com.tracholar.recommend.model;

public interface Score<T> extends Comparable<T>{
    T getValue();
}
