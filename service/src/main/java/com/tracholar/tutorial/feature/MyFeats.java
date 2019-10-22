package com.tracholar.tutorial.feature;

import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class MyFeats extends JsonableData implements UserFeature<String>,
        ItemFeature<String>, ContextFeature<String> {
    private String id;
    private List<Feature> features;

    public List<Feature> getFeatures(){
        return features.stream().filter(e -> e.getValue() != null)
                .collect(Collectors.toList());
    }
}
