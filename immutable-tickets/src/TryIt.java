import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import com.example.tickets.*;


import java.util.List;

public class TryIt {

    public static void main(String[] args) {

        TicketService service = new TicketService();

        IncidentTicket t1 = service.createTicket(
                "TCK-1001",
                "reporter@example.com",
                "Payment failing on checkout"
        );

        System.out.println("Created: " + t1);

        // Updating creates NEW object
        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);

        System.out.println("\nAfter updates (new objects): " + t3);

        // Attempt external mutation
        List<String> tags = t3.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (Exception e) {
            System.out.println("\nExternal mutation blocked: " + e);
        }

        System.out.println("\nFinal ticket (still safe): " + t3);
    }
}