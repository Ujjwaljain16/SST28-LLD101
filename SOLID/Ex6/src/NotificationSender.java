public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    /** Centralized send logic with auditing. */
    public final void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }

        try {
            doSend(n);
            audit.add(getChannelId() + " sent");
        } catch (RuntimeException ex) {
            audit.add(getChannelId() + " failed");
            throw ex;
        }
    }

    protected abstract void doSend(Notification n);
    protected abstract String getChannelId();
}
