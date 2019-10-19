package com.tracholar.recommend.demo;

import com.tracholar.recommend.engine.RankResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class DemoRankResult implements RankResult<String> {
    private String id;
    private float score;
    private int rank;
}
