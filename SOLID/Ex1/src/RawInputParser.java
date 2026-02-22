import java.util.*;

public class RawInputParser {

    public RegistrationData parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        if (raw != null) {
            String[] parts = raw.split(";");
            for (String p : parts) {
                String[] t = p.split("=", 2);
                if (t.length == 2) {
                    kv.put(t[0].trim(), t[1].trim());
                }
            }
        }

        return new RegistrationData(
                kv.getOrDefault("name", ""),
                kv.getOrDefault("email", ""),
                kv.getOrDefault("phone", ""),
                kv.getOrDefault("program", "")
        );
    }
}
