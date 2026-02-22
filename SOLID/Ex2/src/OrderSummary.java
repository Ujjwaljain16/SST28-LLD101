public class OrderSummary {
    public final String itemName;
    public final int qty;
    public final double lineTotal;

    public OrderSummary(String itemName, int qty, double lineTotal) {
        this.itemName = itemName;
        this.qty = qty;
        this.lineTotal = lineTotal;
    }
}
