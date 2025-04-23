// Subclass of RentalPrice Strategy for calculate regular price

public class RegularPriceStrategy implements RentalPriceStrategy {
    public float calculatePrice(int daysRented) {
        float amount = 2.0f;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5f;
        }
        return amount;
    }
}

