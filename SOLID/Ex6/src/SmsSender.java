public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    protected void doSend(Notification n) {
        // Capability variance legalized by contract - subject ignorance is allowed
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
    }

    @Override
    protected String getChannelId() {
        return "sms";
    }
}
