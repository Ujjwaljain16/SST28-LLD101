public interface IBookingRepository {
    void save(String id, BookingRequest request, PricingResult result);
}
