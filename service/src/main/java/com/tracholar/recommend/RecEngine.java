package com.tracholar.recommend;

import java.util.List;

public interface RecEngine {
    String getName();
    List<Item> recommend(User user, Context ctx);
}
