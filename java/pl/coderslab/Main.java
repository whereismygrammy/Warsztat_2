package pl.coderslab;

import pl.coderslab.models.User;
import pl.coderslab.models.UserGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {

        User user = new User("fsafasgdsfaf", "fsafasffadsg@gmail.com", "Kotek123", new UserGroup(1, "dupa"));


        try {

            Connection connection = getConnection();
//
//            user.saveToDb(connection);
//            System.out.println(user.getId());

            User user2 = User.loadUserById(connection, 4);
            System.out.println(user2);
//
//            User[] users = User.loadAllUsers(connection);
//            for (User userElemen : users){
//                System.out.println(userElemen);
//            }

//            user2.setUsername("Anna Nowak");
//            user2.setEmail("anna.no2akowska@gmail.com");
//            user2.setPassword("223Kotek");
//            user2.saveToDb(connection);

            user2.delete(connection);

            System.out.println(user2);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/workshop2?useSSL=false" +
                        "&characterEncoding=utf8" +
                        "&useUnicode=true" +
                        "&useJDBCCompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false" +
                        "&serverTimezone=UTC",
                "root", "coderslab");

    }

}