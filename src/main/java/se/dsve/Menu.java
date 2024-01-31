package se.dsve;

import se.dsve.api.ApiService;
import se.dsve.classes.Movie;
import se.dsve.dao.MoviesDAO;
import se.dsve.helpers.InputHelper;

import java.io.IOException;
import java.util.List;


public class Menu {
    private MoviesDAO moviesDAO;
    private ApiService apiService = new ApiService();
    private static InputHelper inputHelper = new InputHelper();

    public Menu() throws IOException {
        // Skapa en Database-instans och skicka den till MoviesDAO
        Database database = new Database();
        moviesDAO = new MoviesDAO(database);

        showMenu(); // Kör showMenu-metoden
    }

    public void showMenu() {
        boolean run = true;
        do {
            int choice = printMenuAndReturnChoice();

            switch (choice) {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchByYear();
                    break;
                case 3:
                    searchByActor();
                    break;
                case 4:
                    searchByDirector();
                    break;
                case 5:
                    System.out.println("Exiting..");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        } while (run);
    }

    private static int printMenuAndReturnChoice() {
        String menu = """
                ------------------
                Movie Searcher
                1. Search movie by title
                2. Search movie by year only in database!
                3. Search movie by actor only in database!
                4. Search movie by director only in database!
                5. Exit
                ------------------
                Enter your choice:\s""";

        return inputHelper.promptUserAndGetInt(menu);
    }

    private void searchByTitle() {
        // TODO: Sök efter en film i databasen om den inte finns i databasen, sök i API:et och spara resultatet i databasen
    }


    private Movie getMovieFromApi(String title) {
        // TODO: Hämta filmen från API:et
        return null;
    }

    private static boolean notInDatabase(Movie movie) {
        // TODO: Kontrollera om filmen inte är null
        return false;
    }

    private void searchByYear() {
        // TODO: Sök efter en film i databasen efter år, sök inte i API:et!
    }

    private void searchByActor() {
        // TODO: Sök efter en film i databasen efter år, sök inte i API:et!
    }

    private void searchByDirector() {
        // TODO: Sök efter en film i databasen efter år, sök inte i API:et!
    }
}
