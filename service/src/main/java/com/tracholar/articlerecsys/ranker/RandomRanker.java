package com.tracholar.articlerecsys.ranker;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.tracholar.articlerecsys.data.Article;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.engine.ReRanker;
import com.tracholar.recommend.engine.config.Configable;
import com.tracholar.recommend.model.SimpleScore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RandomRanker implements
        Ranker<Article, Article>, ReRanker<Article>, Configable<JSONObject> {
    @Override
    public List<Article> rank(IUser user, List<Article> results, IContext ctx){
        List<Article> rs = new ArrayList<>();
        for(int i=0; i<results.size(); i++){
            Article article = results.get(i);
            article.setRank(i);
            article.setScore(new SimpleScore((float) Math.random()));
            rs.add(article);
        }

        return rs;
    }

    private int limit = 10;

    @Override
    public void init(JSONObject conf){
        limit = TypeUtils.castToInt(conf.getOrDefault("limit", 10));
    }

    @Override
    public List<Article> reRank(IUser user, List<Article> results, IContext ctx){
        List<Article> res = new LinkedList<>();
        for(int i =0 ; i < limit && i < results.size(); i++){
            res.add(results.get(i));
        }
        return res;
    }
}
