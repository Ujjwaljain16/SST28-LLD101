public interface IReceiptPresenter {
    void present(BookingRequest req, PricingResult result);
    void presentSavedConfirmation(String bookingId);
}
