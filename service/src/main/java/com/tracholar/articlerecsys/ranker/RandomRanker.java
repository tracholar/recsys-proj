package com.tracholar.articlerecsys.ranker;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.engine.ReRanker;
import com.tracholar.recommend.data.RecallResult;

import java.util.ArrayList;
import java.util.List;

public class RandomRanker implements Ranker, ReRanker {
    @Override
    public List<RankResult> rank(IUser user, List<RecallResult> results, IContext ctx){
        List<RankResult> rs = new ArrayList<>();
        for(int i=0; i<results.size(); i++){
            Article article = (Article) results.get(i);
            article.setRank(i);
            article.setScore((float) Math.random());
            rs.add(article);
        }

        return rs;
    }

    @Override
    public List<RankResult> reRank(IUser user, List<RankResult> results, IContext ctx){
        return results;
    }
}
