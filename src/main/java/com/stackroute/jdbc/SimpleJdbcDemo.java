package com.stackroute.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

        }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {

            resultSet.afterLast(); //Moves the curser to the end of the ResultSet object

        while(resultSet.previous())
        {
            System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)  + " age: " + resultSet.getInt(3)+ " gender: " +resultSet.getString(4));
        }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            resultSet.absolute(3);

            while(resultSet.previous()){

                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)  + " age: " + resultSet.getInt(3)+ " gender: " +resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Root@123");
             PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where name=? and gender=?");

             ) {
            preparedStatement.setString(1, "mrudula");
            preparedStatement.setString(2, "female");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }