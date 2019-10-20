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
    @JSONField
    private String id;
    @JSONField
    private String title;
    @JSONField
    private String content;
    @JSONField
    private String url;
    @JSONField
    private String author;

    public Article(String id, String title) {
        this.id = id;
        this.title = title;
    }
    @JSONField
    private SimpleScore<Float> score;
    @JSONField
    private int rank;

}
