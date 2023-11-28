package model.DB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionM{
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static final String USER = "root";
    public static final String PASSWORD = "Java2023";
    private Connection connection;

    public ConnectionM() throws RuntimeException {
        try {
            connection =
                    DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error while db connecting: " + e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }
}






