package com.tracholar.recommend.feature.dag;

import com.tracholar.recommend.feature.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 叶子节点，不用计算，只需要初始化的时候设置id和value即可
 */

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeafNode implements IDagNode{
    @Getter
    private String id;
    private Feature value;


    @Override
    public Feature calcValue(DepNodeMap dependence){
        return value;
    }

    @Override
    public List<String> getDependence() {
        return new LinkedList<>();
    }

}
