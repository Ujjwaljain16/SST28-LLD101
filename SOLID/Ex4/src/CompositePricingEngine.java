import java.util.List;

public class CompositePricingEngine implements IPricingEngine {
    private final List<IPricingComponent> components;

    public CompositePricingEngine(List<IPricingComponent> components) {
        this.components = components;
    }

    @Override
    public PricingResult calculate(BookingRequest req) {
        Money totalMonthly = new Money(0.0);
        Money totalDeposit = new Money(0.0);

        for (IPricingComponent component : components) {
            totalMonthly = totalMonthly.plus(component.monthly(req));
            totalDeposit = totalDeposit.plus(component.deposit(req));
        }

        return new PricingResult(totalMonthly, totalDeposit);
    }
}
