package com.tracholar.articlerecsys.data;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.JsonableData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReqContext extends JsonableData implements IContext<String> {
    private String id;
    private float lat;
    private float lng;
    private int cityId;
    private long seconds;
    private int weekday;

    public ReqContext(String id) {
        this.id = id;
    }
}
