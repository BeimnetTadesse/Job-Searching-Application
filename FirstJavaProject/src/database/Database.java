package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String DB_URL = "jdbc:sqlite:jobSearch.db";

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");  // loads(registers) the SQLite JDBC driver class into memory.
            return DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
            return null;
        }
    }
}
