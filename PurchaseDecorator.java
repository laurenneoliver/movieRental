public abstract class PurchaseDecorator implements PurchaseComponent {
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