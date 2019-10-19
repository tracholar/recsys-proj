package com.tracholar.recommend.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tracholar.recommend.data.Item;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.engine.*;
import lombok.Getter;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DemoSimpleRecEngine extends SimpleRecEngine {

    private String name;
    private DemoABTestProxy abTestProxy;
    private DemoDetailFetcher detailFetcher;
    private List<Recall> recalls = new ArrayList<>();
    private List<Merge> merges = new ArrayList<>();
    private List<Filter> filters = new ArrayList<>();
    private List<Ranker> rankers = new ArrayList<>();
    private List<ReRanker> reRankers = new ArrayList<>();

    public DemoSimpleRecEngine() throws Exception{
        //通过配置文件构造一个推荐引擎
        InputStream is = getClass().getResourceAsStream("/demo_simple_engine.json");
        String confString = IOUtils.toString(is, "UTF-8");
        JSONObject conf = JSON.parseObject(confString);

        name = conf.getString("name");

        //abtest
        abTestProxy = new DemoABTestProxy();
        detailFetcher = new DemoDetailFetcher();

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

    public static void main(String[] args) throws Exception{
        DemoSimpleRecEngine engine = new DemoSimpleRecEngine();
        DemoUser user = new DemoUser("12", "admin");
        DemoContext ctx = new DemoContext("" + System.currentTimeMillis());
        List<Item> items = engine.recommend(user, ctx);

        System.out.println("traceId:" + ctx.getTraceId());
        System.out.println("user:" + user);
        System.out.println("items:" + items);
    }
}
