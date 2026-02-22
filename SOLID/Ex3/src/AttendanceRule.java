public class AttendanceRule implements IEligibilityRule {
    private final int threshold;

    public AttendanceRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public RuleResult evaluate(StudentProfile student) {
        if (student.attendancePct < threshold) {
            return RuleResult.fail("attendance below " + threshold);
        }
        return RuleResult.pass();
    }
}
