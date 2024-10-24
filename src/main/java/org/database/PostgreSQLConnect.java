package org.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnect {

    private static final String URL = "jdbc:postgresql://localhost:5432/authjava"; // Change as needed
    private static final String USER = "postgres"; // Change as needed
    private static final String PASSWORD = "isba"; // Change as needed

    public static boolean connect() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return conn != null; // Return true if connection is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if connection fails
        }
    }
}
