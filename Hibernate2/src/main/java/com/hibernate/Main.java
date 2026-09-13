package com.hibernate;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.hibernate.dao.PowerWiseDAO;
import com.hibernate.entity.Alert;
import com.hibernate.entity.Appliance;
import com.hibernate.entity.Billing;
import com.hibernate.entity.Consumption;
import com.hibernate.entity.EnergySuggestion;
import com.hibernate.entity.Meter;
import com.hibernate.entity.User;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static PowerWiseDAO dao = new PowerWiseDAO();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== POWERWISE HIBERNATE =====");
            System.out.println("1. User");
            System.out.println("2. Meter");
            System.out.println("3. Appliance");
            System.out.println("4. Consumption");
            System.out.println("5. Billing");
            System.out.println("6. Alert");
            System.out.println("7. Energy Suggestion");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    userMenu();
                    break;

                case 2:
                    meterMenu();
                    break;

                case 3:
                    applianceMenu();
                    break;

                case 4:
                    consumptionMenu();
                    break;

                case 5:
                    billingMenu();
                    break;

                case 6:
                    alertMenu();
                    break;

                case 7:
                    energySuggestionMenu();
                    break;

                case 8:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }


    // =====================================================
    // USER CRUD
    // =====================================================

    static void userMenu() {

        System.out.println("\n===== USER CRUD =====");
        System.out.println("1. Create User");
        System.out.println("2. View All Users");
        System.out.println("3. Find User By ID");
        System.out.println("4. Update User");
        System.out.println("5. Delete User");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                User user = new User(
                        "Mansi Misal",
                        "mansimisal@gmail.com",
                        "9999999999",
                        "Thane",
                        "12345"
                );

                dao.saveUser(user);

                System.out.println("User ID: " + user.getUserId());

                break;


            case 2:

                List<User> users = dao.getAllUsers();

                if (users != null) {

                    for (User u : users) {
                        System.out.println(u);
                    }
                }

                break;


            case 3:

                System.out.print("Enter User ID: ");
                int userId = sc.nextInt();

                User foundUser = dao.getUserById(userId);

                if (foundUser != null) {
                    System.out.println(foundUser);
                } else {
                    System.out.println("User not found.");
                }

                break;


            case 4:

                User updateUser = new User(
                        1,
                        "Mansi Misal",
                        "mansimisal@gmail.com",
                        "9999999999",
                        "Thane",
                        "12345"
                );

                dao.updateUser(updateUser);

                break;


            case 5:

                System.out.print("Enter User ID to delete: ");
                int deleteUserId = sc.nextInt();

                dao.deleteUser(deleteUserId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }


    // =====================================================
    // METER CRUD
    // =====================================================

    static void meterMenu() {

        System.out.println("\n===== METER CRUD =====");
        System.out.println("1. Create Meter");
        System.out.println("2. View All Meters");
        System.out.println("3. Find Meter By ID");
        System.out.println("4. Update Meter");
        System.out.println("5. Delete Meter");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                Meter meter = new Meter(
                        1,
                        "MTR001",
                        "Digital",
                        Date.valueOf("2026-09-13"),
                        1250.50
                );

                dao.saveMeter(meter);

                System.out.println("Meter ID: " + meter.getMeterId());

                break;


            case 2:

                List<Meter> meters = dao.getAllMeters();

                if (meters != null) {

                    for (Meter m : meters) {

                        System.out.println(
                                "ID: " + m.getMeterId()
                                + " | User ID: " + m.getUserId()
                                + " | Meter No: " + m.getMeterNumber()
                                + " | Type: " + m.getMeterType()
                                + " | Reading: " + m.getCurrentReading()
                        );
                    }
                }

                break;


            case 3:

                System.out.print("Enter Meter ID: ");
                int meterId = sc.nextInt();

                Meter foundMeter = dao.getMeterById(meterId);

                if (foundMeter != null) {

                    System.out.println(
                            "ID: " + foundMeter.getMeterId()
                            + " | User ID: " + foundMeter.getUserId()
                            + " | Meter No: " + foundMeter.getMeterNumber()
                            + " | Type: " + foundMeter.getMeterType()
                            + " | Reading: " + foundMeter.getCurrentReading()
                    );

                } else {

                    System.out.println("Meter not found.");
                }

                break;


            case 4:

                Meter updateMeter = new Meter(
                        1,
                        1,
                        "MTR001",
                        "Digital",
                        Date.valueOf("2026-09-13"),
                        1500.75
                );

                dao.updateMeter(updateMeter);

                break;


            case 5:

                System.out.print("Enter Meter ID to delete: ");
                int deleteMeterId = sc.nextInt();

                dao.deleteMeter(deleteMeterId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }


    // =====================================================
    // APPLIANCE CRUD
    // =====================================================

    static void applianceMenu() {

        System.out.println("\n===== APPLIANCE CRUD =====");
        System.out.println("1. Create Appliance");
        System.out.println("2. View All Appliances");
        System.out.println("3. Find Appliance By ID");
        System.out.println("4. Update Appliance");
        System.out.println("5. Delete Appliance");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                Appliance appliance = new Appliance(
                        1,
                        "AC",
                        1,
                        1500,
                        6,
                        270
                );

                dao.saveAppliance(appliance);

                System.out.println(
                        "Appliance ID: "
                        + appliance.getApplianceId()
                );

                break;


            case 2:

                List<Appliance> appliances =
                        dao.getAllAppliances();

                if (appliances != null) {

                    for (Appliance a : appliances) {

                        System.out.println(
                                "ID: " + a.getApplianceId()
                                + " | User ID: " + a.getUserId()
                                + " | Name: " + a.getApplianceName()
                                + " | Quantity: " + a.getQuantity()
                                + " | Power: " + a.getPowerRating()
                                + " W"
                                + " | Hours: " + a.getHoursUsedPerDay()
                                + " | Units: " + a.getEstimatedUnits()
                        );
                    }
                }

                break;


            case 3:

                System.out.print("Enter Appliance ID: ");
                int applianceId = sc.nextInt();

                Appliance foundAppliance =
                        dao.getApplianceById(applianceId);

                if (foundAppliance != null) {

                    System.out.println(
                            "ID: " + foundAppliance.getApplianceId()
                            + " | Name: "
                            + foundAppliance.getApplianceName()
                            + " | Units: "
                            + foundAppliance.getEstimatedUnits()
                    );

                } else {

                    System.out.println("Appliance not found.");
                }

                break;


            case 4:

                Appliance updateAppliance = new Appliance(
                        1,
                        1,
                        "AC",
                        1,
                        1500,
                        5,
                        225
                );

                dao.updateAppliance(updateAppliance);

                break;


            case 5:

                System.out.print("Enter Appliance ID to delete: ");
                int deleteApplianceId = sc.nextInt();

                dao.deleteAppliance(deleteApplianceId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }


    // =====================================================
    // CONSUMPTION CRUD
    // =====================================================

    static void consumptionMenu() {

        System.out.println("\n===== CONSUMPTION CRUD =====");
        System.out.println("1. Create Consumption");
        System.out.println("2. View All Consumptions");
        System.out.println("3. Find Consumption By ID");
        System.out.println("4. Update Consumption");
        System.out.println("5. Delete Consumption");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                Consumption consumption = new Consumption(
                        1,
                        1000,
                        1250,
                        250,
                        "Monthly",
                        Date.valueOf("2026-09-13")
                );

                dao.saveConsumption(consumption);

                System.out.println(
                        "Consumption ID: "
                        + consumption.getConsumptionId()
                );

                break;


            case 2:

                List<Consumption> consumptions =
                        dao.getAllConsumptions();

                if (consumptions != null) {

                    for (Consumption c : consumptions) {

                        System.out.println(
                                "ID: " + c.getConsumptionId()
                                + " | Meter ID: " + c.getMeterId()
                                + " | Previous: "
                                + c.getPreviousReading()
                                + " | Current: "
                                + c.getCurrentReading()
                                + " | Units: "
                                + c.getUnitsConsumed()
                                + " | Type: "
                                + c.getConsumptionType()
                        );
                    }
                }

                break;


            case 3:

                System.out.print("Enter Consumption ID: ");
                int consumptionId = sc.nextInt();

                Consumption foundConsumption =
                        dao.getConsumptionById(consumptionId);

                if (foundConsumption != null) {

                    System.out.println(
                            "ID: "
                            + foundConsumption.getConsumptionId()
                            + " | Meter ID: "
                            + foundConsumption.getMeterId()
                            + " | Units: "
                            + foundConsumption.getUnitsConsumed()
                    );

                } else {

                    System.out.println("Consumption not found.");
                }

                break;


            case 4:

                Consumption updateConsumption =
                        new Consumption(
                                1,
                                1000,
                                1300,
                                300,
                                "Monthly",
                                Date.valueOf("2026-09-13")
                        );

                dao.updateConsumption(updateConsumption);

                break;


            case 5:

                System.out.print(
                        "Enter Consumption ID to delete: "
                );

                int deleteConsumptionId = sc.nextInt();

                dao.deleteConsumption(deleteConsumptionId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }


    // =====================================================
    // BILLING CRUD
    // =====================================================

    static void billingMenu() {

        System.out.println("\n===== BILLING CRUD =====");
        System.out.println("1. Create Billing");
        System.out.println("2. View All Billing");
        System.out.println("3. Find Billing By ID");
        System.out.println("4. Update Billing");
        System.out.println("5. Delete Billing");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                Billing billing = new Billing(
                        1,
                        250,
                        8.50,
                        100,
                        2225,
                        Date.valueOf("2026-09-01"),
                        Date.valueOf("2026-09-20"),
                        "Pending"
                );

                dao.saveBilling(billing);

                System.out.println(
                        "Bill ID: " + billing.getBillId()
                );

                break;


            case 2:

                List<Billing> billings =
                        dao.getAllBillings();

                if (billings != null) {

                    for (Billing b : billings) {

                        System.out.println(
                                "Bill ID: " + b.getBillId()
                                + " | Meter ID: " + b.getMeterId()
                                + " | Units: " + b.getUnitsConsumed()
                                + " | Total: " + b.getTotalAmount()
                                + " | Status: "
                                + b.getPaymentStatus()
                        );
                    }
                }

                break;


            case 3:

                System.out.print("Enter Bill ID: ");
                int billId = sc.nextInt();

                Billing foundBilling =
                        dao.getBillingById(billId);

                if (foundBilling != null) {

                    System.out.println(
                            "Bill ID: "
                            + foundBilling.getBillId()
                            + " | Total: "
                            + foundBilling.getTotalAmount()
                            + " | Status: "
                            + foundBilling.getPaymentStatus()
                    );

                } else {

                    System.out.println("Billing record not found.");
                }

                break;


            case 4:

                Billing updateBilling = new Billing(
                        1,
                        1,
                        300,
                        8.50,
                        100,
                        2650,
                        Date.valueOf("2026-09-01"),
                        Date.valueOf("2026-09-20"),
                        "Paid"
                );

                dao.updateBilling(updateBilling);

                break;


            case 5:

                System.out.print("Enter Bill ID to delete: ");
                int deleteBillId = sc.nextInt();

                dao.deleteBilling(deleteBillId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }


    // =====================================================
    // ALERT CRUD
    // =====================================================

    static void alertMenu() {

        System.out.println("\n===== ALERT CRUD =====");
        System.out.println("1. Create Alert");
        System.out.println("2. View All Alerts");
        System.out.println("3. Find Alert By ID");
        System.out.println("4. Update Alert");
        System.out.println("5. Delete Alert");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                Alert alert = new Alert(
                        1,
                        350,
                        300,
                        "High Usage",
                        "Electricity consumption is high.",
                        new Timestamp(System.currentTimeMillis()),
                        "Unread"
                );

                dao.saveAlert(alert);

                System.out.println(
                        "Alert ID: " + alert.getAlertId()
                );

                break;


            case 2:

                List<Alert> alerts =
                        dao.getAllAlerts();

                if (alerts != null) {

                    for (Alert a : alerts) {

                        System.out.println(
                                "Alert ID: " + a.getAlertId()
                                + " | User ID: " + a.getUserId()
                                + " | Usage: " + a.getCurrentUsage()
                                + " | Type: " + a.getAlertType()
                                + " | Status: " + a.getStatus()
                        );
                    }
                }

                break;


            case 3:

                System.out.print("Enter Alert ID: ");
                int alertId = sc.nextInt();

                Alert foundAlert =
                        dao.getAlertById(alertId);

                if (foundAlert != null) {

                    System.out.println(
                            "Alert ID: "
                            + foundAlert.getAlertId()
                            + " | Type: "
                            + foundAlert.getAlertType()
                            + " | Message: "
                            + foundAlert.getMessage()
                    );

                } else {

                    System.out.println("Alert not found.");
                }

                break;


            case 4:

                Alert updateAlert = new Alert(
                        1,
                        1,
                        400,
                        300,
                        "High Usage",
                        "Very high electricity usage.",
                        new Timestamp(System.currentTimeMillis()),
                        "Read"
                );

                dao.updateAlert(updateAlert);

                break;


            case 5:

                System.out.print("Enter Alert ID to delete: ");
                int deleteAlertId = sc.nextInt();

                dao.deleteAlert(deleteAlertId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }


    // =====================================================
    // ENERGY SUGGESTION CRUD
    // =====================================================

    static void energySuggestionMenu() {

        System.out.println("\n===== ENERGY SUGGESTION CRUD =====");
        System.out.println("1. Create Energy Suggestion");
        System.out.println("2. View All Suggestions");
        System.out.println("3. Find Suggestion By ID");
        System.out.println("4. Update Suggestion");
        System.out.println("5. Delete Suggestion");
        System.out.println("6. Back");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                EnergySuggestion suggestion =
                        new EnergySuggestion(
                                1,
                                "Reduce AC Usage",
                                "Cooling",
                                "AC consumes high electricity.",
                                "Use AC for fewer hours.",
                                50
                        );

                dao.saveEnergySuggestion(suggestion);

                System.out.println(
                        "Suggestion ID: "
                        + suggestion.getSuggestionId()
                );

                break;


            case 2:

                List<EnergySuggestion> suggestions =
                        dao.getAllEnergySuggestions();

                if (suggestions != null) {

                    for (EnergySuggestion s : suggestions) {

                        System.out.println(
                                "ID: " + s.getSuggestionId()
                                + " | User ID: " + s.getUserId()
                                + " | Title: " + s.getTitle()
                                + " | Category: " + s.getCategory()
                                + " | Saving: "
                                + s.getEstimatedSaving()
                        );
                    }
                }

                break;


            case 3:

                System.out.print("Enter Suggestion ID: ");
                int suggestionId = sc.nextInt();

                EnergySuggestion foundSuggestion =
                        dao.getEnergySuggestionById(suggestionId);

                if (foundSuggestion != null) {

                    System.out.println(
                            "ID: "
                            + foundSuggestion.getSuggestionId()
                            + " | Title: "
                            + foundSuggestion.getTitle()
                            + " | Category: "
                            + foundSuggestion.getCategory()
                    );

                } else {

                    System.out.println("Suggestion not found.");
                }

                break;


            case 4:

                EnergySuggestion updateSuggestion =
                        new EnergySuggestion(
                                1,
                                1,
                                "Reduce AC Usage",
                                "Cooling",
                                "AC consumes high electricity.",
                                "Use AC for fewer hours.",
                                75
                        );

                dao.updateEnergySuggestion(updateSuggestion);

                break;


            case 5:

                System.out.print(
                        "Enter Suggestion ID to delete: "
                );

                int deleteSuggestionId = sc.nextInt();

                dao.deleteEnergySuggestion(deleteSuggestionId);

                break;


            case 6:
                break;


            default:
                System.out.println("Invalid choice.");
        }
    }
}