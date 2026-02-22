import java.util.Random;

public class DeterministicBookingIdGenerator implements IBookingIdGenerator {
    private final Random rand = new Random(1);

    @Override
    public String generate() {
        return "H-" + (7000 + rand.nextInt(1000));
    }
}
