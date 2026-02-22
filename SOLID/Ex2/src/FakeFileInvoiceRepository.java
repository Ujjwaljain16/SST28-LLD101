import java.util.*;

public class FakeFileInvoiceRepository implements IInvoiceRepository {
    private final Map<String, String> files = new HashMap<>();

    @Override
    public void save(Invoice invoice, String content) {
        files.put(invoice.id, content);
    }

    @Override
    public int getLineCount(String invoiceId) {
        String c = files.getOrDefault(invoiceId, "");
        if (c.isEmpty()) return 0;
        return c.split("\n").length;
    }
}
