package se.dsve.api;

import org.json.JSONObject;
import se.dsve.AppConfig;
import se.dsve.classes.Movie;
import se.dsve.classes.MovieBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiService {
    private final String API_KEY = AppConfig.getOmdbApiKey();
    private static final String BASE_URL = "http://www.omdbapi.com/";
    // Metod för att hämta data från API:et baserat på filmtitel

    public Movie getDataByTitle(String movieTitle) throws Exception {
        // TODO: Formatera titeln för att inkludera i URL:en
        // TODO: Skapa URL-strängen med API-nyckeln och den formaterade titeln
        // TODO: Hämta data från URL:en via en HTTP Helper-metod
        // TODO: Skapa en Movie-instans med hjälp av JSON-objektet och returnera den
        try {
            String searchUrl = BASE_URL + "?apikey=" + API_KEY + "&t=" + formatToApiStandard(movieTitle);
            URL url = new URL(searchUrl);
            JSONObject jsonObject = fetchJsonFromUrl(url);
            if(jsonObject != null) {
                return createMovieFromJson(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Movie searchMovieByTitle(String title) {
        String searchUrl =BASE_URL + "?apikey=" + API_KEY + "&t=" + formatToApiStandard(title);
        try {
            URI uri = new URI(searchUrl);
            URL url = uri.toURL();
            JSONObject jsonObject = fetchJsonFromUrl(url);
            return (Movie) clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Movie createMovieFromJson(JSONObject jsonObject) {
        try {
            String title = jsonObject.getString("Title");
            int year = Integer.parseInt(jsonObject.getString("Year").replaceAll("[^\\d]", "")); // Ensure year is a number
            String actors = jsonObject.getString("Actors");
            String director = jsonObject.getString("Director");
            // Using builder pattern to create Movie object
            return new MovieBuilder(title, year, actors, director).build();
        } catch (Exception e) {
            System.err.println("Error parsing JSON to Movie: " + e.getMessage());
            return null;
        }
    }

    private JSONObject fetchJsonFromUrl(URL url) {
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            return new JSONObject(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private URL urlToFetch(String formattedTitle) throws Exception {
        // TODO: spara URL:en i en variabel omdbApiUrl utan nyckel
        // TODO: skapa den kopletta strängen med URL:en, API-nyckeln och den formaterade titeln
        // TODO: skapa en URL-instans med den kompletta strängen
        String omdbApiUrl = "http://www.omdbapi.com/?apikey=";
        String completeUrl = omdbApiUrl + API_KEY + "&t=" + formattedTitle;
          return convertStringToUrlFormat(completeUrl);
    }

    private static String formatToApiStandard(String movieTitle) {
        // TODO: Skriv din kod här
        return movieTitle.replace(" ", "+");
    }

    // Hjälpmetod för att skapa URL (underlättar mockning i tester)
    protected URL convertStringToUrlFormat(String urlString) throws Exception {
        // TODO: Skriv din kod här
        return null;
    }
}

