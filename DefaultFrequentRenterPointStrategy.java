public class DefaultFrequentRenterPointStrategy implements FrequentRenterPointStrategy {
    public int calculatePoints(int daysRented) {
        // 1 point for any rental longer than 1 day
        return (daysRented > 1) ? 1 : 0;
    }
}
