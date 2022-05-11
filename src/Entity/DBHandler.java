package Entity;

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
        st.execute("CREATE TABLE IF NOT EXISTS personalInformation5 (\n" +
                "     ID int AUTO_INCREMENT PRIMARY KEY,\n" +
                        "    Name varchar(255),\n" +
                        "    Age int,\n" +
                        "    NationalCode varchar(255),\n" +
                        "    HasVacation boolean \n" +
                        ");");
        String sql = "INSERT INTO personalInformation5 " + "VALUES (100, 'Zara', 11, 18, true)";

        st.executeUpdate(sql);
      //  sql = "INSERT INTO personalInformation5 " + "VALUES (101, 'Mahnaz', 'Fatma', 25)";

      //  st.executeUpdate(sql);
      //  sql = "INSERT INTO personalInformation5 " + "VALUES (102, 'Zaid', 'Khan', 30)";

      //  st.executeUpdate(sql);
      //  sql = "INSERT INTO personalInformation5 " + "VALUES(103, 'Sumit', 'Mittal', 28)";

      //  st.executeUpdate(sql);
        System.out.println("Inserted records into the table...");
        dbHandler.closeConnection();
    }

}


