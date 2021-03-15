package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.math.BigInteger;


public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        UserServiceImpl userService = new UserServiceImpl();
        Util.getSessionFactory();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userService.createUsersTable();
        userService.saveUser("Andrea", "Ivanov", (byte) 25);
        userService.saveUser("Ivan", "Andreyanov", (byte) 26);
        userService.saveUser("Igor", "Igorev", (byte) 27);
        userService.saveUser("Adel", "Sergeev", (byte) 28);
        System.out.println(userService.getAllUsers());
        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();




        //util.getMySQLConnection();
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Andrea", "Antonov", (byte) 15);
//        userService.saveUser("Anton", "Andreev", (byte) 16);
//        userService.saveUser("Igor", "Igorev", (byte) 17);
//        userService.saveUser("Adel", "Sergeeva", (byte) 18);
//        System.out.println(userService.getAllUsers());
//        userService.getAllUsers();
//        userService.removeUserById(3);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
