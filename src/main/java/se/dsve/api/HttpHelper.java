package se.dsve.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {
    // Privat constructor för att förhindra instansiering
    private HttpHelper() {
        throw new AssertionError("Instantiating utility class");
    }

    /**
     * Gör en HTTP GET-förfrågan till den angivna URL:en och returnerar svaret som en sträng.
     *
     * @param url URL:en som förfrågan ska göras till.
     * @return En sträng med svaret från förfrågan.
     */
    public static String fetchDataFromUrl(URL url) {
        // TODO: Skapa en StringBuilder för att lagra svaret

            // TODO: Öppna en anslutning till URL:en
            // TODO: Skapa en BufferedReader för att läsa svaret

        return null;
    }
}

