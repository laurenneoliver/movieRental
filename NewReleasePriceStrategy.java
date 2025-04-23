public class NewReleasePriceStrategy implements RentalPriceStrategy {
    public float calculatePrice(int daysRented) {
        float amount = daysRented * 3.0f;
        return amount;
    }
}
