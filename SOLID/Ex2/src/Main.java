import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Infrastructure / State
        IMenuRepository menu = new InMemoryMenuRepository();
        menu.add(new MenuItem("M1", "Veg Thali", 80.00));
        menu.add(new MenuItem("C1", "Coffee", 30.00));
        menu.add(new MenuItem("S1", "Sandwich", 60.00));

        // Dependencies
        IInvoiceRepository invoiceRepo = new FakeFileInvoiceRepository();
        IInvoiceIdGenerator idGenerator = new SequentialInvoiceIdGenerator();
        ITaxPolicy taxPolicy = new CampusTaxPolicy();
        IDiscountPolicy discountPolicy = new CampusDiscountPolicy();
        IPresenter presenter = new ConsolePresenter();

        // Orchestrator
        CafeteriaService sys = new CafeteriaService(
            menu, taxPolicy, discountPolicy, invoiceRepo, idGenerator, presenter
        );
        
        System.out.println("=== Cafeteria Billing ===");

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order);
    }
}
