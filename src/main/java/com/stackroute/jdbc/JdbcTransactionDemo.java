package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo {
    private Connection connection;
    private Savepoint savepoint;
    public void getTransactionDetails() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into employee (id, name) values (?,?)");
            ps.setInt(1,101);
            ps.setString(2,"renu");
            ps.executeUpdate();
            Savepoint savepoint = connection.setSavepoint();
            PreparedStatement pstmt= connection.prepareStatement("insert into employee (id, name) values (?,?)");
            pstmt.setInt(1,102);
            pstmt.setString(2,"mommy");
            pstmt.executeUpdate();
          Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");
            while (rs.next()) {
                System.out.println("Id: " +rs.getInt(1) + " Name: " + rs.getString(2));
            }

//connection.commit();
        }
        catch (SQLException e){
            e.printStackTrace();
            if (connection != null) {
                try {

                    connection.rollback(savepoint);
                    System.out.println("JDBC Transaction rolled back successfully");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
}
}
}
