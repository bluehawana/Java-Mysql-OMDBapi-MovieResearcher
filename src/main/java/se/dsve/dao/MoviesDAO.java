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
        try(Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_SQL)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            database.printSQLException(e);
        }
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
        String deleteAllMoviesSql = "DELETE FROM movies";
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteAllMoviesSql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            database.printSQLException(e);
        }
    }

    public void addMovieToDatabase(Movie movie) {
        // TODO: Lägg till en film i databasen
        String insertMovieSql = "INSERT INTO movies (title, year, director) VALUES (?, ?, ?)";
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertMovieSql)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getYear());
            preparedStatement.setString(3, movie.getDirector());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            database.printSQLException(e);
        }
    }

    public List<Movie> findMovieInDatabaseByTitle(String search) {
        // TODO: Skriv din kod här
       return findInDatabase(SELECT_MOVIE_BY_TITLE_SQL, search);
    }

    public List<Movie> findMovieInDatabaseByActor(String search) {
        // TODO: Skriv din kod här
        return findInDatabase(SELECT_MOVIE_BY_ACTOR_SQL, search);
    }

    public List<Movie> findMovieInDatabaseByYear(int search) {
        // TODO: Skriv din kod här
        return findInDatabase(SELECT_MOVIE_BY_YEAR_SQL, String.valueOf(search));
    }

    public List<Movie> findMovieInDatabaseByDirector(String search) {
        // TODO: Skriv din kod här
        return findInDatabase(SELECT_MOVIE_BY_DIRECTOR_SQL, search);
    }

    private List<Movie> findInDatabase(String sqlQuery, String search) {
        // TODO: Skriv din kod här för att följa DRY-principen
        List<Movie> movies = new ArrayList<>();
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, search);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                int year = resultSet.getInt("year");
                String director = resultSet.getString("director");
                movies.add(new Movie(title, year, director));
            }
        } catch (SQLException e) {
            database.printSQLException(e);
        }
        return movies;
    }
}
