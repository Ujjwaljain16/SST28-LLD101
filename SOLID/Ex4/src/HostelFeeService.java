public class HostelFeeService {
    private final IPricingEngine pricingEngine;
    private final IBookingIdGenerator idGenerator;
    private final IReceiptPresenter presenter;
    private final IBookingRepository repository;

    public HostelFeeService(IPricingEngine pricingEngine, 
                           IBookingIdGenerator idGenerator, 
                           IReceiptPresenter presenter, 
                           IBookingRepository repository) {
        this.pricingEngine = pricingEngine;
        this.idGenerator = idGenerator;
        this.presenter = presenter;
        this.repository = repository;
    }

    public void process(BookingRequest req) {
        PricingResult result = pricingEngine.calculate(req);
        
        presenter.present(req, result);

        String bookingId = idGenerator.generate();
        repository.save(bookingId, req, result);
        
        presenter.presentSavedConfirmation(bookingId);
    }
}
