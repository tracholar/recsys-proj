package com.tracholar.tutorial.filter;

import com.tracholar.recommend.engine.Filter;
import com.tracholar.tutorial.data.Item;
import com.tracholar.tutorial.data.ReqContext;
import com.tracholar.tutorial.data.User;

import java.util.List;

public class HistoryFilter implements Filter<User, ReqContext, Item> {
    @Override
    public List<Item> filter(User user,
                             List<Item> results,
                             ReqContext ctx){
        // TODO 创建过滤器
        return null;
    }
}
