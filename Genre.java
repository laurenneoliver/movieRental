import java.util.ArrayList;
import java.util.List;

public class Genre {

    private String genreName;  // Genre name (e.g., Action, Comedy)
    private List<Movie> movies; // List of movies in this genre

    // Constructor to initialize the genre with a name
    public Genre(String genreName) {
        this.genreName = genreName;
        this.movies = new ArrayList<>();
    }

    // Method to add a movie to this genre
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Method to remove a movie from this genre
    public boolean removeMovie(Movie movie) {
        return movies.remove(movie);
    }

    // Getter for the genre name
    public String getGenreName() {
        return genreName;
    }

    // Getter for movies in this genre
    public List<Movie> getMovies() {
        return movies;
    }

    // Method to display movies in this genre
    public void displayMovies() {
        System.out.println("Movies in " + genreName + " genre:");
        for (Movie movie : movies) {
            System.out.println(" - " + movie.getTitle());
        }
    }
}
