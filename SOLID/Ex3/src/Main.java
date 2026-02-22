import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Infrastructure
        IEligibilityRepository store = new FakeEligibilityStore();
        IEligibilityPresenter presenter = new ConsoleEligibilityPresenter();

        // Configuration (Stretch Goal: Load thresholds from a config object)
        RuleInput config = new RuleInput();

        // Policy Rules (Order matters for behavioral parity since we stop at first failure)
        List<IEligibilityRule> rules = List.of(
            new DisciplinaryRule(),
            new CgrRule(config.minCgr),
            new AttendanceRule(config.minAttendance),
            new CreditsRule(config.minCredits)
        );

        // Service
        EligibilityService engine = new EligibilityService(rules, store, presenter);

        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        engine.runAndPrint(s);
    }
}
