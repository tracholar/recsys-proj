package com.tracholar.articlerecsys.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
public class TestRss implements CommandLineRunner {
    @Autowired
    private RssRepository repository;

    private Article article;

    public void getRss(){
        System.out.println(repository.getClass().getName());
        System.out.println(repository.findOne(200L));
        System.out.println(article);
        //System.out.println(repository.findByTitleLike("%知乎%"));

        System.out.println(repository.getRss("%知乎%"));
    }

    @Override
    public void run(String ... args) {
        getRss();
    }
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TestRss.class);
        app.setWebEnvironment(false);
        app.run(args);

    }
}
