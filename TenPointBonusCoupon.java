public class TenPointBonusCoupon extends RentalDecorator {
    public TenPointBonusCoupon(RentalComponent rental) {
        super(rental);
    }

    @Override
    public int frequentRenterPoints() {
        return rental.frequentRenterPoints() + 10;
    }
}
