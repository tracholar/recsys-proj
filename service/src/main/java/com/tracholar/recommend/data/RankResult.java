package com.tracholar.recommend.data;

import com.tracholar.recommend.data.HasId;

public interface RankResult<ID> extends HasId<ID> {
    float getScore();
    int getRank();
}
