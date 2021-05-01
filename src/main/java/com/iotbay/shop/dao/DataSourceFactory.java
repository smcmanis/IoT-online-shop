package com.iotbay.shop.dao;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import javax.sql.DataSource;
import org.postgresql.ds.PGPoolingDataSource;

public class DataSourceFactory extends DB {

    public static DataSource getLocalDataSource() {

        PGPoolingDataSource localDataSource = new PGPoolingDataSource();
        localDataSource.setURL("jdbc:postgresql://localhost:5432/iotbay");
        localDataSource.setUser("simon");
        localDataSource.setPassword("");

        return localDataSource;
    }

//    public static DataSource getRemoteDataSource() {
//        Properties props = new Properties();
//        FileInputStream fis = null;
//        PGPoolingDataSource remoteDataSource = null;
//        try {
//            fis = new FileInputStream("/projects/iotbay/src/main/resources/db.properties");
//            props.load(fis);
//            remoteDataSource = new PGPoolingDataSource();
//            remoteDataSource.setURL(props.getProperty("REMOTE_DB_URL"));
//            remoteDataSource.setUser(props.getProperty("REMOTE_DB_USERNAME"));
//            remoteDataSource.setPassword(props.getProperty("REMOTE_DB_PASSWORD"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return remoteDataSource;
//    }
}
