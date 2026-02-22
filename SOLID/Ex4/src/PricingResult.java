public class PricingResult {
    public final Money monthly;
    public final Money deposit;
    public final Money total;

    public PricingResult(Money monthly, Money deposit) {
        this.monthly = monthly;
        this.deposit = deposit;
        this.total = monthly.plus(deposit);
    }
}
