package com.tracholar.recommend;

import java.io.Serializable;
import java.util.Map;

public interface Context extends Serializable {
    String getTraceId();
}
