public class CgrRule implements IEligibilityRule {
    private final double threshold;

    public CgrRule(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public RuleResult evaluate(StudentProfile student) {
        if (student.cgr < threshold) {
            return RuleResult.fail("CGR below " + String.format("%.1f", threshold));
        }
        return RuleResult.pass();
    }
}
