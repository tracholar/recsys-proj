package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.HasId;

public interface RankResult extends HasId {
    float getScore();
    int getRank();
}
