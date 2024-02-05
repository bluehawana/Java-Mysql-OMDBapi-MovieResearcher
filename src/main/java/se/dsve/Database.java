package se.dsve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    // Skapa URL till databasen
    private static final String DB_DATABASE = AppConfig.getDbDatabase();
    private static final String DB_SERVER = AppConfig.getDbServer();
    private static final String DB_PORT = AppConfig.getDbPort();
    private static final String DB_USER = AppConfig.getDbUser();
    private static final String DB_PASSWORD = AppConfig.getDbPassword();

    private static final String DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/";
    private static final String CONNECTION_URL = DB_URL + "?useSSL=false&allowPublicKeyRetrieval=true";





    // TODO: Skapa DB_URL med hjälp av variablerna ovan
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // TODO: Skapa JDBC_URL med hjälp av variablerna ovan



    // SQL query for creating the database
    private static String CREATE_DATABASE_SQL ="", CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS movies (id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255), year INT, director VARCHAR(255), actors VARCHAR(255))";

    public Database() throws SQLException {

        initializeDatabase();
    }

    private void initializeDatabase() throws SQLException {
        // TODO: Anslut till databasservern utan att specificera en databas
            // TODO: Skapa databasen om den inte finns
            // TODO: Byt till den nyss skapade databasen
     try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         Statement statement = connection.createStatement()) {
         statement.executeUpdate(CREATE_DATABASE_SQL);
         statement.executeUpdate(CREATE_TABLE_SQL);
         try (Connection dbConnection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
             // Example: Create a 'movies' table if it doesn't already exist
             statement.execute("USE " + DB_DATABASE); // Switch to the database
             statement.execute("CREATE TABLE IF NOT EXISTS movies (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), year INT, director VARCHAR(255), actors VARCHAR(255))");
             System.out.println("Table checked/created successfully");
         }
     } catch (SQLException e) {
         printSQLException(e);
     }
    }

    public void printSQLException(SQLException ex) {
        // TODO: Skriv ut felmeddelanden från SQL Exceptions
        if (ex != null) {
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("SQL State: " + ex.getSQLState());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }

    public Connection getConnection() {
        // TODO: Skapa en anslutning till databasen
        try {
            return DriverManager.getConnection(DB_URL + DB_DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true", DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            printSQLException(e);
            return null;
        }
    }
}
