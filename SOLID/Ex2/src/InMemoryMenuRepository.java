import java.util.*;

public class InMemoryMenuRepository implements IMenuRepository {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();

    @Override
    public void add(MenuItem item) {
        menu.put(item.id, item);
    }

    @Override
    public MenuItem getById(String id) {
        return menu.get(id);
    }
}
