package com.powerwise.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.powerwise.model.Consumption;
import com.powerwise.repository.ConsumptionRepository;

public class ConsumptionService {

    private ConsumptionRepository consumptionRepo;

    public ConsumptionService() {
        consumptionRepo = new ConsumptionRepository();
    }

    public void consumptionMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println("========== CONSUMPTION MENU ==========");
            System.out.println("1. Add Consumption");
            System.out.println("2. View Consumption");
            System.out.println("3. Update Consumption");
            System.out.println("4. Delete Consumption");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addConsumption(sc);
                    break;

                case 2:
                    viewConsumption();
                    break;

                case 3:
                    updateConsumption(sc);
                    break;

                case 4:
                    deleteConsumption(sc);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addConsumption(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD CONSUMPTION ---");

        System.out.print("Enter Meter ID: ");
        int meterId = sc.nextInt();

        System.out.print("Enter Previous Reading: ");
        double previousReading = sc.nextDouble();

        System.out.print("Enter Current Reading: ");
        double currentReading = sc.nextDouble();

        double unitsConsumed =
                currentReading - previousReading;

        System.out.println("Units Consumed: " + unitsConsumed);

        sc.nextLine();

        System.out.print("Enter Consumption Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Reading Date (yyyy-mm-dd): ");
        Date readingDate = Date.valueOf(sc.nextLine());

        Consumption consumption = new Consumption(
                meterId,
                previousReading,
                currentReading,
                unitsConsumed,
                type,
                readingDate
        );

        consumptionRepo.addConsumption(consumption);
    }

    private void viewConsumption() {

        System.out.println();
        System.out.println("--- ALL CONSUMPTION ---");

        List<Consumption> list =
                consumptionRepo.getAllConsumption();

        if (list.isEmpty()) {

            System.out.println("No consumption records found.");

        } else {

            for (Consumption c : list) {

                System.out.println(
                        "Consumption ID: " + c.getConsumptionId()
                        + " | Meter ID: " + c.getMeterId()
                        + " | Previous Reading: " + c.getPreviousReading()
                        + " | Current Reading: " + c.getCurrentReading()
                        + " | Units Consumed: " + c.getUnitsConsumed()
                        + " | Type: " + c.getConsumptionType()
                        + " | Reading Date: " + c.getReadingDate()
                );
            }
        }
    }

    private void updateConsumption(Scanner sc) {

        System.out.println();
        System.out.println("--- UPDATE CONSUMPTION ---");

        System.out.print("Enter Consumption ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Meter ID: ");
        int meterId = sc.nextInt();

        System.out.print("Enter New Previous Reading: ");
        double previous = sc.nextDouble();

        System.out.print("Enter New Current Reading: ");
        double current = sc.nextDouble();

        double units =
                current - previous;

        sc.nextLine();

        System.out.print("Enter New Consumption Type: ");
        String type = sc.nextLine();

        System.out.print("Enter New Reading Date (yyyy-mm-dd): ");
        Date date = Date.valueOf(sc.nextLine());

        Consumption consumption = new Consumption(
                id,
                meterId,
                previous,
                current,
                units,
                type,
                date
        );

        consumptionRepo.updateConsumption(consumption);
    }

    private void deleteConsumption(Scanner sc) {

        System.out.println();
        System.out.println("--- DELETE CONSUMPTION ---");

        System.out.print("Enter Consumption ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        consumptionRepo.deleteConsumption(id);
    }
}