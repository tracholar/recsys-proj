package com.tracholar.articlerecsys.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.*;
import com.tracholar.recommend.model.SimpleScore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Article extends JsonableData
        implements IItem<String>, RecallResult<String>, RankResult<String> {
    private String id;
    private String title;
    private String content;
    private String url;
    private String author;

    public Article(String id) {
        this.id = id;
    }
    public Article(String id, String title) {
        this.id = id;
        this.title = title;
    }
    private SimpleScore<Float> score;
    private int rank;

}
