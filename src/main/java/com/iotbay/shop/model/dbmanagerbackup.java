/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.model.dao;

import com.iotbay.shop.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hlong
 */
//public class dbma  {
//    private Statement st;
//    
//    public DBManager(Connection conn) throws SQLException {
//        st = conn.createStatement();
//    }
//    
//    //Find user by ID in the database - Read one row in the database table
//    public User findUser(String email) throws SQLException {
//        System.out.println(email);
//        //String fetch = "SELECT * FROM USERS WHERE EMAIL = 'Bill@gmail.com'";
//        String fetch = "SELECT * FROM public.users";
//        ResultSet rs = st.executeQuery(fetch);
//        
//        System.out.println(rs);
//        while(rs.next()) {
//            String userEmail = rs.getString(3);
//            if(userEmail.equals(email)) {
//                String userFirstName = rs.getString(4);
//                String userLastName = rs.getString(7);
//                String userPassword = rs.getString(9);
//                return new User(userEmail, userPassword, userFirstName, userLastName);
//            }
//        }
//        return null;
//    }
//    
//    //Add user data into the database
//    public void addUser(String email, String password, String firstName, String lastName) throws SQLException {
//        st.executeUpdate("INSERT INTO USERS (EMAIL, PASSWORD_PLAINTEXT, FIRST_NAME, LAST_NAME) " 
//                + "VALUES ('" + email + "', '" + password + "', '" + firstName + "', '" + lastName + "')");
//    }
//    
//    public void updateUser(String email, String password, String firstName, String lastName) throws SQLException {
//        st.executeUpdate("UPDATE USERS SET PASSWORD='" + password + "', FIRST_NAME='" + firstName + "', LAST_NAME='" + lastName + "' WHERE EMAIL='" + email + "'");
//    }
//    
//    public void deleteUser(String email) throws SQLException {
//        st.executeUpdate("DELETE FROM USERS WHERE EMAIL='" + email +"'");
//    }
//    
//    public boolean checkUser(String email, String password) throws SQLException {
//        String fetch = "SELECT * FROM USERS WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
//        ResultSet rs = st.executeQuery(fetch);
//        
//        while(rs.next()) {
//            String userEmail = rs.getString(2);
//            String userPassword = rs.getString(9);
//            if(userEmail.equals(email) && userPassword.equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
