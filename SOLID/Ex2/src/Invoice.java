import java.util.List;

public class Invoice {
    public final String id;
    public final List<OrderSummary> lines;
    public final double subtotal;
    public final double taxRate;
    public final double taxAmount;
    public final double discount;
    public final double total;

    public Invoice(String id, List<OrderSummary> lines, double subtotal, 
                   double taxRate, double taxAmount, double discount, double total) {
        this.id = id;
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.discount = discount;
        this.total = total;
    }
}
