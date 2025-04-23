public class BonusFrequentRenterPointStrategy implements FrequentRenterPointStrategy {
    public int calculatePoints(int daysRented) {
        // 2 points for rentals longer than 1 day, otherwise 1 point
        return (daysRented > 1) ? 2 : 1;
    }
}
