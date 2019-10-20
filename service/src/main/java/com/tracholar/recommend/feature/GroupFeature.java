package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class GroupFeature extends Feature<List<Feature>> {
    @JSONField
    private String id;
    @JSONField
    private List<Feature> value;

    @Override
    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        for(Feature v : value) {
            Map<String, Float> fv = v.flatten();
            for(String kk : fv.keySet()) {
                map.put(id + ":" + kk, fv.get(kk));
            }
        }
        return map;
    }

    /**
     * 将id作为fieldId
     * @return
     */
    public SparseVector toGroupSparseVector() {
        SparseVector vector = new SparseVector();
        int fieldId = 0;
        try{
            fieldId = Integer.parseInt(id);
        }catch (NumberFormatException e){
            fieldId = Utils.getFid(id);
        }
        for(Feature f : value) {
            Map<String, Float> fmap = f.flatten();
            for(String k : fmap.keySet()){
                vector.put(Utils.getFid(fieldId, k), fmap.get(k));
            }
        }
        return vector;
    }

    public String toLibFFMFormat(){
        StringBuffer sb = new StringBuffer();
        int fieldId = 0;
        try{
            fieldId = Integer.parseInt(id);
        }catch (NumberFormatException e){
            fieldId = Utils.getFid(id);
        }
        for(Feature f : value) {
            Map<String, Float> fmap = f.flatten();
            for(String k : fmap.keySet()){
                if(sb.length() > 0) sb.append(" ");
                sb.append(fieldId + ":" + Utils.getFid(fieldId, k) + ":" + fmap.get(k));
            }
        }
        return sb.toString();
    }

    public GroupFeature toGroupFeature(){
        return this;
    }
}
