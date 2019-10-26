package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.engine.DetailFetcher;
import com.tracholar.recommend.engine.config.Autoload;

import java.util.ArrayList;
import java.util.List;

@Autoload
public class DemoDetailFetcher implements DetailFetcher<HasId, DemoItem> {
    @Override
    public List<DemoItem> fetch(List<HasId> arr){
        List<DemoItem> items = new ArrayList<>();
        for(HasId<String> h : arr) {
            DemoItem item = new DemoItem(h.getId(), h.getId() + "@" + System.currentTimeMillis());
            items.add(item);
        }

        return items;
    }
}
