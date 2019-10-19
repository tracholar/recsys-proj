package com.tracholar.articlerecsys.data;

import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.data.JsonableData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User extends JsonableData implements IUser<Long> {
    private Long id;
    private String deviceId;
    private Set<String> history;

    public User(Long id) {
        this.id = id;
    }
    public User(Long id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
    }

    public void setHistory(Set<String> history) {
        this.history = history;
    }
}
