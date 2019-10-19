package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.model.SimpleScore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemoRankResult implements RankResult<String> {
    private String id;
    private SimpleScore score;
    private int rank;
}
