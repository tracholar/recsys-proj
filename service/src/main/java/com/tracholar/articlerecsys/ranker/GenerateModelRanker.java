package com.tracholar.articlerecsys.ranker;

import com.alibaba.fastjson.JSONObject;
import com.tracholar.articlerecsys.model.RandomModel;
import com.tracholar.recommend.engine.config.Configable;
import com.tracholar.recommend.model.Model;
import com.tracholar.recommend.model.SimpleModelProxy;
import com.tracholar.recommend.model.SimpleScore;
import lombok.Getter;

@Getter
public class GenerateModelRanker extends BaseModelRanker
        implements Configable<JSONObject> {
    private SimpleModelProxy<SimpleScore> modelProxy;

    @Override
    public void init(JSONObject conf) throws Exception {
        String clsName = conf.getString("model");
        Model model = (Model<SimpleScore>) Class.forName(clsName).newInstance();
        modelProxy = new SimpleModelProxy<>(model);

        if(model instanceof Configable){
            ((Configable) model).init(conf.getJSONObject("args"));
        }

    }
}
