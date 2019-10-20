package com.tracholar.recommend.data;

public interface RankResult<ID> extends HasId<ID>, HasScore {
    int getRank();
}
