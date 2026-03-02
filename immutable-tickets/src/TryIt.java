import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        // Demonstrate updates that create new instances 
        IncidentTicket assignedTicket = service.assign(t, "agent@example.com");
        IncidentTicket escalatedTicket = service.escalateToCritical(assignedTicket);
        System.out.println("\nAfter service updates: " + escalatedTicket);

        // Demonstrate external mutation block 
        try {
            List<String> tags = escalatedTicket.getTags();
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nExternal tag mutation prevented successfully: UnsupportedOperationException caught.");
        }

        System.out.println("\nOriginal ticket remains unchanged: " + t);
    }
}
