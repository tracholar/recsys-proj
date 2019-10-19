package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.RankResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemoRankResult implements RankResult<String> {
    private String id;
    private float score;
    private int rank;
}
