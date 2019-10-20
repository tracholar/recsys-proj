package com.tracholar.recommend.engine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.engine.config.ComponentConfig;
import com.tracholar.recommend.engine.config.Configable;
import com.tracholar.recommend.engine.config.RecEngineConfig;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author tracholar.github.io
 * ConfigurableSimpleRecEngine 抽象了通过配置生成推荐引擎所需要的模块。
 * 已经是一个独立的推荐引擎了！！
 */
@Getter(AccessLevel.PROTECTED)
public class ConfigurableSimpleRecEngine extends SimpleRecEngine {
    @Getter
    private String name;
    private ABTestProxy abTestProxy;
    private DetailFetcher detailFetcher;
    private List<Recall> recalls = new ArrayList<>();
    private List<Merge> merges = new ArrayList<>();
    private List<Filter> filters = new ArrayList<>();
    private List<Ranker> rankers = new ArrayList<>();
    private List<ReRanker> reRankers = new ArrayList<>();

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void init(RecEngineConfig conf) throws EngineInitialException{
        logger.debug("Load rec-engine with config: {}", conf);
        try {
            //通过配置文件构造一个推荐引擎
            name = conf.getName();

            //abtest
            abTestProxy = (ABTestProxy) Class.forName(conf.getAbtest().getClassName()).newInstance();
            if(abTestProxy instanceof Configable) {
                ((Configable) abTestProxy).init(conf.getAbtest().getArgs());
            }
            detailFetcher = (DetailFetcher) Class.forName(conf.getDetailFetcher().getClassName()).newInstance();
            if(detailFetcher instanceof Configable) {
                ((Configable) detailFetcher).init(conf.getDetailFetcher().getArgs());
            }

            //recall
            loadComponents(recalls, conf.getRecalls());

            //filters
            loadComponents(filters, conf.getFilters());

            //merges
            loadComponents(merges, conf.getMerges());

            //rankers
            loadComponents(rankers, conf.getRankers());

            //re-rankers
            loadComponents(reRankers, conf.getReRankers());
        }catch (Exception e){
            throw new EngineInitialException(e);
        }
    }

    private <T> void loadComponents(List<T> arr, List<ComponentConfig> compConfs)
            throws Exception{
        for(int i=0; i<compConfs.size(); i++) {
            ComponentConfig c = compConfs.get(i);
            T strategy = (T) Class.forName(c.getClassName()).newInstance();

            if(strategy instanceof ABTestable && c.getAbTestKey() != null) {
                ABTestKey key = c.getAbTestKey();
                ((ABTestable) strategy).setAbTestKey(key);
            }
            if(strategy instanceof Configable) {
                ((Configable) strategy).init(c.getArgs());
            }
            arr.add(strategy);
        }
    }
}
