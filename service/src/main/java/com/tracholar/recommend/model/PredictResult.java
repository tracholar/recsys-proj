package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasId;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface PredictResult extends HasId<String> {
    float getScore();
}
