package com.tracholar.tutorial.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.data.RankResult;
import com.tracholar.recommend.data.RecallResult;
import com.tracholar.recommend.model.SimpleScore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Item extends JsonableData
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

    public Item(String id, String title) {
        this.id = id;
        this.title = title;
    }
    @JSONField
    private SimpleScore<Float> score;
    @JSONField
    private int rank;

}
