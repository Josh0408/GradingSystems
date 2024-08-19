package com.josh.gradingsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectivity {


    //private static DBConnectivity connectivity;
    private Connection connection;

    public Connection getConnection() {
        final String DBNAME = "db_student_grading_system";
        final String JDBC_URL = "jdbc:mysql://localhost:3306/" + DBNAME;
        final String USERNAME = "Josh"; 
        
        final String PASSWORD = "Josh@54321";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
