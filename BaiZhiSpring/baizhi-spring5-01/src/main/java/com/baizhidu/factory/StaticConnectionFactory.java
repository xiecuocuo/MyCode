package com.baizhidu.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class StaticConnectionFactory {
    private static final String driverClassName="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
    private static final String userName="root";
    private static final String password="ynf";

    public static Connection getConnection() throws Exception {
        Class.forName(driverClassName);
        Connection connection= DriverManager.getConnection(url,userName,password);
        return connection;
    }
}
