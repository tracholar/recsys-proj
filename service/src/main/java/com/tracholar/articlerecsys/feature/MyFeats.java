package com.tracholar.articlerecsys.feature;

import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.feature.CatFeature;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
public class MyFeats extends JsonableData implements UserFeature<String>,
        ItemFeature<String>, ContextFeature<String> {
    @Getter
    private String id;
    private List<Feature> features;

    @Override
    public List<Feature> getFeatures(){
        return features.stream().filter(e -> e.getValue() != null)
                .collect(Collectors.toList());
    }

    public boolean add(Feature f) {
        if(f.getId() == null || f.getValue() == null) return false;
        return features.add(f);
    }
}
