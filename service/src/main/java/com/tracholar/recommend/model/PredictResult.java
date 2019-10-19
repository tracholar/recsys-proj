package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasId;

public interface PredictResult extends HasId<String> {
    Score getScore();
}
