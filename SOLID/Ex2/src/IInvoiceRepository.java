public interface IInvoiceRepository {
    void save(Invoice invoice, String formattedContent);
    int getLineCount(String invoiceId);
}
