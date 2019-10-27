package com.tracholar.recommend.demo.dag;

import com.tracholar.recommend.feature.CatFeature;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.feature.ListFeature;
import com.tracholar.recommend.feature.dag.DepNodeMap;
import com.tracholar.recommend.feature.dag.InternalNode;
import com.tracholar.recommend.feature.dag.NodeNotFoundException;

public class IsUserVisitedNode extends InternalNode {
    @Override
    public Feature calcValue(DepNodeMap dependence) throws NodeNotFoundException {
        ListFeature<Long> hist = (ListFeature<Long>) dependence.get("hist");
        CatFeature<Long> itemId = (CatFeature) dependence.get("itemId");

        if(hist == null || itemId == null) {
            throw new NodeNotFoundException("Nodes hist and itemId not found!");
        }
        boolean visited = hist.getValue().contains(itemId.getValue());

        return new CatFeature("visited", visited);
    }
}
