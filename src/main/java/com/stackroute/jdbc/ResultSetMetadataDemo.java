package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void getResultSetMetaDataDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");

            PreparedStatement ps=connection.prepareStatement("select * from employee");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
