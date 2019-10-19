package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.IUser;

import java.util.List;

public interface RecEngine {
    String getName();
    List<IItem> recommend(IUser user, IContext ctx);
}
