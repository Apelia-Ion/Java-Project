package persistence.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    //private static final String JDBC_DRIVER = "org.h2.Driver";  //H2
    //private static final String DB_URL = "jdbc:h2:.~/LibraryDb";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //mysql
    private static final String DB_URL = "jdbc:mysql://localhost/librarydb";


    //  Database credentials
//    private static final String USERNAME = "sa";
//    private static final String PASSWORD = "sa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private Connection connection;
    private static volatile DbConnection instance;


    private DbConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not available: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to database: " + e.getMessage());
        }
        System.out.println("MySQL connection available");
    }


    public static Connection getDatabaseConnection() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    instance = new DbConnection();
                }
            }
        }
        return instance.connection;
    }

}

