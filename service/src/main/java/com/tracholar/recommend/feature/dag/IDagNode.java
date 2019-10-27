package com.tracholar.recommend.feature.dag;

import com.tracholar.recommend.feature.Feature;

import java.util.List;
import java.util.Map;

public interface IDagNode {
    /**
     * DAG计算节点的唯一标识
     * @return
     */
    String getId();

    /**
     * 得到节点的值，节点的值是一个特征
     * @see Feature
     * @return
     */
    Feature calcValue(DepNodeMap dependence) throws Exception;

    /**
     * 获取依赖的DAG节点ID列表
     * @return
     */
    List<String> getDependence();
}
