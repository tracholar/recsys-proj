package com.tracholar.recommend.demo;

import com.tracholar.recommend.data.IContext;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemoContext implements IContext<String> {
    private String id;
}
