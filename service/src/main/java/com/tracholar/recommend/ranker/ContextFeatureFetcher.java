package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IContext;

public interface ContextFeatureFetcher {
    ContextFeature fetch(IContext ctx);
}
