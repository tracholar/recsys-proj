package com.tracholar.articlerecsys.filter;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.engine.Filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HistoryFilter implements Filter<User, ReqContext, Article> {
    @Override
    public List<Article> filter(User user,
                                     List<Article> results,
                                     ReqContext ctx){
        Set<String> history = new HashSet(user.getHistory());
        List<Article> filterRes = new ArrayList<>();

        if(history == null) {
            filterRes.addAll(results);
            return filterRes;
        }
        for(Article r : results) {
            if(history.contains(r.getId())) continue;
            filterRes.add(r);
        }
        return filterRes;
    }
}
