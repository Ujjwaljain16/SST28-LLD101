import java.util.Objects;

public abstract class Exporter {
    /** Centralized validation before export. */
    public final ExportResult export(ExportRequest req) {
        validate(req);
        return doExport(req);
    }

    protected void validate(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest cannot be null");
        }
    }

    protected abstract ExportResult doExport(ExportRequest req);
}
