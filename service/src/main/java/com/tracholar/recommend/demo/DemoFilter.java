package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.User;
import com.tracholar.recommend.engine.Filter;
import com.tracholar.recommend.engine.RecallResult;

import java.util.List;

public class DemoFilter implements Filter {
    @Override
    public List<RecallResult> filter(User user,
                                     List<RecallResult> results,
                                     Context ctx){
        if(user.getId().equals("1")){
            return null;
        }
        return results;
    }

}
