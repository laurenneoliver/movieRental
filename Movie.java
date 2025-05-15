import java.util.ArrayList;
import java.util.List;

public class Movie {

    // Static constants for movie categories (e.g., "Regular", "New Release")
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;            // Movie title
    private int _priceCode;           // Price code (using integers)
    private List<Review> _reviews;    // List to store reviews for the movie
    private Genre _genre;             // Genre of the movie (e.g., Action, Comedy, Drama)
    private RentalPriceStrategy _priceStrategy;
    private FrequentRenterPointStrategy _pointStrategy;
    private float _purchasePrice;

    // Constructor to initialize a movie with title, price code, and genre
    public Movie(String title, int priceCode, Genre genre, RentalPriceStrategy priceStrategy, FrequentRenterPointStrategy pointStrategy, float purchasePrice) {
        _title = title;
        _priceCode = priceCode;
        _reviews = new ArrayList<>();  // Initialize the reviews list
        _genre = genre;                // Assign the genre to the movie
        genre.addMovie(this);          // Add the movie to the genre's movie list
        _priceStrategy = priceStrategy;
        _pointStrategy = pointStrategy; // Assign the point strategy
        _purchasePrice = purchasePrice;
    }

    // Getter for movie title
    public String getTitle() {
        return _title;
    }

    // Getter for price code
    public int getPriceCode() {
        return _priceCode;
    }
    public RentalPriceStrategy getPriceStrategy() {
        return _priceStrategy;
    }

    // Getter for point strategy
    public FrequentRenterPointStrategy getPointStrategy() {
        return _pointStrategy;
    }

    public float getPurchasePrice() {
        return _purchasePrice;
    }

    // Getter for genre
    public Genre getGenre() {
        return _genre;
    }

    // Setter for genre
    public void setGenre(Genre genre) {
        // Remove the movie from the old genre
        _genre.removeMovie(this);

        // Set the new genre and add the movie to the new genre's list
        _genre = genre;
        genre.addMovie(this);
    }

    // Method to add a review to the movie
    public void addReview(Review review) {
        _reviews.add(review);
    }

    // Method to get all reviews for the movie
    public List<Review> getReviews() {
        return _reviews;
    }

    // Method to generate the movie's XML statement (for rental purposes, etc.)
    public String xmlMovieStatement() {
        return "<Movie>\n  <Title>" + _title + "</Title>\n  <PriceCode>" + _priceCode + "</PriceCode>\n  <Genre>" + _genre.getGenreName() + "</Genre>\n</Movie>";
    }

    // Override toString for better movie info display
    @Override
    public String toString() {
        return "Title: " + _title + ", Genre: " + _genre.getGenreName() + ", Price Code: " + _priceCode;
    }
}