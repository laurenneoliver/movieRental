import java.util.List;
import java.util.ArrayList;

public class Transaction {
    private List<RentalComponent> rentals;
    private List<PurchaseComponent> purchases;

    public Transaction() {
        rentals = new ArrayList<RentalComponent>();
        purchases = new ArrayList<PurchaseComponent>();
    }

    public void addRental(RentalComponent rental) {
        rentals.add(rental);
    }

    public void addPurchase(PurchaseComponent purchase) {
        purchases.add(purchase);
    }

    public float getTotalCost() {
        float total = 0;
        for (RentalComponent r : rentals) total += r.costOfRental();
        for (PurchaseComponent p : purchases) total += p.getPurchasePrice();
        return total;
    }

    public int getTotalPoints() {
        int total = 0;
        for (RentalComponent r : rentals) total += r.frequentRenterPoints();
        for (PurchaseComponent p : purchases) total += p.frequentBuyerPoints();
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
