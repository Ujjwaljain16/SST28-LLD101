package com.example.reports;

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl;
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
        this.accessControl = new AccessControl();
    }

    @Override
    public void display(User user) {
        System.out.println("[Proxy] Checking access for user...");
        if (accessControl.canAccess(user, classification)) {
            System.out.println("[Proxy] Access granted");
            if (realReport == null) {
                realReport = new RealReport(reportId, title, classification);
            }
            realReport.display(user);
        } else {
            System.out.println("[Proxy] Access denied");
        }
    }
}
