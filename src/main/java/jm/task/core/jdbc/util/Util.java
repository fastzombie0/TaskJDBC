package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://Andrejs-MacBook-Pro.local:3306/hbm?serverTimezone=Europe/Moscow&useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "09250925");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }



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

