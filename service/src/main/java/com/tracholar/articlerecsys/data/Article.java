package com.tracholar.articlerecsys.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.tracholar.recommend.data.IItem;
import com.tracholar.recommend.data.JsonableData;
import com.tracholar.recommend.engine.RecallResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article extends JsonableData implements IItem, RecallResult {
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

}
