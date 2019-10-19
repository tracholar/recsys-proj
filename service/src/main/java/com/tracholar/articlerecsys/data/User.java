package com.tracholar.articlerecsys.data;

import com.tracholar.recommend.data.IUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User implements IUser {
    private String id;
    private String deviceId;

    public User(String id) {
        this.id = id;
        this.deviceId = null;
    }
}
