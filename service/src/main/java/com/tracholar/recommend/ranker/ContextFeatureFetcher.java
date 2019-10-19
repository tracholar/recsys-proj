package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IContext;

public interface ContextFeatureFetcher<C extends IContext> {
    ContextFeature fetch(C ctx);
}
