package com.tracholar.recommend.feature;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public Feature fromJson(String json, Class cls) {
        return (Feature)JSON.parseObject(json, cls);
    }

    public static Map<String, Float> toMap(List<Feature> feats) {
        Map<String, Float> res = new HashMap<>();
        for(Feature f : feats){
            res.putAll(f.flatten());
        }

        return res;
    }

    public static SparseVector toSparseVector(List<Feature> feats) {
        SparseVector vector = new SparseVector();
        for(Feature f : feats) {
            vector.putAll(f.toSparseVector());
        }
        return vector;
    }

    public static String toLibsvmFormat(List<Feature> feats) {
        StringBuffer sb = new StringBuffer();
        for(Feature f : feats) {
            if(sb.length() > 0) sb.append(" ");
            sb.append(f.toLibsvmFormat());
        }
        return sb.toString();
    }

    public static String toLibffmFormat(List<GroupFeature> feats) {
        StringBuffer sb = new StringBuffer();
        for(GroupFeature f : feats) {
            if(sb.length() > 0) sb.append(" ");
            sb.append(f.toLibFFMFormat());
        }
        return sb.toString();
    }

}
