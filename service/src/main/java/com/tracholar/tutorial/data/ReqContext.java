package com.tracholar.tutorial.data;

import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.JsonableData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReqContext extends JsonableData implements IContext<String> {
    private String id;
    private Float lat;
    private Float lng;
    private Integer cityId;
    private Long seconds;
    private Integer weekday;

    public ReqContext(String id) {
        this.id = id;
    }
}
