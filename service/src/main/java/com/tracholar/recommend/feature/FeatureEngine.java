package com.tracholar.recommend.feature;

import java.util.List;
import java.util.Map;

/**
 * 对特征使用者提供统一的特征获取接口
 */
public interface FeatureEngine {
    /**
     * 获取单个实体指定的特征列表
     * @param type 实体类型
     * @param id   实体ID
     * @param fid  特征ID列表
     * @return
     */
    List<Feature> fetch(EntityType type, String id, List<String> fid);

    /**
     * 获取多个实体指定的特征列表
     * @param type       实体类型
     * @param entityId   实体ID列表
     * @param fid        特征列表
     * @return
     */
    Map<String, List<Feature>> fetch(EntityType type, List<String> entityId, List<String> fid);
}
