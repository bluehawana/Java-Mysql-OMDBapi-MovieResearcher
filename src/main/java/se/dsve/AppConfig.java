package se.dsve;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {
    // TODO: Läs in värden från .env-filen
    static Dotenv dotenv = Dotenv.load();
    private static final String OMDB_API_KEY = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private static final String DB_DRIVER = "";
    private static final String DB_SERVER = "";
    private static final String DB_PORT = "";
    private static final String DB_DATABASE = "";

    public static String getOmdbApiKey() {
        return OMDB_API_KEY;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPassword() {
        return DB_PASSWORD;
    }

    public static String getDbDriver() {
        return DB_DRIVER;
    }

    public static String getDbServer() {
        return DB_SERVER;
    }

    public static String getDbPort() {
        return DB_PORT;
    }

    public static String getDbDatabase() {
        return DB_DATABASE;
    }
}
