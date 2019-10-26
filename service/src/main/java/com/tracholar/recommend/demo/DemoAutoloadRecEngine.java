package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.engine.AutoloadRecEngine;
import com.tracholar.recommend.engine.EngineInitialException;
import com.tracholar.recommend.engine.RecEngine;

import java.util.List;

public class DemoAutoloadRecEngine extends AutoloadRecEngine {
    public DemoAutoloadRecEngine() throws EngineInitialException {
        super.init(getClass().getSimpleName(), getClass().getPackage().getName());
    }

    public static void main(String[] args) throws Exception {
        RecEngine engine = new DemoAutoloadRecEngine();
        DemoUser user = new DemoUser("12", "admin");
        DemoContext ctx = new DemoContext("" + System.currentTimeMillis());
        List<IItem> items = engine.recommend(user, ctx);

        System.out.println("traceId:" + ctx.getId());
        System.out.println("user:" + user);
        System.out.println("items:" + items);
    }
}
