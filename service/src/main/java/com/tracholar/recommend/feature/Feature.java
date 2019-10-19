package com.tracholar.recommend.feature;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.data.JsonableData;

import java.io.Serializable;
import java.util.Map;

/**
 * Feature 是对特征的抽象，包括模型预测的特征，召回策略用到的数据
 * 包括ID和VALUE
 */

public abstract class Feature<V>  extends JsonableData
        implements   Serializable, HasId<String> {
    public abstract V getValue();
    public abstract Map<String, Float> flatten();

    public SparseVector toSparseVector() {
        SparseVector vector = new SparseVector();
        Map<String, Float> fv = flatten();
        for(String k : fv.keySet()) {
            vector.put(MurmurHash.getInstance().hash(k), fv.get(k));
        }
        return vector;
    }
}
