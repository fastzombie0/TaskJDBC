package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = getMySQLConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users(" +
                    "id BIGINT (6) primary key not null auto_increment," +
                    " name varchar(20)," +
                    " lastName VARCHAR(20)," +
                    " age TINYINT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try (Connection connection = getMySQLConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO Users(name, lastName, age) values (?, ?, ?)";
        try (Connection connection = getMySQLConnection(); PreparedStatement preparedStatemen = connection.prepareStatement(sql)) {
            preparedStatemen.setString(1, name);
            preparedStatemen.setString(2, lastName);
            preparedStatemen.setByte(3, age);
            preparedStatemen.executeUpdate();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "delete from Users where id = ?";
        try (Connection connection = getMySQLConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM Users";
        try (Connection connection = getMySQLConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = getMySQLConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
