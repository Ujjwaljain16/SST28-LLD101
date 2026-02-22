public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    /**
     * Standardized send method (Template Method).
     * Centralizes null validation and audit log invariants.
     */
    public final void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }

        try {
            doSend(n);
            audit.add(getChannelId() + " sent");
        } catch (RuntimeException ex) {
            // Centralize audit logging for failures to ensure consistency across channels
            audit.add(getChannelId() + " failed");
            throw ex;
        }
    }

    protected abstract void doSend(Notification n);
    protected abstract String getChannelId();
}
