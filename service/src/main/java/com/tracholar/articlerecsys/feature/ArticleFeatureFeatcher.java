package com.tracholar.articlerecsys.feature;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.feature.*;
import com.tracholar.recommend.ranker.*;

import java.util.LinkedList;
import java.util.List;

/**
 * 全部使用group feature
 */
public class ArticleFeatureFeatcher implements
        UserFeatureFetcher<User>,
        ItemFeatureFetcher<Article>,
        ContextFeatureFetcher<ReqContext> {
    public UserFeature fetch(User user){
        List<Feature> f = new LinkedList<>();

        // 这里造个简单特征，正常应该是查询外部存储来获取用户特征
        GroupFeature profile = new GroupFeature(1,"profile");
        profile.add(new CatFeature("uid", user.getId()));
        profile.add(new CatFeature("deviceId", user.getDeviceId()));
        f.add(profile);

        GroupFeature historyFeat = new ListFeature<>("history", user.getHistory()).toGroupFeature(2);
        f.add(historyFeat);

        MyFeats feats = new MyFeats(user.getId(), f);

        return feats;
    }
    public List<ItemFeature> fetch(List<Article> arr){
        List<ItemFeature> featLists = new LinkedList<>();

        // 这里造个简单特征，正常应该是查询外部存储来获取特征
        for(Article a : arr) {
            List<Feature> f = new LinkedList<>();

            GroupFeature articleFeat = new GroupFeature(3, "aritcle");
            articleFeat.add(new CatFeature("article_id", a.getId()));
            //articleFeat.add(new CatFeature("author", a.getAuthor()));

            f.add(articleFeat);

            MyFeats feats = new MyFeats(a.getId(), f);

            featLists.add(feats);
        }
        return featLists;
    }
    public ContextFeature fetch(ReqContext ctx){
        List<Feature> ctxFeats = new LinkedList<>();

        GroupFeature feat = new GroupFeature(4, "ctx");
        feat.add(new ScalarFeature("lat", ctx.getLat()));
        feat.add(new ScalarFeature("lng", ctx.getLng()));
        feat.add(new CatFeature("cityId", ctx.getCityId()));
        feat.add(new CatFeature("weekday", ctx.getWeekday()));
        ctxFeats.add(feat);

        return new MyFeats(ctx.getId(), ctxFeats);
    }
}
