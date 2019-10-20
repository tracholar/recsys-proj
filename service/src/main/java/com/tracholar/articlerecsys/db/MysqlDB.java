package com.tracholar.articlerecsys.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {
    private MysqlDB(){}

    private static Connection _instance;
    public static Connection getInstance() throws SQLException {
        synchronized (MysqlDB.class) {
            if (_instance == null) {
                _instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/rss?useSSL=false" +
                                "&serverTimezone" +
                                "=UTC",
                        "root","123456");
            }
        }
        return _instance;
    }

}
