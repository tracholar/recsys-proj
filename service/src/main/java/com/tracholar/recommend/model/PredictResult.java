package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.data.Score;

public interface PredictResult<ID> extends HasId<ID> {
    Score getScore();
}
