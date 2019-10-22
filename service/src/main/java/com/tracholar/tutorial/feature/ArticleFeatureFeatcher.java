package com.tracholar.tutorial.feature;

import com.tracholar.recommend.ranker.*;
import com.tracholar.tutorial.data.Item;
import com.tracholar.tutorial.data.ReqContext;
import com.tracholar.tutorial.data.User;

import java.util.List;

/**
 * 完成特征拉取类，获取特征
 */
public class ArticleFeatureFeatcher implements
        UserFeatureFetcher<User>,
        ItemFeatureFetcher<Item>,
        ContextFeatureFetcher<ReqContext> {
    public UserFeature fetch(User user){
        // TODO 获取用户特征
        return null;
    }
    public List<ItemFeature> fetch(List<Item> arr){
        // TODO 获取item特征
        return null;
    }
    public ContextFeature fetch(ReqContext ctx){
        // TODO 获取上下文特征
        return null;
    }
}
