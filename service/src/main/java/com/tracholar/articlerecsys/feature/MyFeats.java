package com.tracholar.articlerecsys.feature;

import com.tracholar.recommend.feature.CatFeature;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
@AllArgsConstructor
public class MyFeats implements UserFeature<String>,
        ItemFeature<String>, ContextFeature<String> {
    private String id;
    private List<Feature> features;
}
