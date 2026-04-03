package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/busbooking?useSSL=false",
                    "root",
                    "180106@Rakshita");

            System.out.println("Database Connected");

            return con;

        } catch (Exception e) {

            System.out.println(e);

        }

        return null;
    }

    public static void main(String[] args) {

        getConnection();

    }
}