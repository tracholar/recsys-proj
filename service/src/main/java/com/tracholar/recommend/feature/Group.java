package com.tracholar.recommend.feature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 特征分组
 */
@Getter
@AllArgsConstructor
public class Group {
    private int id;
    private String name;

    public Group(String name) {
        this.name = name;
        this.id = Hash.hash(name);
    }
}
