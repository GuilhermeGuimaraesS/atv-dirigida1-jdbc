package com.guimaraes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String USER = "postgres";
    private static final String PASS = "zsn_3356";
    private static final ConnectionFactory INSTANCE = new ConnectionFactory();

    private ConnectionFactory(){

    }

    public static ConnectionFactory getInstance(){
        return INSTANCE;
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
