package com.example.reports;

/**
 * Real Subject
 *
 * Self note:
 * yaha expensive disk loading logic hai.
 * proxy isko lazy load karega jab zarurat hogi.
 */
public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private final String content;

    public RealReport(String reportId, String title, String classification) {

        this.reportId = reportId;
        this.title = title;
        this.classification = classification;

        
        // expensive operation constructor me hi kar rahe hain
        this.content = loadFromDisk();
    }

    @Override
    public void display(User user) {

        System.out.println("REPORT -> id=" + reportId
                + " title=" + title
                + " classification=" + classification
                + " openedBy=" + user.getName());

        System.out.println("CONTENT: " + content);
    }

    private String loadFromDisk() {

        System.out.println("[disk] loading report " + reportId + " ...");

        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "Internal report body for " + title;
    }

    public String getClassification() {
        return classification;
    }
}