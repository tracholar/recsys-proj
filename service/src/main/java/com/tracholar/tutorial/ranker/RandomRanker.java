package com.tracholar.tutorial.ranker;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.engine.ReRanker;
import com.tracholar.tutorial.data.Item;

import java.util.List;

public class RandomRanker implements
        Ranker<Item, Item>, ReRanker<Item> {
    @Override
    public List<Item> rank(IUser user, List<Item> results, IContext ctx){
        // TODO 排序
        return null;
    }

    @Override
    public List<Item> reRank(IUser user, List<Item> results, IContext ctx){
        // TODO 重排序
        return null;
    }
}
