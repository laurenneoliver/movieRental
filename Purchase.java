public class Purchase {
    private Movie movie;
    private Customer customer;

    public Purchase(Movie movie, Customer customer) {
        this.movie = movie;
        this.customer = customer;
    }

    public float getPurchasePrice() {
        return movie.getPurchasePrice();
    }

    public int frequentBuyerPoints() {
        return 2; // Can be changed to strategy-based later
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return movie.getTitle() + " purchased for $" + getPurchasePrice();
    }
}