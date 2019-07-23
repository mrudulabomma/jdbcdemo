package com.stackroute.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import com.sun.rowset.WebRowSetImpl;

public class RowSetDemo {
    public void jdbcRowSetDemo() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");) {

            JdbcRowSetImpl rowSet = new JdbcRowSetImpl(connection);
            rowSet.setCommand("select * from employee");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println("id:" + rowSet.getInt(1));
                System.out.println("name:" + rowSet.getString(2));
            }

        }
    }
    public void CachedRowSetDemo() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");)
        {

            CachedRowSet cachedRowSet=new CachedRowSetImpl();
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("select * from employee");
            cachedRowSet.populate(rs);
            while(cachedRowSet.next()){
                System.out.println("id:"+cachedRowSet.getInt(1));
                System.out.println("name:"+cachedRowSet.getString(2));
            }

        }

    }
    public void WebRowSetDemo() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");)
        {

            WebRowSet webRowSet=new WebRowSetImpl();
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("select * from employee");
            webRowSet.populate(rs);
            while(webRowSet.next()){
                System.out.println("id:"+webRowSet.getInt(1));
                System.out.println("name:"+webRowSet.getString(2));
            }

        }

    }
}