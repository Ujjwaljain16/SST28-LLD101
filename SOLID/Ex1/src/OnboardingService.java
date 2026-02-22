import java.util.*;

public class OnboardingService {

    private final RawInputParser parser;
    private final RegistrationValidator validator;
    private final StudentRepository repository;
    private final StudentIdGenerator idGenerator;
    private final OnboardingPrinter printer;

    public OnboardingService(RawInputParser parser,
                             RegistrationValidator validator,
                             StudentRepository repository,
                             StudentIdGenerator idGenerator,
                             OnboardingPrinter printer) {
        this.parser = parser;
        this.validator = validator;
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        RegistrationData data = parser.parse(raw);
        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = idGenerator.nextId(repository.count());
        StudentRecord record = new StudentRecord(
                id,
                data.name,
                data.email,
                data.phone,
                data.program
        );

        repository.save(record);

        printer.printSuccess(record, repository.count());
    }
}
