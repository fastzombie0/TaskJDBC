package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БДjdbc:mysql://Andrejs-MacBook-Pro.local:3306
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://Andrejs-MacBook-Pro.local:3306", "root", "09250925");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
