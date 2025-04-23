public class FiftyPercentOffCoupon extends RentalDecorator {
    public FiftyPercentOffCoupon(RentalComponent rental) {
        super(rental);
    }

    @Override
    public float costOfRental() {
        return rental.costOfRental() * 0.5f;
    }
    
}
