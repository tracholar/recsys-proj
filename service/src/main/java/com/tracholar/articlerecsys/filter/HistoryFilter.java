package com.tracholar.articlerecsys.filter;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Filter;
import com.tracholar.recommend.data.RecallResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HistoryFilter implements Filter<User, ReqContext, Article> {
    @Override
    public List<RecallResult> filter(User user,
                                     List<Article> results,
                                     ReqContext ctx){
        Set<String> history = user.getHistory();
        List<RecallResult> filterRes = new ArrayList<>();

        if(history == null) {
            filterRes.addAll(results);
            return filterRes;
        }
        for(RecallResult r : results) {
            if(history.contains(r.getId())) continue;
            filterRes.add(r);
        }
        return filterRes;
    }
}
