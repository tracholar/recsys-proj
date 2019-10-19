package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PredictResult implements HasId<String> {
    private String id;
    private float score;
}
