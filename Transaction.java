import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<Rental> rentals = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public float getTotalCost() {
        float total = 0;
        for (Rental r : rentals) total += r.costOfRental();
        for (Purchase p : purchases) total += p.getPurchasePrice();
        return total;
    }

    public int getTotalPoints() {
        int total = 0;
        for (Rental r : rentals) total += r.frequentRenterPoints();
        for (Purchase p : purchases) total += p.frequentBuyerPoints();
        return total;
    }

    public void printSummary() {
        System.out.println("\n--- Transaction Summary ---");
        for (RentalComponent r : rentals)
            System.out.println("RENTED: $" + r.costOfRental() + " | Points: " + r.frequentRenterPoints());

        for (PurchaseComponent p : purchases)
            System.out.println("PURCHASED: $" + p.getPurchasePrice() + " | Points: " + p.frequentBuyerPoints());

        System.out.println("TOTAL COST: $" + getTotalCost());
        System.out.println("TOTAL POINTS: " + getTotalPoints());
    }
}