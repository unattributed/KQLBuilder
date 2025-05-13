package com.intranet.KQLBuilder;

import java.sql.*;

public class QueryStorageService {
    private final String dbUrl;

    public QueryStorageService(String dbFile) {
        this.dbUrl = "jdbc:sqlite:" + dbFile;
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String sql = "CREATE TABLE IF NOT EXISTS queries (name TEXT PRIMARY KEY, query TEXT)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
        } catch (SQLException e) {
            System.err.println("DB Init Error: " + e.getMessage());
        }
    }

    public void saveQuery(String name, String query) {
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String sql = "REPLACE INTO queries (name, query) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, query);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Save Error: " + e.getMessage());
        }
    }

    public String getQuery(String name) {
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String sql = "SELECT query FROM queries WHERE name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("query");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Load Error: " + e.getMessage());
        }
        return null;
    }
}
// This class provides a simple interface to save and retrieve KQL queries from a SQLite database.
// It uses JDBC to connect to the SQLite database and perform SQL operations.
// The `saveQuery` method saves a query with a given name, and the `getQuery` method retrieves a query by its name.
// The database is initialized with a table for storing queries if it doesn't already exist.