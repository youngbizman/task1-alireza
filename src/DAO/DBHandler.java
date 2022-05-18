package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    private static Connection conn = null;

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
            System.out.println("Failed to close");
        }
    }
    public static void main(String[] args) throws InterruptedException, SQLException {
        DBHandler dbHandler = new DBHandler();
        dbHandler.openConnection();
        Statement st = conn.createStatement();
        st.execute("CREATE TABLE IF NOT EXISTS personalInformation (\n" +
                "     ID int AUTO_INCREMENT PRIMARY KEY,\n" +
                        "    Name varchar(255),\n" +
                        "    Age int,\n" +
                        "    NationalCode varchar(255),\n" +
                        "    HasVacation boolean \n" +
                        ");");
        String sql = "INSERT INTO   personalInformation VALUES (18011, 'Zara', 18110, 1810, true)";
        st.executeUpdate(sql);
        Thread.sleep(2000);
        System.out.println("Inserted records into the table...");
        dbHandler.closeConnection();
    }
}


