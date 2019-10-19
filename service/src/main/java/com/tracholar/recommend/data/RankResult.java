package com.tracholar.recommend.data;

import com.tracholar.recommend.model.Score;

public interface RankResult<ID> extends HasId<ID> {
    Score getScore();
    int getRank();
}
