package se.dsve.classes;

public class Movie {
    // Antag att dessa är dina instansvariabler
    private String title;
    private int year;
    private String actors;
    private String director;
    private String genre;

    // Antag att detta är din konstruktor

    public Movie(String title, int year, String director, String actors, String genre) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
    }

    // Metod för att skriva ut filmens detaljer
    public void printMovie() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println("Director: " + director);
        System.out.println("Actors: " + actors);
    }

    //getters and setters for the movie object
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", year='" + year + '\'' + ", actors='" + actors + '\'' + ", director='" + director + '\'' + ", genre='" + genre + '\'' + '}';
    }
}


