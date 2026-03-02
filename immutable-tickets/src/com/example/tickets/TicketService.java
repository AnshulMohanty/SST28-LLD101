package com.example.tickets;

public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {

        // No validation here now
        // Builder will handle everything

        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .addTag("NEW")
                .build();
    }

    // Instead of mutating, return new object
    public IncidentTicket escalateToCritical(IncidentTicket t) {

        return t.toBuilder()
                .priority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {

        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}