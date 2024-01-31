package se.dsve.api;

import org.json.JSONObject;
import se.dsve.AppConfig;
import se.dsve.classes.Movie;
import se.dsve.classes.MovieBuilder;

import java.net.URI;
import java.net.URL;

public class ApiService {
    private final String API_KEY = AppConfig.getOmdbApiKey();

    // Metod för att hämta data från API:et baserat på filmtitel
    public Movie getDataByTitle(String movieTitle) {
        // TODO: Formatera titeln för att inkludera i URL:en
        // TODO: Skapa URL-strängen med API-nyckeln och den formaterade titeln
        // TODO: Hämta data från URL:en via en HTTP Helper-metod
        // TODO: Skapa en Movie-instans med hjälp av JSON-objektet och returnera den
        return null;
    }

    private URL urlToFetch(String formattedTitle) {
        // TODO: spara URL:en i en variabel omdbApiUrl utan nyckel
        // TODO: skapa den kopletta strängen med URL:en, API-nyckeln och den formaterade titeln
        // TODO: skapa en URL-instans med den kompletta strängen
        return null;
    }

    private static String formatToApiStandard(String movieTitle) {
        // TODO: Skriv din kod här
        return '';
    }

    // Hjälpmetod för att skapa URL (underlättar mockning i tester)
    protected URL convertStringToUrlFormat(String urlString) throws Exception {
        // TODO: Skriv din kod här
        return null;
    }
}
