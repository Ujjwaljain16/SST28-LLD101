public class SequentialInvoiceIdGenerator implements IInvoiceIdGenerator {
    private int seq = 1000;

    @Override
    public String generateNext() {
        return "INV-" + (++seq);
    }
}
