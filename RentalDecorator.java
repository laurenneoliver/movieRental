public class RentalDecorator implements RentalComponent {
    protected RentalComponent rental;

    public RentalDecorator(RentalComponent rental) {
        this.rental = rental;
    }

    public float costOfRental() {
        return rental.costOfRental();
    }

    public int frequentRenterPoints() {
        return rental.frequentRenterPoints();
    }
}
