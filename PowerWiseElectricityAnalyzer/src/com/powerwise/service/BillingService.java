package com.powerwise.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.powerwise.model.Billing;
import com.powerwise.repository.BillingRepository;

public class BillingService {

    private BillingRepository billingRepo;

    public BillingService() {
        billingRepo = new BillingRepository();
    }

    public void billingMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println("========== BILLING MENU ==========");
            System.out.println("1. Add Billing");
            System.out.println("2. View Billings");
            System.out.println("3. Update Billing");
            System.out.println("4. Delete Billing");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBilling(sc);
                    break;

                case 2:
                    viewBillings();
                    break;

                case 3:
                    updateBilling(sc);
                    break;

                case 4:
                    deleteBilling(sc);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addBilling(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD BILLING ---");

        System.out.print("Enter Meter ID: ");
        int meterId = sc.nextInt();

        System.out.print("Enter Units Consumed: ");
        double units = sc.nextDouble();

        System.out.print("Enter Rate Per Unit: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Fixed Charge: ");
        double fixedCharge = sc.nextDouble();

        double totalAmount =
                (units * rate) + fixedCharge;

        System.out.println("Total Amount: " + totalAmount);

        sc.nextLine();

        System.out.print("Enter Billing Month (yyyy-mm-dd): ");
        Date billingMonth = Date.valueOf(sc.nextLine());

        System.out.print("Enter Due Date (yyyy-mm-dd): ");
        Date dueDate = Date.valueOf(sc.nextLine());

        System.out.print("Enter Payment Status: ");
        String status = sc.nextLine();

        Billing billing = new Billing(
                meterId,
                units,
                rate,
                fixedCharge,
                totalAmount,
                billingMonth,
                dueDate,
                status
        );

        billingRepo.addBilling(billing);
    }

    private void viewBillings() {

        System.out.println();
        System.out.println("--- ALL BILLINGS ---");

        List<Billing> list =
                billingRepo.getAllBilling();

        if (list.isEmpty()) {

            System.out.println("No billing records found.");

        } else {

            for (Billing b : list) {

                System.out.println(
                        "Bill ID: " + b.getBillId()
                        + " | Meter ID: " + b.getMeterId()
                        + " | Units: " + b.getUnitsConsumed()
                        + " | Rate/Unit: " + b.getRatePerUnit()
                        + " | Fixed Charge: " + b.getFixedCharge()
                        + " | Total Amount: " + b.getTotalAmount()
                        + " | Billing Month: " + b.getBillingMonth()
                        + " | Due Date: " + b.getDueDate()
                        + " | Payment Status: " + b.getPaymentStatus()
                );
            }
        }
    }

    private void updateBilling(Scanner sc) {

        System.out.println();
        System.out.println("--- UPDATE BILLING ---");

        System.out.print("Enter Bill ID: ");
        int billId = sc.nextInt();

        System.out.print("Enter Meter ID: ");
        int meterId = sc.nextInt();

        System.out.print("Enter New Units Consumed: ");
        double units = sc.nextDouble();

        System.out.print("Enter New Rate Per Unit: ");
        double rate = sc.nextDouble();

        System.out.print("Enter New Fixed Charge: ");
        double fixedCharge = sc.nextDouble();

        double totalAmount =
                (units * rate) + fixedCharge;

        sc.nextLine();

        System.out.print("Enter New Billing Month (yyyy-mm-dd): ");
        Date month = Date.valueOf(sc.nextLine());

        System.out.print("Enter New Due Date (yyyy-mm-dd): ");
        Date dueDate = Date.valueOf(sc.nextLine());

        System.out.print("Enter New Payment Status: ");
        String status = sc.nextLine();

        Billing billing = new Billing(
                billId,
                meterId,
                units,
                rate,
                fixedCharge,
                totalAmount,
                month,
                dueDate,
                status
        );

        billingRepo.updateBilling(billing);
    }

    private void deleteBilling(Scanner sc) {

        System.out.println();
        System.out.println("--- DELETE BILLING ---");

        System.out.print("Enter Bill ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        billingRepo.deleteBilling(id);
    }
}