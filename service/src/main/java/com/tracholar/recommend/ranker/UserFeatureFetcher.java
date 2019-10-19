package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IUser;


public interface UserFeatureFetcher<U> {
    UserFeature fetch(U user);
}
