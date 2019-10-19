package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.Context;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemoContext implements Context {
    private String traceId;
}
