public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    protected void doSend(Notification n) {
        // Formally enforcing declared constraint via exception
        if (n.phone == null || !n.phone.startsWith("+")) {
            throw new NotificationConstraintException("phone must start with + and country code");
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
    }

    @Override
    protected String getChannelId() {
        return "wa";
    }
}
