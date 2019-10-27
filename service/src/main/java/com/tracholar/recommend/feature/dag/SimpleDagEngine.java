package com.tracholar.recommend.feature.dag;

import com.tracholar.recommend.feature.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleDagEngine implements IDagEngine {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Feature calcNode(IDagNode node, DepNodeMap value) {
        // 如果已经计算过了
        if(value.containsKey(node.getId())) {
            return value.get(node.getId());
        }

        // 如果没有，先计算依赖节点
        for(IDagNode n : getNodes(node.getDependence())){
            if(!value.containsKey(n.getId())) {
                // 如果依赖节点没有计算，先计算依赖节点的值
                Feature f = calcNode(n, value);
                value.put(n.getId(), f);
            }
        }

        // 依赖节点计算完了之后，然后计算该节点的值
        try {
            logger.debug("Invoke calcValue of node {}", node.getId());

            return node.calcValue(value);
        }catch (Exception e){
            logger.warn("Node id={} class={} calcValue({}) failed! Value of this node will be set to null. ",
                    node.getId(),
                    node.getClass().getCanonicalName(),
                    value,
                    e);
        }
        return null;
    }

    private Map<String, IDagNode> nodeMap;
    private List<IDagNode> getNodes(List<String> ids) {
        return ids.stream().map(i -> nodeMap.get(i))
                .filter(e -> e != null).collect(Collectors.toList());
    }

    @Override
    public Map<String, Feature> calc(List<IDagNode> nodes) {
        DepNodeMap value = new DepNodeMap();
        nodeMap = new HashMap<>();

        // 构建node map
        nodes.stream().forEach(n -> nodeMap.put(n.getId(), n));

        nodes.stream().forEach(node ->
            value.put(node.getId(), calcNode(node, value))
        );

        return value;
    }
}
