import java.util.*;

public class CafeteriaService {
    private final IMenuRepository menuRepository;
    private final ITaxPolicy taxPolicy;
    private final IDiscountPolicy discountPolicy;
    private final IInvoiceRepository invoiceRepository;
    private final IInvoiceIdGenerator idGenerator;
    private final IPresenter presenter;

    public CafeteriaService(IMenuRepository menuRepository, 
                            ITaxPolicy taxPolicy, 
                            IDiscountPolicy discountPolicy, 
                            IInvoiceRepository invoiceRepository, 
                            IInvoiceIdGenerator idGenerator, 
                            IPresenter presenter) {
        this.menuRepository = menuRepository;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.invoiceRepository = invoiceRepository;
        this.idGenerator = idGenerator;
        this.presenter = presenter;
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = idGenerator.generateNext();
        List<OrderSummary> summaries = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menuRepository.getById(l.itemId);
            // Behavioral parity: original code does NOT check for null, so it would NPE if item is missing.
            // We preserve this behavior by letting it happen or being explicit. 
            // In a production app we'd handle it, but here "behavior identical" is key.
            double lineTotal = item.price * l.qty; 
            subtotal += lineTotal;
            summaries.add(new OrderSummary(item.name, l.qty, lineTotal));
        }

        double taxPct = taxPolicy.getTaxRate(customerType);
        double taxAmt = subtotal * (taxPct / 100.0);
        
        // Behavioral parity: original code used lines.size() which includes all incoming lines.
        double discount = discountPolicy.getDiscount(customerType, subtotal, lines.size());
        double total = subtotal + taxAmt - discount;

        Invoice inv = new Invoice(invId, summaries, subtotal, taxPct, taxAmt, discount, total);
        
        String formatted = presenter.formatInvoice(inv);
        presenter.renderInvoice(formatted);
        
        invoiceRepository.save(inv, formatted);
        
        presenter.renderSavedConfirmation(invId, invoiceRepository.getLineCount(invId));
    }
}
