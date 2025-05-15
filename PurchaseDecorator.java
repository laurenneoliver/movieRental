public abstract class PurchaseDecorator implements PurchaseComponent { //base class that wraps any PurchaseComponent acts as abstract base for all purchase coupons
    protected PurchaseComponent purchase;

    public PurchaseDecorator(PurchaseComponent purchase) {
        this.purchase = purchase;
    }

    @Override
    public float getPurchasePrice() {
        return purchase.getPurchasePrice();
    }

    @Override
    public int frequentBuyerPoints() {
        return purchase.frequentBuyerPoints();
    }
}