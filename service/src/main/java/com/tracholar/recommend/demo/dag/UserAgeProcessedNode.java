package com.tracholar.recommend.demo.dag;

import com.tracholar.recommend.feature.CatFeature;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.feature.ScalarFeature;
import com.tracholar.recommend.feature.dag.DepNodeMap;
import com.tracholar.recommend.feature.dag.InternalNode;

public class UserAgeProcessedNode extends InternalNode {
    @Override
    public Feature calcValue(DepNodeMap dependence){
        CatFeature<String> age = (CatFeature) dependence.get("age");
        ScalarFeature sage = new ScalarFeature(age.getId() + "#" + age.getValue(), 1.0f);
        return sage;
    }
}
