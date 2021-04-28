package com.iotbay.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    private Statement statement;

    public DBManager(Connection conn) throws SQLException {
        statement = conn.createStatement();
    }

}
