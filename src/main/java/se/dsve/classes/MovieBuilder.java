package se.dsve.classes;

public class MovieBuilder {

    private String title;
    private int year;
    private String actors;
    private String director;
    private String genre;

    public MovieBuilder(String title, int year, String actors, String director) {
        this.title = title;
        this.year = year;
        this.actors = actors;
        this.director = director;
        this.genre = genre;
    }

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

    public Movie build() {
        return new Movie(title, year, actors, director, genre);
    }
}
