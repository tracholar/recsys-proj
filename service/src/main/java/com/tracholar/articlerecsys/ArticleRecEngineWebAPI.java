package com.tracholar.articlerecsys;

import com.alibaba.fastjson.JSON;
import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ArticleRecEngineWebAPI {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ArticleRecEngine engine;

    public ArticleRecEngineWebAPI() throws Exception{
        engine = new ArticleRecEngine();
    }

    @RequestMapping(value = "/", produces = "application/json; charset=UTF-8")
    public List<Article> webApi() {
        User user = new User("123", "dafad-fad-f-asdf-a-sd");

        List<Article> articles = engine.recommend(user, new ReqContext("ADF-HJKH"));
        logger.debug(JSON.toJSONString(articles, true));

        return articles;
    }


    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory =
                new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8888);
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArticleRecEngineWebAPI.class, args);
    }
}
