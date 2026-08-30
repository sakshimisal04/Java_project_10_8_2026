package com.powerwise.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.powerwise.model.Alert;
import com.powerwise.repository.AlertRepository;

public class AlertService {

    private AlertRepository alertRepo;

    public AlertService() {
        alertRepo = new AlertRepository();
    }

    public void alertMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println("========== ALERT MENU ==========");
            System.out.println("1. Add Alert");
            System.out.println("2. View Alerts");
            System.out.println("3. Update Alert");
            System.out.println("4. Delete Alert");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addAlert(sc);
                    break;

                case 2:
                    viewAlerts();
                    break;

                case 3:
                    updateAlert(sc);
                    break;

                case 4:
                    deleteAlert(sc);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addAlert(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD ALERT ---");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter Current Usage: ");
        double currentUsage = sc.nextDouble();

        System.out.print("Enter Threshold Value: ");
        double threshold = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Alert Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Message: ");
        String message = sc.nextLine();

        System.out.print(
                "Enter Alert Date/Time (yyyy-mm-dd hh:mm:ss): "
        );

        Timestamp date =
                Timestamp.valueOf(sc.nextLine());

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        Alert alert = new Alert(
                userId,
                currentUsage,
                threshold,
                type,
                message,
                date,
                status
        );

        alertRepo.addAlert(alert);
    }

    private void viewAlerts() {

        System.out.println();
        System.out.println("--- ALL ALERTS ---");

        List<Alert> alerts =
                alertRepo.getAllAlerts();

        if (alerts.isEmpty()) {

            System.out.println("No alerts found.");

        } else {

            for (Alert a : alerts) {

                System.out.println(
                        "Alert ID: " + a.getAlertId()
                        + " | User ID: " + a.getUserId()
                        + " | Current Usage: " + a.getCurrentUsage()
                        + " | Threshold: " + a.getThresholdValue()
                        + " | Type: " + a.getAlertType()
                        + " | Message: " + a.getMessage()
                        + " | Alert Date: " + a.getAlertDate()
                        + " | Status: " + a.getStatus()
                );
            }
        }
    }

    private void updateAlert(Scanner sc) {

        System.out.println();
        System.out.println("--- UPDATE ALERT ---");

        System.out.print("Enter Alert ID: ");
        int alertId = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter New Current Usage: ");
        double usage = sc.nextDouble();

        System.out.print("Enter New Threshold Value: ");
        double threshold = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter New Alert Type: ");
        String type = sc.nextLine();

        System.out.print("Enter New Message: ");
        String message = sc.nextLine();

        System.out.print(
                "Enter New Alert Date/Time (yyyy-mm-dd hh:mm:ss): "
        );

        Timestamp date =
                Timestamp.valueOf(sc.nextLine());

        System.out.print("Enter New Status: ");
        String status = sc.nextLine();

        Alert alert = new Alert(
                alertId,
                userId,
                usage,
                threshold,
                type,
                message,
                date,
                status
        );

        alertRepo.updateAlert(alert);
    }

    private void deleteAlert(Scanner sc) {

        System.out.println();
        System.out.println("--- DELETE ALERT ---");

        System.out.print("Enter Alert ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        alertRepo.deleteAlert(id);
    }
}