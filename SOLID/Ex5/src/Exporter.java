import java.util.Objects;

public abstract class Exporter {
    /**
     * Standardized export method. 
     * Centralizes validation to ensure all subtypes follow the same entry contract.
     * @throws IllegalArgumentException if req is null.
     * @throws ExportConstraintException if format-specific limits are exceeded.
     */
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
