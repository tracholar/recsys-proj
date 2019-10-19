package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.*;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.model.Model;
import com.tracholar.recommend.model.ModelProxy;
import com.tracholar.recommend.model.PredictResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ModelRanker 是在推荐engine的模型RANKER中调用的。
 * 如果ModelRanker部署在单独的服务中，则就像在推荐引擎的RANKER调用一样。
 */
public abstract class ModelRanker<R extends RecallResult, RK extends RankResult, P extends PredictResult>
        implements Ranker<R,RK> {
    protected abstract ModelProxy<P> getModelProxy();
    protected abstract UserFeatureFetcher getUserFeatFetcher();
    protected abstract ItemFeatureFetcher getItemFeatFetcher();
    protected abstract ContextFeatureFetcher getContextFeatFetcher();

    protected abstract List<RK> createResult(List<P> preds);

    protected abstract void logFeatures(UserFeature u, List<ItemFeature> i, ContextFeature c);

    @Override
    public List<RK> rank(IUser user, List<R> results, IContext ctx){
        ModelProxy<P> model = getModelProxy();
        UserFeatureFetcher uFetcher = getUserFeatFetcher();
        ItemFeatureFetcher iFetcher = getItemFeatFetcher();
        ContextFeatureFetcher ctxFetcher = getContextFeatFetcher();

        // 拉取用户特性、item特征、上下文特征
        UserFeature userFeature = uFetcher.fetch(user);

        List<HasId> items = results.stream().map(e -> (HasId) e).collect(Collectors.toList());
        List<ItemFeature> itemFeatures = iFetcher.fetch(items);

        ContextFeature ctxFeat = ctxFetcher.fetch(ctx);

        // 模型预测
        List<P> preds = model.predict(userFeature, itemFeatures, ctxFeat);

        // 打日志，生成特征数据
        logFeatures(userFeature, itemFeatures, ctxFeat);


        return createResult(preds);
    }
}
