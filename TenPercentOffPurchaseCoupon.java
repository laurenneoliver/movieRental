public class TenPercentOffPurchaseCoupon extends PurchaseDecorator { //concrete decorator that applies a 10% discount

    public TenPercentOffPurchaseCoupon(PurchaseComponent purchase) {
        super(purchase);
    }

    @Override
    public float getPurchasePrice() {
        return purchase.getPurchasePrice() * 0.9f;
    }

    @Override
    public int frequentBuyerPoints() {
        return purchase.frequentBuyerPoints();
    }
}