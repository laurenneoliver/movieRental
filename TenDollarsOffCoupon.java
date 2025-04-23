public class TenDollarsOffCoupon extends RentalDecorator {
    public TenDollarsOffCoupon(RentalComponent rental) {
        super(rental);
    }

    @Override
    public float costOfRental() {
        float base = rental.costOfRental();
        return base > 50.0f ? base - 10.0f : base; //if total spend >50 then it minuses $10
    }
}
