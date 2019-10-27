package com.tracholar.recommend.feature;

import com.tracholar.recommend.feature.dag.IDagEngine;
import com.tracholar.recommend.feature.dag.IDagNode;
import com.tracholar.recommend.feature.dag.SimpleDagEngine;
import java.util.*;

public abstract class SimpleFeatureEngine implements FeatureEngine {
    private IDagEngine engine = new SimpleDagEngine();

    protected abstract List<IDagNode> fetchNode(EntityType type,
                                       String entityId,
                                       List<String> fid);

    @Override
    public List<Feature> fetch(EntityType type, String entityId, List<String> fid){
        List<IDagNode> nodes = fetchNode(type, entityId, fid);
        Map<String, Feature> features = engine.calc(nodes);
        List<Feature> list = new LinkedList<>();
        list.addAll(features.values());
        return list;
    }

    @Override
    public Map<String, List<Feature>> fetch(EntityType type,
                                            List<String> entityId,
                                            List<String> fid){
        Map<String, List<Feature>> map = new HashMap<>();
        for(String id : entityId) {
            map.put(id, fetch(type, id, fid));
        }
        return map;
    }
}
