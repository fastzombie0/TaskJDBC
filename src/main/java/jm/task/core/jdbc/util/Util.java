package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public void connect() {

        try(Connection connection = DriverManager.getConnection
                ("jdbc:mysql://Andrejs-MacBook-Pro.local:3306?serverTimezone=Europe/Moscow&useSSL=false", "root", "09250925")) {

        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

}
