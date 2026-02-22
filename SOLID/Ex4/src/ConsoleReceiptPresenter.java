public class ConsoleReceiptPresenter implements IReceiptPresenter {
    @Override
    public void present(BookingRequest req, PricingResult res) {
        System.out.println("Room: " + LegacyRoomTypes.nameOf(req.roomType) 
            + " | AddOns: " + req.addOns);
        System.out.println("Monthly: " + res.monthly);
        System.out.println("Deposit: " + res.deposit);
        System.out.println("TOTAL DUE NOW: " + res.total);
    }

    @Override
    public void presentSavedConfirmation(String bookingId) {
        System.out.println("Saved booking: " + bookingId);
    }
}
