package com.tracholar.articlerecsys.filter;

import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Filter;
import com.tracholar.recommend.engine.RecallResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HistoryFilter implements Filter {
    @Override
    public List<RecallResult> filter(IUser iuser,
                                     List<RecallResult> results,
                                     IContext ctx){
        User user = (User) iuser;
        Set<String> history = user.getHistory();
        List<RecallResult> filterRes = new ArrayList<>();

        if(history == null) return results;
        for(RecallResult r : results) {
            if(history.contains(r.getId())) continue;
            filterRes.add(r);
        }
        return filterRes;
    }
}
