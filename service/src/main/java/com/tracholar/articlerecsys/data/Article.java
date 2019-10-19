package com.tracholar.articlerecsys.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.engine.RankResult;
import com.tracholar.recommend.engine.RecallResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Article extends JsonableData
        implements IItem<Long>, RecallResult<Long>, RankResult<Long> {
    @JSONField
    private Long id;
    @JSONField
    private String title;
    @JSONField
    private String content;
    @JSONField
    private String url;
    @JSONField
    private String author;

    public Article(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @JSONField
    private float score;
    @JSONField
    private int rank;

}
