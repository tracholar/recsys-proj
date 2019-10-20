package com.tracholar.recommend.model;

import com.tracholar.recommend.data.HasScore;
import com.tracholar.recommend.feature.Feature;
import com.tracholar.recommend.ranker.ContextFeature;
import com.tracholar.recommend.ranker.ItemFeature;
import com.tracholar.recommend.ranker.UserFeature;

import java.util.LinkedList;
import java.util.List;

public class SimpleModelProxy<S extends HasScore>
        implements ModelProxy<S> {
    private Model<S> model;

    public SimpleModelProxy(Model<S> model){
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
    public List<S> predict(UserFeature u, List<ItemFeature> i, ContextFeature c){
        List<List<Feature>> features = featureExtract(u, i, c);
        List<S> preds = model.predict(features);

        assert preds.size() == i.size();

        return preds;
    }
}
