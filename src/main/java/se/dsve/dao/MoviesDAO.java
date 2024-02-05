package se.dsve.dao;

import se.dsve.Database;
import se.dsve.classes.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MoviesDAO {
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS movies (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), year INT, director VARCHAR(255), actors VARCHAR(255),genre VARCHAR(255)";

    private final Database database;


    public MoviesDAO(Database database) {
        this.database = database;
        initializeTable();
        //clearMoviesTable();
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
    private static final String DELETE_ALL_MOVIES_SQL = " DELETE FROM movies";
    private static final String INSERT_MOVIE_SQL = "  INSERT INTO movies (title, year, director, actors,genre) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_MOVIE_BY_TITLE_SQL = "SELECT * FROM movies WHERE title LIKE ?";
    private static final String SELECT_MOVIE_BY_ACTOR_SQL = "SELECT * FROM movie.movies WHERE actors LIKE ?";
    private static final String SELECT_MOVIE_BY_YEAR_SQL =  "SELECT * FROM movies WHERE year= ?";
    private static final String SELECT_MOVIE_BY_DIRECTOR_SQL = "SELECT * FROM movies WHERE director LIKE ?";

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
        if (!isMovieInDatabase(movie.getTitle())) {
            String insertMovieSql = "INSERT INTO movies (title, year, actors,director,genre) VALUES (?, ?, ?, ?,?)";
            try (Connection connection = database.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(insertMovieSql)) {
                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setInt(2, movie.getYear());
                preparedStatement.setString(3, movie.getDirector());
                preparedStatement.setString(4, String.join(", ", movie.getActors())); // Assuming Movie class has a getActors method returning a List<String>
                preparedStatement.setString(5, movie.getGenre());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                database.printSQLException(e);
            }
        }
    }

    public List<Movie> findMovieInDatabaseByTitle(String search) {
        // TODO: Skriv din kod här
        String selectMovieByTitleSql = "SELECT * FROM movies WHERE title LIKE ?";
       return findInDatabase(SELECT_MOVIE_BY_TITLE_SQL, search);
    }

    public boolean isMovieInDatabase(String title) {
        String selectMovieByTitleSql = "SELECT * FROM movies WHERE title LIKE ?";
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectMovieByTitleSql)) {
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            database.printSQLException(e);
            return false;
        }
    }
    public List<Movie> findMovieInDatabaseByActor(String search) {
        // TODO: Skriv din kod här
        String selectMovieByActorSql = "SELECT * FROM movies WHERE actors LIKE ?";
        return findInDatabase(SELECT_MOVIE_BY_ACTOR_SQL, search);
    }
      private Movie createMovieFromResultSet(ResultSet resultSet) throws SQLException {
        String title = resultSet.getString("title");
        int year = resultSet.getInt("year");
        String director = resultSet.getString("actors");
        String actors = resultSet.getString("director");
        String genre = resultSet.getString("genre");
        return new Movie(title, year, actors,director, genre);
    }
    public List<Movie> findMovieInDatabaseByYear(int search) {
        List<Movie> movies = new ArrayList<>();
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_YEAR_SQL)) {
            preparedStatement.setInt(1, search);
            System.out.println("Executing query: "+ preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(createMovieFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            database.printSQLException(e);
        }
        if(movies.isEmpty()) {
            System.out.println("No movies found for" + search);
            Movie movie = new Movie("No movie found", 0, String.valueOf(Arrays.asList("No actor found")), "No director found", "No genre found");
            addMovieToDatabase(movie);
            movies.add(movie);
        }
        return movies;
    }

    public List<Movie> findMovieInDatabaseByDirector(String search) {
        // TODO: Skriv din kod här
        String selectMovieByDirectorSql = "SELECT * FROM movies WHERE director LIKE ?";
        return findInDatabase(SELECT_MOVIE_BY_DIRECTOR_SQL, search);
    }

    private List<Movie> findInDatabase(String sqlQuery, String search) {
        // TODO: Skriv din kod här för att följa DRY-principen
        List<Movie> movies = new ArrayList<>();
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(createMovieFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            database.printSQLException(e);
        }
        if(movies.isEmpty()) {
            System.out.println("No movies found for " + search);
        }
        return movies;
    }
}
