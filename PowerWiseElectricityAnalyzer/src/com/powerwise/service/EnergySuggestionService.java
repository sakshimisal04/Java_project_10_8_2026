package com.powerwise.service;

import java.util.List;
import java.util.Scanner;

import com.powerwise.model.EnergySuggestion;
import com.powerwise.repository.EnergySuggestionRepository;

public class EnergySuggestionService {

    private EnergySuggestionRepository suggestionRepo;

    public EnergySuggestionService() {
        suggestionRepo =
                new EnergySuggestionRepository();
    }

    public void suggestionMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println(
                    "========== ENERGY SUGGESTION MENU =========="
            );

            System.out.println("1. Add Energy Suggestion");
            System.out.println("2. View Energy Suggestions");
            System.out.println("3. Update Energy Suggestion");
            System.out.println("4. Delete Energy Suggestion");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addSuggestion(sc);
                    break;

                case 2:
                    viewSuggestions();
                    break;

                case 3:
                    updateSuggestion(sc);
                    break;

                case 4:
                    deleteSuggestion(sc);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addSuggestion(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD ENERGY SUGGESTION ---");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Recommended Action: ");
        String action = sc.nextLine();

        System.out.print("Enter Estimated Saving: ");
        double saving = sc.nextDouble();
        sc.nextLine();

        EnergySuggestion suggestion =
                new EnergySuggestion(
                        userId,
                        title,
                        category,
                        description,
                        action,
                        saving
                );

        suggestionRepo.addEnergySuggestion(
                suggestion
        );
    }

    private void viewSuggestions() {

        System.out.println();
        System.out.println("--- ALL ENERGY SUGGESTIONS ---");

        List<EnergySuggestion> suggestions =
                suggestionRepo.getAllEnergySuggestions();

        if (suggestions.isEmpty()) {

            System.out.println(
                    "No energy suggestions found."
            );

        } else {

            for (EnergySuggestion e : suggestions) {

                System.out.println(
                        "Suggestion ID: "
                        + e.getSuggestionId()
                        + " | User ID: "
                        + e.getUserId()
                        + " | Title: "
                        + e.getTitle()
                        + " | Category: "
                        + e.getCategory()
                        + " | Description: "
                        + e.getDescription()
                        + " | Recommended Action: "
                        + e.getRecommendedAction()
                        + " | Estimated Saving: "
                        + e.getEstimatedSaving()
                );
            }
        }
    }

    private void updateSuggestion(Scanner sc) {

        System.out.println();
        System.out.println(
                "--- UPDATE ENERGY SUGGESTION ---"
        );

        System.out.print("Enter Suggestion ID: ");
        int id = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter New Title: ");
        String title = sc.nextLine();

        System.out.print("Enter New Category: ");
        String category = sc.nextLine();

        System.out.print("Enter New Description: ");
        String description = sc.nextLine();

        System.out.print("Enter New Recommended Action: ");
        String action = sc.nextLine();

        System.out.print("Enter New Estimated Saving: ");
        double saving = sc.nextDouble();
        sc.nextLine();

        EnergySuggestion suggestion =
                new EnergySuggestion(
                        id,
                        userId,
                        title,
                        category,
                        description,
                        action,
                        saving
                );

        suggestionRepo.updateEnergySuggestion(
                suggestion
        );
    }

    private void deleteSuggestion(Scanner sc) {

        System.out.println();
        System.out.println(
                "--- DELETE ENERGY SUGGESTION ---"
        );

        System.out.print("Enter Suggestion ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        suggestionRepo.deleteEnergySuggestion(id);
    }
}