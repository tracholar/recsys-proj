package com.tracholar.recommend.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleScore implements Score {
    @JSONField
    private float score;
}
