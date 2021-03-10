package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {


    public Connection getMySQLConnection() {

        String hostName = "jdbc:mysql://Andrejs-MacBook-Pro.local:3306/sqll";
        String dbName = "?serverTimezone=Europe/Moscow&useSSL=false";
        String connectionURL = hostName + dbName;
        Connection conn = null;
        try {
            String userName = "root";
            String password = "09250925";
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection failed");
        }

        return conn;
    }

}

