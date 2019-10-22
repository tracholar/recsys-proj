package com.tracholar.recommend.feature;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class GroupFeature extends Feature<List<Feature>> {
    @JSONField
    private Group group;
    @JSONField
    private List<Feature> value;

    public String getId() {
        return group.getName();
    }

    public boolean add(Feature f) {
        return value.add(f);
    }

    public boolean addAll(List<Feature> fs) {
        return value.addAll(fs);
    }

    public GroupFeature(int gid, String name) {
        this.group = new Group(gid, name);
        this.value = new LinkedList<>();
    }

    public GroupFeature(int gid, String name, List<Feature> value) {
        this.group = new Group(gid, name);
        this.value = value;
    }

    @Override
    public Map<String, Float> flatten() {
        Map<String, Float> map = new HashMap<>();
        for(Feature v : value) {
            Map<String, Float> fv = v.flatten();
            for(String kk : fv.keySet()) {
                if(fv.get(kk) != null) {
                    map.put(getId() + ":" + kk, fv.get(kk));
                }
            }
        }
        return map;
    }

    /**
     * 将id作为fieldId
     * @param m m是idx所占的比特数！最终的idx第m位是特征id，剩下的高位是fieldId
     * @return
     */
    public SparseVector toGroupSparseVector(int m) {
        SparseVector vector = new SparseVector();
        int fieldId = group.getId();
        for(Feature f : value) {
            Map<String, Float> fmap = f.flatten();
            for(String k : fmap.keySet()){
                long idx = fieldId;
                idx <<= m;
                idx += Hash.hash(k) & ((1L << m) - 1L); // TODO 检查下正确性
                vector.put(idx, fmap.get(k));
            }
        }
        return vector;
    }

    public String toLibFFMFormat() {
        return toLibFFMFormat(1L<<32);
    }
    public String toLibFFMFormat(long m){
        StringBuffer sb = new StringBuffer();
        int fieldId = group.getId();
        for(Feature f : value) {
            Map<String, Float> fmap = f.flatten();
            for(String k : fmap.keySet()){
                if(sb.length() > 0) sb.append(" ");
                sb.append(fieldId + ":" + (Hash.hash(k) % m) + ":" + fmap.get(k));
            }
        }
        return sb.toString();
    }
}
