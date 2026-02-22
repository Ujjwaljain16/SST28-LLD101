public class ConsoleEligibilityPresenter implements IEligibilityPresenter {
    @Override
    public void present(StudentProfile s, EligibilityResult r) {
        System.out.println("Student: " + s.name + " (CGR=" + String.format("%.2f", s.cgr)
                + ", attendance=" + s.attendancePct + ", credits=" + s.earnedCredits
                + ", flag=" + LegacyFlags.nameOf(s.disciplinaryFlag) + ")");
        System.out.println("RESULT: " + r.status);
        for (String reason : r.reasons) {
            System.out.println("- " + reason);
        }
    }
}
