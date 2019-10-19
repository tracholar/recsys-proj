package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Filter;
import com.tracholar.recommend.data.RecallResult;

import java.util.List;

public class DemoFilter implements Filter<IUser, IContext, RecallResult> {
    @Override
    public List<RecallResult> filter(IUser user,
                                     List<RecallResult> results,
                                     IContext ctx){
        if(user.getId().equals("1")){
            return null;
        }
        return results;
    }

}
