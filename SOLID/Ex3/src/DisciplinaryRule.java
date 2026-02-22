public class DisciplinaryRule implements IEligibilityRule {
    @Override
    public RuleResult evaluate(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return RuleResult.fail("disciplinary flag present");
        }
        return RuleResult.pass();
    }
}
