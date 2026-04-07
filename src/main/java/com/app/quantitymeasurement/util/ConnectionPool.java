package com.app.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {

    private final String url;
    private final String username;
    private final String password;

    public ConnectionPool() {
        this.url = ApplicationConfig.getProperty("db.url");
        this.username = ApplicationConfig.getProperty("db.username");
        this.password = ApplicationConfig.getProperty("db.password");

        initializeDatabase();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private void initializeDatabase() {
        String sql = """
                CREATE TABLE IF NOT EXISTS quantity_measurement (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    operation VARCHAR(50),
                    measurement_type VARCHAR(50),
                    value1 DOUBLE,
                    unit1 VARCHAR(50),
                    value2 DOUBLE,
                    unit2 VARCHAR(50),
                    result DOUBLE,
                    created_at TIMESTAMP
                )
                """;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database schema", e);
        }
    }
}