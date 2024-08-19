package com.josh.gradingsystem.login;

import com.josh.gradingsystem.DBConnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminRepository {
    public static int insert(UserDetails userDetails) {
        DBConnectivity connectNow = new DBConnectivity();
        Connection connectDB = connectNow.getConnection();


        String Query = "INSERT INTO login(userName, password, firstName, lastName) VALUES(?,?,?,?);";
        int res = 0;
        try{
            PreparedStatement ps = connectDB.prepareStatement(Query);
            ps.setString(1, userDetails.getUserName());
            ps.setString(2, userDetails.getPassword());
            ps.setString(3, userDetails.getFirstName());
            ps.setString(4, userDetails.getLastName());

            res = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }

}
