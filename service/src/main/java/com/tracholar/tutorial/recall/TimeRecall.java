package com.tracholar.tutorial.recall;

import com.tracholar.recommend.engine.Recall;
import com.tracholar.tutorial.data.Item;
import com.tracholar.tutorial.data.ReqContext;
import com.tracholar.tutorial.data.User;
import java.util.List;


public class TimeRecall implements Recall<User, ReqContext, Item> {

    @Override
    public List<Item> recall(User user, ReqContext ctx){
        // TODO 实现召回逻辑
        return null;
    }
}
