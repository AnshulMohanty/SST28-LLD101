package com.example.reports;

/**
 * Proxy class
 *
 * Self note:
 * yaha 3 kaam ho rahe hain:
 * 1) access control
 * 2) lazy loading
 * 3) caching real report
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private final AccessControl accessControl = new AccessControl();


    // initially null -> lazy loading
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        //  1: access check
        if (!accessControl.canAccess(user, classification)) {

            System.out.println("ACCESS DENIED -> "
                    + user.getName()
                    + " cannot open report "
                    + reportId);

            return;
        }

        //  2: lazy loading
        if (realReport == null) {

            System.out.println("[proxy] creating RealReport for " + reportId);

            realReport = new RealReport(reportId, title, classification);
        }

        //  3: delegate to real object
        realReport.display(user);
    }
}