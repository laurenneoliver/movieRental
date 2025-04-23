import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;            // Customer's name
    private List<Rental> _rentals;   // List to store rentals associated with the customer
    private List<Review> _reviews;   // List to store reviews written by the customer

    // Constructor to initialize customer with a name
    public Customer(String name) {
        _name = name;
        _rentals = new ArrayList<>();  // Initialize the rentals list
        _reviews = new ArrayList<>();  // Initialize the reviews list
    }

    // Method to add a rental to the customer's list of rentals
    public void addRental(Rental newRental) {
        _rentals.add(newRental);
    }

    // Method to add a review to the customer's list of reviews
    public void addReview(Review review) {
        _reviews.add(review);
    }

    // Method to get the list of reviews written by the customer
    public List<Review> getReviews() {
        return _reviews;
    }

    // Getter for customer's name
    public String getName() {
        return _name;
    }

    // Method to generate the customer's XML statement
    public String xmlStatement() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Customer>\n");
        xml.append("  <Name>").append(_name).append("</Name>\n");
        xml.append("  <Rentals>\n");

        float totalCost = 0;
        int frequentRenterPoints = 0;

        // Iterate over the rentals and accumulate the total cost and frequent renter points
        for (Rental eachRental : _rentals) {
            totalCost += eachRental.costOfRental();
            frequentRenterPoints += eachRental.frequentRenterPoints();

            xml.append(eachRental.xmlRentalStatement());  // rental statement created in Rental class
        }

        xml.append("  </Rentals>\n");
        xml.append("  <TotalAmount>").append(totalCost).append("</TotalAmount>\n");
        xml.append("  <FrequentRenterPoints>").append(frequentRenterPoints).append("</FrequentRenterPoints>\n");
        xml.append("</Customer>");

        return xml.toString();
    }
}
