public class ConsolePresenter implements IPresenter {
    @Override
    public String formatInvoice(Invoice inv) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(inv.id).append("\n");
        for (OrderSummary s : inv.lines) {
            sb.append(String.format("- %s x%d = %.2f\n", s.itemName, s.qty, s.lineTotal));
        }
        sb.append(String.format("Subtotal: %.2f\n", inv.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", inv.taxRate, inv.taxAmount));
        sb.append(String.format("Discount: -%.2f\n", inv.discount));
        sb.append(String.format("TOTAL: %.2f\n", inv.total));
        return sb.toString();
    }

    @Override
    public void renderInvoice(String content) {
        System.out.print(content);
    }

    @Override
    public void renderSavedConfirmation(String id, int lineCount) {
        System.out.println("Saved invoice: " + id + " (lines=" + lineCount + ")");
    }
}
