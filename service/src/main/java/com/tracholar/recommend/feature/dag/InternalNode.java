package com.tracholar.recommend.feature.dag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class InternalNode implements IDagNode {
    private String id;
    private List<String> dependence;
}
