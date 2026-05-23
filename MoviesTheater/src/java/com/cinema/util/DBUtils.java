/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection utility for Microsoft SQL Server.
 * Uses JDBC DriverManager with configurable connection parameters.
 *
 * @author tuan6b
 */
public class DBUtils {

    // Connection parameters — update these to match your environment
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE = "MoviesTheater";
    private static final String USER = "sa";
    private static final String PASSWORD = "your_password_here";

    private static final String CONNECTION_URL = "jdbc:sqlserver://"
            + SERVER + ":" + PORT
            + ";databaseName=" + DATABASE
            + ";encrypt=true;trustServerCertificate=true";

    /**
     * Get a new database connection.
     *
     * @return Connection to SQL Server
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC driver not found", e);
        }
        return DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
    }
}
