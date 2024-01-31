package se.dsve.dao;

import se.dsve.Database;
import se.dsve.classes.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    private static final String CREATE_TABLE_SQL = "";
    private final Database database;

    public MoviesDAO(Database database) {
        this.database = database;
        initializeTable();
        clearMoviesTable();
    }

    private void initializeTable() {
        // TODO: Skapa en tabell i databasen om den inte finns
    }

    // Skapa prepared Statements
    private static final String DELETE_ALL_MOVIES_SQL = "";
    private static final String INSERT_MOVIE_SQL = "";
    private static final String SELECT_MOVIE_BY_TITLE_SQL = "";
    private static final String SELECT_MOVIE_BY_ACTOR_SQL = "";
    private static final String SELECT_MOVIE_BY_YEAR_SQL = "";
    private static final String SELECT_MOVIE_BY_DIRECTOR_SQL = "";

    // Metoder för att hantera databasoperationer

    public void clearMoviesTable() {
        // TODO: Ta bort alla filmer från databasen när programmet startar
    }

    public void addMovieToDatabase(Movie movie) {
        // TODO: Lägg till en film i databasen
    }

    public List<Movie> findMovieInDatabaseByTitle(String search) {
        // TODO: Skriv din kod här
        return new List<>();
    }

    public List<Movie> findMovieInDatabaseByActor(String search) {
        // TODO: Skriv din kod här
        return new List<>();
    }

    public List<Movie> findMovieInDatabaseByYear(int search) {
        // TODO: Skriv din kod här
        return new List<>();
    }

    public List<Movie> findMovieInDatabaseByDirector(String search) {
        // TODO: Skriv din kod här
        return findInDatabase(SELECT_MOVIE_BY_DIRECTOR_SQL, search);
    }

    private List<Movie> findInDatabase(String sqlQuery, String search) {
        // TODO: Skriv din kod här för att följa DRY-principen
        return new List<>();
    }
}
