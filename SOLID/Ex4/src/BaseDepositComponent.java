public class BaseDepositComponent implements IPricingComponent {
    private final double amount;

    public BaseDepositComponent(double amount) {
        this.amount = amount;
    }

    @Override
    public Money monthly(BookingRequest req) {
        return new Money(0.0);
    }

    @Override
    public Money deposit(BookingRequest req) {
        return new Money(amount);
    }
}
