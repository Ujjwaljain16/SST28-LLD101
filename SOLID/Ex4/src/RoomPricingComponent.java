public class RoomPricingComponent implements IPricingComponent {
    @Override
    public Money monthly(BookingRequest req) {
        double base;
        switch (req.roomType) {
            case LegacyRoomTypes.SINGLE -> base = 14000.0;
            case LegacyRoomTypes.DOUBLE -> base = 15000.0;
            case LegacyRoomTypes.TRIPLE -> base = 12000.0;
            default -> base = 16000.0;
        }
        return new Money(base);
    }

    @Override
    public Money deposit(BookingRequest req) {
        return new Money(0.0);
    }
}
