package com.tracholar.articlerecsys.data;

import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.JsonableData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User extends JsonableData implements IUser<String> {
    private String id;
    private String deviceId;
    private List<String> history;

    public User(String id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
        this.history = new LinkedList<>();
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }
}
