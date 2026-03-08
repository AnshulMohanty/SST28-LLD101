package com.example.reports;

/**
 * Self note:
 * client ko abstraction pe depend karna chahiye
 * concrete class pe nahi.
 */
public class ReportViewer {

    public void open(Report report, User user) {

        report.display(user);

    }
}