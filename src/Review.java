public class Review {

    private Customer customer;  // Customer who gave the review
    private Movie movie;        // Movie being reviewed
    private int rating;         // Rating between 1 and 5 (inclusive)

    // Constructor to initialize the review with customer, movie, and rating
    public Review(Customer customer, Movie movie, int rating) {
        this.customer = customer;
        this.movie = movie;
        setRating(rating);  // Enforce rating validation
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
    }

    // Method to display the review as stars (e.g., "★★★☆☆")
    public String displayReview() {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < rating; i++) {
            stars.append("★");  // Add a filled star
        }
        for (int i = rating; i < 5; i++) {
            stars.append("☆");  // Add an empty star
        }
        // Display the movie title along with the review stars
        return "Review for \"" + movie.getTitle() + "\": " + stars.toString();
    }
}
