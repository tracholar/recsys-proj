package com.tracholar.recommend.model;

import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SimpleModelProxy<P extends PredictResult>
        implements ModelProxy<P> {
    private Model<P> model;

    public SimpleModelProxy(Model<P> model){
        this.model = model;
    }

    private List<List<Feature>> featureExtract(UserFeature u, List<ItemFeature> i, ContextFeature c){
        List<List<Feature>> feats = new LinkedList<>();
        for(ItemFeature itf : i) {
            List<Feature> fs = new LinkedList<>();
            fs.addAll(itf.getFeatures());
            fs.addAll(u.getFeatures());
            fs.addAll(c.getFeatures());

            feats.add(fs);
        }

        return feats;
    }
    public List<P> predict(UserFeature u, List<ItemFeature> i, ContextFeature c){
        List<List<Feature>> features = featureExtract(u, i, c);
        return model.predict(features);
    }
}
