import java.util.*;

public class EligibilityService {
    private final List<IEligibilityRule> rules;
    private final IEligibilityRepository repository;
    private final IEligibilityPresenter presenter;

    public EligibilityService(List<IEligibilityRule> rules, 
                             IEligibilityRepository repository, 
                             IEligibilityPresenter presenter) {
        this.rules = rules;
        this.repository = repository;
        this.presenter = presenter;
    }

    public void runAndPrint(StudentProfile s) {
        EligibilityResult r = evaluate(s);
        presenter.present(s, r);
        repository.save(s.rollNo, r.status);
    }

    private EligibilityResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for (IEligibilityRule rule : rules) {
            RuleResult rr = rule.evaluate(s);
            if (!rr.passed) {
                status = "NOT_ELIGIBLE";
                reasons.add(rr.reason);
                break; // stop at first failure to match legacy engine
            }
        }

        return new EligibilityResult(status, reasons);
    }
}
