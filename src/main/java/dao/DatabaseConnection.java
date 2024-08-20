package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection(){
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        String database = System.getenv("DB_NAME");

        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/" + database,
                    username, password);
        }catch (SQLException e){
            throw new RuntimeException("Error during database connection");
        }
    }
}
