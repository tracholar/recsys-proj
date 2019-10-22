package com.tracholar.tutorial;

import com.tracholar.recommend.engine.DetailFetcher;
import com.tracholar.tutorial.data.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ArticleFetcher implements DetailFetcher<Item, Item> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Item> fetch(List<Item> arr){
        // TODO 拉取详情
        return null;
    }

}
