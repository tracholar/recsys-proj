package com.tracholar.recommend.feature;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class SparseVector extends HashMap<Long, Float> {
    public String toLibsvm() {
        StringBuffer sb = new StringBuffer();
        for(Long k : keySet()) {
            if(sb.length() > 0) sb.append(" ");
            if(k == null || get(k) == null) continue;
            sb.append(k + ":" + get(k));
        }
        return sb.toString();
    }
}
