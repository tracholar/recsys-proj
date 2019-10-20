package com.tracholar.recommend.data;

import com.tracholar.recommend.model.Score;

public interface HasScore<T extends Score> {
    T getScore();
}
