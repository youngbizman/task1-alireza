package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler {
    private static final String JDBC_URL = "jdbc:h2:~/test";
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    private Connection conn = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
    }

    public void openConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                System.out.println("Connection OK.");
            }
        } catch (SQLException e) {
            System.out.println("Connection fails.");
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Faild to close");
        }
    }

}


