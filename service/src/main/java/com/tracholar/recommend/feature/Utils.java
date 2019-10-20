package com.tracholar.recommend.feature;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private static int m = 32;
    public static int getFid(String id) {
        int k = Hash.hash(id);
        return k;
    }
    public static long getFid(int fid, String id){
        long idx = fid;
        idx <<= m;
        idx += getFid(id);
        return idx;
    }
    public static int getFieldId(long idx) {
        return (int)(idx >> m);
    }
    public static int getId(long idx) {
        return (int) ((idx << m) >> m);
    }

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
