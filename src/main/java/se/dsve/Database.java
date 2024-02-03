package se.dsve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    // Skapa URL till databasen
    private static final String DB_DATABASE = AppConfig.getDbDatabase();
    private static final String DB_DRIVER = AppConfig.getDbDriver();
    private static final String DB_SERVER = AppConfig.getDbServer();
    private static final String DB_PORT = AppConfig.getDbPort();
    // TODO: Skapa DB_URL med hjälp av variablerna ovan

    private static final String DB_URL = "";
    // TODO: Skapa JDBC_URL med hjälp av variablerna ovan
    private static final String JDBC_URL = DB_URL + DB_DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true";

    private final String jdbcUsername = AppConfig.getDbUser();
    private final String jdbcPassword = AppConfig.getDbPassword();

    // SQL query for creating the database
    private static String CREATE_DATABASE_SQL = "";

    public Database() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        // TODO: Anslut till databasservern utan att specificera en databas
            // TODO: Skapa databasen om den inte finns
            // TODO: Byt till den nyss skapade databasen
        CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS " + DB_DATABASE;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, jdbcUsername, jdbcPassword);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_DATABASE_SQL);
            System.out.println("Database created successfully");
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
            return DriverManager.getConnection(JDBC_URL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
}
