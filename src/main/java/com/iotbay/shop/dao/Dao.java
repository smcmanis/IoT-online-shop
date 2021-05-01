package com.iotbay.shop.dao;

import com.iotbay.shop.controller.DBServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = DBServlet.getConnection();
        Statement st = conn.createStatement();
        conn.close();
        return st.executeQuery(query);
    }
    
    public void executeUpdate(String query) throws SQLException {
        Connection conn = DBServlet.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
}
