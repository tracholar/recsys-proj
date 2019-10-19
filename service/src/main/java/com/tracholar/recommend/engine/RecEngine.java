package com.tracholar.recommend.engine;

import com.tracholar.recommend.data.Context;
import com.tracholar.recommend.data.Item;
import com.tracholar.recommend.data.User;

import java.util.List;

public interface RecEngine {
    String getName();
    List<Item> recommend(User user, Context ctx);
}
