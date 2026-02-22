public class CreditsRule implements IEligibilityRule {
    private final int threshold;

    public CreditsRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public RuleResult evaluate(StudentProfile student) {
        if (student.earnedCredits < threshold) {
            return RuleResult.fail("credits below " + threshold);
        }
        return RuleResult.pass();
    }
}
