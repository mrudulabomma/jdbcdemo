package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void getDetails() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
        ) {
            DatabaseMetaData dbmd = connection.getMetaData();

            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("UserName: " + dbmd.getUserName());
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
        }

        connection.close();
    }
}
