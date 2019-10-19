package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IUser;


public interface UserFeatureFetcher {
    UserFeature fetch(IUser user);
}
