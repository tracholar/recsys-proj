package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.engine.DetailFetcher;

import java.util.ArrayList;
import java.util.List;

public class DemoDetailFetcher implements DetailFetcher<DemoItem> {
    @Override
    public List<DemoItem> fetchDetail(List<HasId> arr){
        List<DemoItem> items = new ArrayList<>();
        for(HasId h : arr) {
            DemoItem item = new DemoItem(h.getId(), h.getId() + "@" + System.currentTimeMillis());
            items.add(item);
        }

        return items;
    }
}
