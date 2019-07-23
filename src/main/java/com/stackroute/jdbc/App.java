package com.stackroute.jdbc;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       /* SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
       // simpleJdbcDemo.getEmployeeDetails();
           // simpleJdbcDemo.getEmployeeDetailsInReverse();
            simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
            simpleJdbcDemo.getEmployeeDetailsByNameAndGender("mrudula","female");*/

    /*  JdbcBatchDemo jbd=new JdbcBatchDemo();
        jbd.getBatchDetails();*/
  /*  ResultSetMetadataDemo rsmd=new ResultSetMetadataDemo();
    rsmd.getResultSetMetaDataDetails();
    }*/
  RowSetDemo rsd=new RowSetDemo();
        try {
            rsd.WebRowSetDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
