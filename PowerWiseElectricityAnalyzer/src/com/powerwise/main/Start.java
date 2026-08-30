package com.powerwise.main;

import java.util.Scanner;

import com.powerwise.service.UserService;
import com.powerwise.service.MeterService;
import com.powerwise.service.ApplianceService;
import com.powerwise.service.ConsumptionService;
import com.powerwise.service.BillingService;
import com.powerwise.service.AlertService;
import com.powerwise.service.EnergySuggestionService;

public class Start {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Service objects
        UserService userService = new UserService();
        MeterService meterService = new MeterService();
        ApplianceService applianceService = new ApplianceService();
        ConsumptionService consumptionService = new ConsumptionService();
        BillingService billingService = new BillingService();
        AlertService alertService = new AlertService();
        EnergySuggestionService suggestionService =
                new EnergySuggestionService();

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("      POWERWISE ELECTRICITY ANALYZER");
            System.out.println("========================================");

            System.out.println("1. User");
            System.out.println("2. Meter");
            System.out.println("3. Appliance");
            System.out.println("4. Consumption");
            System.out.println("5. Billing");
            System.out.println("6. Alert");
            System.out.println("7. Energy Suggestion");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userService.userMenu(sc);
                    break;

                case 2:
                    meterService.meterMenu(sc);
                    break;

                case 3:
                    applianceService.applianceMenu(sc);
                    break;

                case 4:
                    consumptionService.consumptionMenu(sc);
                    break;

                case 5:
                    billingService.billingMenu(sc);
                    break;

                case 6:
                    alertService.alertMenu(sc);
                    break;

                case 7:
                    suggestionService.suggestionMenu(sc);
                    break;

                case 8:
                    System.out.println();
                    System.out.println("Thank you for using PowerWise.");
                    sc.close();
                    return;

                default:
                    System.out.println();
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }
        }
    }
}