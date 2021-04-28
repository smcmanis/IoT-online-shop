package com.iotbay.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector extends DB {

    public DBConnector() throws ClassNotFoundException, SQLException {

        Class.forName(driver);

        conn = DriverManager.getConnection(URL + db, dbuser, dbpass);
        System.out.println("Connected to PostgreSQL database!");
    }

    public Connection openConnection() {

        return this.conn;

    }

    public void closeConnection() throws SQLException {

        this.conn.close();

    }

}
