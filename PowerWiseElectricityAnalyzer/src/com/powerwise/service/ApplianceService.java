package com.powerwise.service;

import java.util.List;
import java.util.Scanner;

import com.powerwise.model.Appliance;
import com.powerwise.repository.ApplianceRepository;

public class ApplianceService {

    private ApplianceRepository applianceRepo;

    public ApplianceService() {
        applianceRepo = new ApplianceRepository();
    }

    public void applianceMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println("========== APPLIANCE MENU ==========");
            System.out.println("1. Add Appliance");
            System.out.println("2. View Appliances");
            System.out.println("3. Update Appliance");
            System.out.println("4. Delete Appliance");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addAppliance(sc);
                    break;

                case 2:
                    viewAppliances();
                    break;

                case 3:
                    updateAppliance(sc);
                    break;

                case 4:
                    deleteAppliance(sc);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addAppliance(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD APPLIANCE ---");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Appliance Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Power Rating (Watts): ");
        double power = sc.nextDouble();

        System.out.print("Enter Hours Used Per Day: ");
        double hours = sc.nextDouble();

        // Automatic calculation
        double estimatedUnits =
                (power * hours * quantity) / 1000;

        System.out.println(
                "Estimated Units Per Day: " + estimatedUnits
        );

        Appliance appliance = new Appliance(
                userId,
                name,
                quantity,
                power,
                hours,
                estimatedUnits
        );

        applianceRepo.addAppliance(appliance);
    }

    private void viewAppliances() {

        System.out.println();
        System.out.println("--- ALL APPLIANCES ---");

        List<Appliance> appliances =
                applianceRepo.getAllAppliances();

        if (appliances.isEmpty()) {

            System.out.println("No appliances found.");

        } else {

            for (Appliance a : appliances) {

                System.out.println(
                        "Appliance ID: " + a.getApplianceId()
                        + " | User ID: " + a.getUserId()
                        + " | Name: " + a.getApplianceName()
                        + " | Quantity: " + a.getQuantity()
                        + " | Power Rating: " + a.getPowerRating() + " W"
                        + " | Hours/Day: " + a.getHoursUsedPerDay()
                        + " | Estimated Units: " + a.getEstimatedUnits()
                );
            }
        }
    }

    private void updateAppliance(Scanner sc) {

        System.out.println();
        System.out.println("--- UPDATE APPLIANCE ---");

        System.out.print("Enter Appliance ID: ");
        int applianceId = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter New Appliance Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter New Power Rating (Watts): ");
        double power = sc.nextDouble();

        System.out.print("Enter New Hours Used Per Day: ");
        double hours = sc.nextDouble();

        double estimatedUnits =
                (power * hours * quantity) / 1000;

        Appliance appliance = new Appliance(
                applianceId,
                userId,
                name,
                quantity,
                power,
                hours,
                estimatedUnits
        );

        applianceRepo.updateAppliance(appliance);
    }

    private void deleteAppliance(Scanner sc) {

        System.out.println();
        System.out.println("--- DELETE APPLIANCE ---");

        System.out.print("Enter Appliance ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        applianceRepo.deleteAppliance(id);
    }
}