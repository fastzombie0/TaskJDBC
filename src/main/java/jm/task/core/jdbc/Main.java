package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.math.BigInteger;


public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        util.getMySQLConnection();
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Andrea", "Antonov", (byte) 15);
        userService.saveUser("Anton", "Andreev", (byte) 16);
        userService.saveUser("Igor", "Igorev", (byte) 17);
        userService.saveUser("Adel", "Sergeeva", (byte) 18);
        System.out.println(userService.getAllUsers());
        userService.getAllUsers();
        userService.removeUserById(3);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
