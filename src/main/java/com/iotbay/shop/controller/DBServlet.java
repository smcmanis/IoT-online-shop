package com.iotbay.shop.controller;

import com.iotbay.shop.dao.DataSourceFactory;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.sql.*;

@WebServlet(
        name = "DBServlet", 
        loadOnStartup = 1)
public class DBServlet extends HttpServlet {

    private static DataSource datasource = null;

    public void init() throws ServletException {
        datasource = DataSourceFactory.getLocalDataSource();

    }

    public static synchronized Connection getConnection()
            throws SQLException {
        return datasource.getConnection();
    }

    public static synchronized void freeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println("DBBroker: Threw an exception closing a database connection");
            e.printStackTrace();
        }
    }


}
