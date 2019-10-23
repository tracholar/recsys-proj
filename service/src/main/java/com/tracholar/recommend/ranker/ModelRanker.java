package com.tracholar.recommend.ranker;

import com.alibaba.fastjson.JSONObject;
import com.tracholar.recommend.data.*;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.model.ModelProxy;
import com.tracholar.recommend.model.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ModelRanker 是在推荐engine的模型RANKER中调用的。
 * 如果ModelRanker部署在单独的服务中，则就像在推荐引擎的RANKER调用一样。
 */
public abstract class ModelRanker<R extends RecallResult, RK extends RankResult,
        S extends Score>
        implements Ranker<R,RK> {
    protected abstract ModelProxy<S> getModelProxy();
    protected abstract UserFeatureFetcher getUserFeatFetcher();
    protected abstract ItemFeatureFetcher getItemFeatFetcher();
    protected abstract ContextFeatureFetcher getContextFeatFetcher();

    /** 将 score  和 recallresult 拼成一个rankerresult，
     * ranker result 就是 hasscore + hasid
     * @param preds 预测得分
     * @param items 召回的item列表
     * @return
     */
    protected abstract List<RK> createResult(List<S> preds, List<R> items);

    protected abstract void logFeatures(UserFeature u, List<ItemFeature> i, ContextFeature c);

    @Override
    public List<RK> rank(IUser user, List<R> results, IContext ctx){
        ModelProxy<S> model = getModelProxy();
        UserFeatureFetcher uFetcher = getUserFeatFetcher();
        ItemFeatureFetcher<R> iFetcher = getItemFeatFetcher();
        ContextFeatureFetcher ctxFetcher = getContextFeatFetcher();

        // 拉取用户特性、item特征、上下文特征
        UserFeature userFeature = uFetcher.fetch(user);

        List<ItemFeature> itemFeatures = iFetcher.fetch(results);

        ContextFeature ctxFeat = ctxFetcher.fetch(ctx);

        // 模型预测
        List<S> preds = model.predict(userFeature, itemFeatures, ctxFeat);

        // 打日志，生成特征数据
        logFeatures(userFeature, itemFeatures, ctxFeat);


        return createResult(preds, results);
    }
}
