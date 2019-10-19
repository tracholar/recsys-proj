package com.tracholar.recommend.engine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.abtest.ABTestable;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PROTECTED)
public abstract class ConfigurableSimpleRecEngine extends SimpleRecEngine {
    @Getter
    private String name;
    private ABTestProxy abTestProxy;
    private DetailFetcher detailFetcher;
    private List<Recall> recalls = new ArrayList<>();
    private List<Merge> merges = new ArrayList<>();
    private List<Filter> filters = new ArrayList<>();
    private List<Ranker> rankers = new ArrayList<>();
    private List<ReRanker> reRankers = new ArrayList<>();

    public void init(InputStream is) throws Exception{
        //通过配置文件构造一个推荐引擎
        String confString = IOUtils.toString(is, "UTF-8");
        JSONObject conf = JSON.parseObject(confString);

        name = conf.getString("name");

        //abtest
        abTestProxy = (ABTestProxy)Class.forName(conf.getString("abtest")).newInstance();
        detailFetcher = (DetailFetcher)Class.forName(conf.getString("detailFetcher")).newInstance();

        //recall
        loadComponents(recalls, conf.getJSONArray("recalls"));

        //filters
        loadComponents(filters, conf.getJSONArray("filters"));

        //merges
        loadComponents(merges, conf.getJSONArray("merges"));

        //rankers
        loadComponents(rankers, conf.getJSONArray("rankers"));

        //re-rankers
        loadComponents(reRankers, conf.getJSONArray("reRankers"));


    }

    private <T> void loadComponents(List<T> arr, JSONArray compConfs)
            throws Exception{
        for(int i=0; i<compConfs.size(); i++) {
            JSONObject c = compConfs.getJSONObject(i);
            T strategy = (T) Class.forName(c.getString("class")).newInstance();

            if(strategy instanceof ABTestable) {
                ABTestKey key = new ABTestKey(c.getString("abtestLayerKey"), c.getString("abtestFlowKey"));
                ((ABTestable) strategy).setAbTestKey(key);
            }
            arr.add(strategy);
        }
    }
}
