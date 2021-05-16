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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootApplication
@RestController
public class ArticleRecEngineWebAPI {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ArticleRecEngine engine;

    public ArticleRecEngineWebAPI() throws Exception{
        engine = new ArticleRecEngine();
    }

    private User buildUser(HttpServletRequest request){
        String uid = request.getParameter("uid");
        User user = new User(uid, "dafad-fad-f-asdf-a-sd");
        return user;
    }

    private ReqContext buildContext(HttpServletRequest request){
        return new ReqContext("ADF-HJKH");
    }

    @RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
    public List<Article> webApi(HttpServletRequest request) {
        User user = buildUser(request);
        ReqContext ctx = buildContext(request);

        List<Article> articles = engine.recommend(user, ctx);

        return articles;
    }

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView indexView = new ModelAndView();
        indexView.setViewName("index");
        return indexView;
    }


    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory =
                new TomcatEmbeddedServletContainerFactory();
        factory.setPort(9999);

        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArticleRecEngineWebAPI.class, args);
    }
}
