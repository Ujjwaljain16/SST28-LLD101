import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Infrastructure
        IBookingRepository repo = new FakeBookingRepo();
        IReceiptPresenter presenter = new ConsoleReceiptPresenter();
        IBookingIdGenerator idGen = new DeterministicBookingIdGenerator();

        // Pricing Components (OCP: Add new components here)
        List<IPricingComponent> components = List.of(
            new RoomPricingComponent(),
            new AddOnPricingComponent(),
            new BaseDepositComponent(5000.0)
        );

        // Engines & Services
        IPricingEngine pricingEngine = new CompositePricingEngine(components);
        HostelFeeService service = new HostelFeeService(pricingEngine, idGen, presenter, repo);

        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        service.process(req);
    }
}
