package com.tracholar.articlerecsys.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
public class Rss {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String link;
    private String body;
    private String date;
    private Float score;
    private String site;
}
