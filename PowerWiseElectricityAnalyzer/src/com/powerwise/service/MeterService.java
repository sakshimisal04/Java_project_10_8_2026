package com.powerwise.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.powerwise.model.Meter;
import com.powerwise.repository.MeterRepository;

public class MeterService {

    private MeterRepository meterRepo;

    public MeterService() {
        meterRepo = new MeterRepository();
    }

    public void meterMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println("========== METER MENU ==========");
            System.out.println("1. Add Meter");
            System.out.println("2. View Meters");
            System.out.println("3. Update Meter");
            System.out.println("4. Delete Meter");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addMeter(sc);
                    break;

                case 2:
                    viewMeters();
                    break;

                case 3:
                    updateMeter(sc);
                    break;

                case 4:
                    deleteMeter(sc);
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addMeter(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD METER ---");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Meter Number: ");
        String meterNumber = sc.nextLine();

        System.out.print("Enter Meter Type: ");
        String meterType = sc.nextLine();

        System.out.print("Enter Installation Date (yyyy-mm-dd): ");
        Date installationDate = Date.valueOf(sc.nextLine());

        System.out.print("Enter Current Reading: ");
        double currentReading = sc.nextDouble();
        sc.nextLine();

        Meter meter = new Meter(
                userId,
                meterNumber,
                meterType,
                installationDate,
                currentReading
        );

        meterRepo.addMeter(meter);
    }

    private void viewMeters() {

        System.out.println();
        System.out.println("--- ALL METERS ---");

        List<Meter> meters = meterRepo.getAllMeters();

        if (meters.isEmpty()) {

            System.out.println("No meters found.");

        } else {

            for (Meter m : meters) {

                System.out.println(
                        "Meter ID: " + m.getMeterId()
                        + " | User ID: " + m.getUserId()
                        + " | Meter Number: " + m.getMeterNumber()
                        + " | Type: " + m.getMeterType()
                        + " | Installation Date: " + m.getInstallationDate()
                        + " | Current Reading: " + m.getCurrentReading()
                );
            }
        }
    }

    private void updateMeter(Scanner sc) {

        System.out.println();
        System.out.println("--- UPDATE METER ---");

        System.out.print("Enter Meter ID: ");
        int meterId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Meter Number: ");
        String meterNumber = sc.nextLine();

        System.out.print("Enter New Meter Type: ");
        String meterType = sc.nextLine();

        System.out.print("Enter New Installation Date (yyyy-mm-dd): ");
        Date installationDate = Date.valueOf(sc.nextLine());

        System.out.print("Enter New Current Reading: ");
        double currentReading = sc.nextDouble();
        sc.nextLine();

        Meter updatedMeter = new Meter(
                meterId,
                userId,
                meterNumber,
                meterType,
                installationDate,
                currentReading
        );

        meterRepo.updateMeter(updatedMeter);
    }

    private void deleteMeter(Scanner sc) {

        System.out.println();
        System.out.println("--- DELETE METER ---");

        System.out.print("Enter Meter ID: ");
        int meterId = sc.nextInt();
        sc.nextLine();

        meterRepo.deleteMeter(meterId);
    }
}