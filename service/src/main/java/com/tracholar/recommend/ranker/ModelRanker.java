package com.tracholar.recommend.ranker;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.data.RecallResult;
import com.tracholar.recommend.engine.Ranker;
import com.tracholar.recommend.model.Model;

import java.util.List;

/**
 * ModelRanker 是在推荐engine的模型RANKER中调用的。
 * 如果ModelRanker部署在单独的服务中，则就像在推荐引擎的RANKER调用一样。
 */
public abstract class ModelRanker implements Ranker {
    abstract Model getModel();

    @Override
    public List<RankResult> rank(IUser user, List<RecallResult> results, IContext ctx){
        Model model = getModel();
        return null;
    }
}
