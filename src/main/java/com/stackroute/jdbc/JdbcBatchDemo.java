package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    private Connection connection;
    private  Statement statement;
    public void getBatchDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
            PreparedStatement ps = connection.prepareStatement("insert into employee (id, name) values (?,?)");

            long start = System.currentTimeMillis();
            for(int i =0; i<10;i++){
                ps.setInt(1, i);
                ps.setString(2, "name"+i);

                ps.addBatch();

                if(i%10 == 0) ps.executeBatch();
            }
            ps.executeBatch();

            System.out.println("Time Taken="+(System.currentTimeMillis()-start));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

