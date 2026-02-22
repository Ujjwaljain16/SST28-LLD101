public interface IPricingComponent {
    Money monthly(BookingRequest req);
    Money deposit(BookingRequest req);
}
