package com.tracholar.recommend.demo.dag;

import com.tracholar.recommend.feature.CatFeature;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.feature.dag.IDagEngine;
import com.tracholar.recommend.feature.dag.IDagNode;
import com.tracholar.recommend.feature.dag.LeafNode;
import com.tracholar.recommend.feature.dag.SimpleDagEngine;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestDagEngine {
    @Test
    public void test(){
        IDagEngine engine = new SimpleDagEngine();
        List<IDagNode> nodes = new LinkedList<>();
        LeafNode node1 = new LeafNode("age", new CatFeature("age", "main"));
        nodes.add(node1);

        UserAgeProcessedNode node2 = new UserAgeProcessedNode();
        node2.setId("processed-age");
        List<String> deps = new LinkedList<>();
        deps.add("age");
        node2.setDependence(deps);
        nodes.add(node2);

        IsUserVisitedNode node3 = new IsUserVisitedNode();
        node3.setId("isUserVisited");
        deps = new LinkedList<>();
        deps.add("itemId");
        deps.add("hist");
        node3.setDependence(deps);
        nodes.add(node3);

        Map<String, Feature> results = engine.calc(nodes);
        System.out.println(results);
    }
}
