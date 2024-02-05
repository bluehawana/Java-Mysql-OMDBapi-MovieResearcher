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
    private static final String CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS " + DB_DATABASE;


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
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS movies (id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255), year INT, director VARCHAR(255), actors VARCHAR(255), genre VARCHAR(255))";

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
                statement.execute("USE " + DB_DATABASE); // Switch to the database
                statement.executeUpdate(CREATE_TABLE_SQL);
                System.out.println("Database and table checked/created successfully");
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
        try {
            Connection connection = DriverManager.getConnection(DB_URL + "?useSSL=false&allowPublicKeyRetrieval=true", DB_USER, DB_PASSWORD);
            try (Statement statement = connection.createStatement()) {
                statement.execute("USE " + DB_DATABASE); // Switch to the database
            }
            return connection;
        } catch (SQLException e) {
            printSQLException(e);
            return null;
        }
    }
}
