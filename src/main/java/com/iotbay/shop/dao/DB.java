package com.iotbay.shop.dao;

import java.sql.Connection;

public abstract class DB {

    protected String URL = "jdbc:postgresql://ec2-35-174-35-242.compute-1.amazonaws.com:5432/";
    protected String db = "d7j6pcgtc8qq5s";
    protected String dbuser = "zeiodfbndjgzyj";
    protected String dbpass = "224dbdf2774b22a03953d02ca9add37da800df25d1711bd4a4b7cc62b5d6826b";
    protected String driver = "org.postgresql.Driver";
    protected Connection conn;
    
    protected String localURL = "jdbc:postgresql://localhost:5432/iotbay";
    protected String localDbuser = "simon";
    protected String localDbpass = "";
    protected String localDriver = "org.postgresql.Driver";
    protected Connection localConn;

}
