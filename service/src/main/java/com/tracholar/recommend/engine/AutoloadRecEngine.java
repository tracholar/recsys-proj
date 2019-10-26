package com.tracholar.recommend.engine;

import com.tracholar.recommend.abtest.ABTestConf;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestProxy;
import com.tracholar.recommend.engine.config.Autoload;
import com.tracholar.recommend.engine.config.ComponentConfig;
import com.tracholar.recommend.engine.config.RecEngineConfig;
import org.reflections.Reflections;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AutoloadRecEngine extends ConfigurableSimpleRecEngine {
    private List<ComponentConfig> getComponentConfig(Reflections reflections,
                                                     Class cls) {

        Set<Class<?>> classes = reflections.getSubTypesOf(cls);
        List<ComponentConfig> conf = classes.stream()
                .filter(c -> c.isAnnotationPresent(Autoload.class))
                .map(e -> {
                    ComponentConfig c = new ComponentConfig();
                    c.setClassName(e.getName());
                    c.setName(e.getSimpleName());
                    if(e.isAnnotationPresent(ABTestConf.class)){
                        ABTestConf info = e.getAnnotation(ABTestConf.class);
                        ABTestKey key = new ABTestKey(info.layerKey(), info.flowKey());
                        c.setAbTestKey(key);
                    }
                    return c;
                }).collect(Collectors.toList());
        return conf;
    }
    public void init(String name, String packageName)
            throws EngineInitialException {
        RecEngineConfig conf = new RecEngineConfig();
        conf.setName(name);

        Reflections reflections = new Reflections(packageName);

        List<ComponentConfig> c = getComponentConfig(reflections, ABTestProxy.class);
        if(c.size() != 1){
            throw new EngineInitialException("ABTestProxy should be configured to only one class, but found " + c.size() + ": " + c);
        }
        conf.setAbtest(c.get(0));

        c = getComponentConfig(reflections, DetailFetcher.class);
        if(c.size() != 1){
            throw new EngineInitialException("DetailFetcher should be configured to only one class, but found " + c.size() + ": " + c);
        }
        conf.setDetailFetcher(c.get(0));

        conf.setRecalls(getComponentConfig(reflections, Recall.class));
        conf.setMerges(getComponentConfig(reflections, Merge.class));
        conf.setFilters(getComponentConfig(reflections, Filter.class));
        conf.setRankers(getComponentConfig(reflections, Ranker.class));
        conf.setReRankers(getComponentConfig(reflections, ReRanker.class));

        super.init(conf);
    }
}
