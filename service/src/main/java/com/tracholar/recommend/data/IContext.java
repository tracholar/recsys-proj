package com.tracholar.recommend.data;

import java.io.Serializable;
import java.util.Map;

public interface IContext extends Serializable {
    String getTraceId();
}
