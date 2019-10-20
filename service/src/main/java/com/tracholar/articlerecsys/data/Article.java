package com.tracholar.articlerecsys.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.data.RecallResult;
import com.tracholar.recommend.model.PredictResult;
import com.tracholar.recommend.model.SimpleScore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Article extends JsonableData
        implements IItem<String>, RecallResult<String>, RankResult<String>, PredictResult<String> {
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
    private SimpleScore score;
    @JSONField
    private int rank;

}
