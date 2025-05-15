public class Main {
    public static void main(String[] args) {
        // Create genre instances for different genres
        Genre comedyGenre = new Genre("Comedy");
        Genre actionGenre = new Genre("Action");

        // Create customer and membership
        Customer testCustomer = new Customer("Laurenne");  // create a customer
        Membership member = new Membership(testCustomer, 1); // create a membership for the customer

        // Create movies with different price and point strategies
        Movie nemoMovie = new Movie("Nemo", Movie.CHILDRENS, comedyGenre,
                new ChildrensPriceStrategy(), new DefaultFrequentRenterPointStrategy());  // Movie  in Comedy genre with point strategy
        Movie shrekMovie = new Movie("Shrek", Movie.CHILDRENS, comedyGenre,
                new ChildrensPriceStrategy(), new DefaultFrequentRenterPointStrategy());  // Movie  in Comedy genre with point strategy
        Movie dieHardMovie = new Movie("Die Hard", Movie.REGULAR, actionGenre,
                new RegularPriceStrategy(), new DefaultFrequentRenterPointStrategy());  // Movie in Action genre with point strategy
        Movie johnWickMovie = new Movie("John Wick", Movie.NEW_RELEASE, actionGenre,
                new NewReleasePriceStrategy(), new BonusFrequentRenterPointStrategy());  // Movie  in Action genre with point strategy

        // Create rentals for the movies
        Rental nemoRental = new Rental(nemoMovie, 3, member);  // create rental for movie (Nemo) for 3 days
        Rental shrekRental = new Rental(shrekMovie, 1, member);  // create rental for movie (Shrek) for 1 day
        Rental dieHardRental = new Rental(dieHardMovie, 5, member);  // create rental for movie (Die Hard) for 5 days
        Rental johnWickRental = new Rental(johnWickMovie, 2, member);  // create rental for movie (John Wick) for 2 days

        // Applying Decorators on some of them with coupons
        RentalComponent nemoRentalWithCoupon = new FiftyPercentOffCoupon(new TenPointBonusCoupon(nemoRental));
        RentalComponent shrekRentalWithCoupon = new TenDollarsOffCoupon(shrekRental);
        RentalComponent dieHardRentalWithCoupon = new TenPointBonusCoupon(dieHardRental);
        RentalComponent johnWickRentalWithCoupon = johnWickRental; // no coupo

        // Add rentals to the customer
        testCustomer.addRental(nemoRental);
        testCustomer.addRental(shrekRental);
        testCustomer.addRental(dieHardRental);
        testCustomer.addRental(johnWickRental);

        // Output points for each rental using decorated versions
        System.out.println("\nFrequent Renter Points for Each Rental (with Bonus Points coupons):");
        System.out.println("Nemo Rental Points: " + nemoRentalWithCoupon.frequentRenterPoints());
        System.out.println("Die Hard Rental Points: " + dieHardRentalWithCoupon.frequentRenterPoints());

        System.out.println("\nCost for Each Rental (with fifty percent off coupons):");
        System.out.println("Nemo Rental Cost: $" + nemoRentalWithCoupon.costOfRental());

        System.out.println("\nCost for Each Rental (with ten dollars off coupons):");
        System.out.println("Shrek Rental Cost: $" + shrekRentalWithCoupon.costOfRental());

        // Output points for each rental without bonus points
        System.out.println("\nFrequent Renter Points for Each Rental (regular points):");
        System.out.println("Shrek Rental Points: " + shrekRentalWithCoupon.frequentRenterPoints());
        System.out.println("John Wick Rental Points: " + johnWickRentalWithCoupon.frequentRenterPoints());

        // Output cost for each rental without coupons
        System.out.println("\nCost for Each Rental (regular price):");
        System.out.println("John Wick Rental Cost: " + johnWickRentalWithCoupon.costOfRental());


        // Create a purchase (with base price from the movie)
        PurchaseComponent dieHardPurchase = new Purchase(dieHardMovie, testCustomer);

        // Apply the purchase coupon decorator
        PurchaseComponent discountedPurchase = new TenPercentOffPurchaseCoupon(dieHardPurchase);

        System.out.println("\nPurchase with 10% off coupon:");
        System.out.println("Original Price: $" + dieHardPurchase.getPurchasePrice());
        System.out.println("Discounted Price: $" + discountedPurchase.getPurchasePrice());
        System.out.println("Frequent Buyer Points: " + discountedPurchase.frequentBuyerPoints());



        // Create reviews for the movies
        Review nemoReview = new Review(testCustomer, nemoMovie, 4);  // rating: 4 stars
        Review shrekReview = new Review(testCustomer, shrekMovie, 5);  // rating: 5 stars
        Review dieHardReview = new Review(testCustomer, dieHardMovie, 4);  // rating: 4 stars
        Review johnWickReview = new Review(testCustomer, johnWickMovie, 5);  // rating: 5 stars

        // Add the reviews to the customer and movies
        testCustomer.addReview(nemoReview);
        testCustomer.addReview(shrekReview);
        testCustomer.addReview(dieHardReview);
        testCustomer.addReview(johnWickReview);

        nemoMovie.addReview(nemoReview);
        shrekMovie.addReview(shrekReview);
        dieHardMovie.addReview(dieHardReview);
        johnWickMovie.addReview(johnWickReview);

        // Output the customer's XML statement
        System.out.println(testCustomer.xmlStatement());

        // Display all reviews for the movies with star ratings
        System.out.println("\nReviews for Movies:");
        for (Review review : nemoMovie.getReviews()) {
            System.out.println(review.displayReview());
        }
        for (Review review : shrekMovie.getReviews()) {
            System.out.println(review.displayReview());
        }
        for (Review review : dieHardMovie.getReviews()) {
            System.out.println(review.displayReview());
        }
        for (Review review : johnWickMovie.getReviews()) {
            System.out.println(review.displayReview());
        }

        // Display movies in each genre
        comedyGenre.displayMovies();  // Display all movies in the Comedy genre
        actionGenre.displayMovies();  // Display all movies in the Action genre
    }
}
