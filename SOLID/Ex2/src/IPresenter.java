public interface IPresenter {
    String formatInvoice(Invoice invoice);
    void renderInvoice(String content);
    void renderSavedConfirmation(String id, int lineCount);
}
