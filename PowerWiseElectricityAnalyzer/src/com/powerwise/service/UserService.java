package com.powerwise.service;

import java.util.List;
import java.util.Scanner;

import com.powerwise.model.User;
import com.powerwise.repository.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService() {
        userRepo = new UserRepository();
    }

    public void userMenu(Scanner sc) {

        while (true) {

            System.out.println();
            System.out.println("========== USER MENU ==========");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addUser(sc);
                    break;

                case 2:
                    viewUsers();
                    break;

                case 3:
                    updateUser(sc);
                    break;

                case 4:
                    deleteUser(sc);
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addUser(Scanner sc) {

        System.out.println();
        System.out.println("--- ADD USER ---");

        System.out.print("Enter User Name: ");
        String userName = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User(
                userName,
                email,
                phone,
                address,
                password
        );

        userRepo.addUser(user);
    }

    private void viewUsers() {

        System.out.println();
        System.out.println("--- ALL USERS ---");

        List<User> users = userRepo.getAllUsers();

        if (users.isEmpty()) {

            System.out.println("No users found.");

        } else {

            for (User u : users) {

                System.out.println(
                        "ID: " + u.getUserId()
                        + " | Name: " + u.getUserName()
                        + " | Email: " + u.getEmail()
                        + " | Phone: " + u.getPhone()
                        + " | Address: " + u.getAddress()
                );
            }
        }
    }

    private void updateUser(Scanner sc) {

        System.out.println();
        System.out.println("--- UPDATE USER ---");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New User Name: ");
        String newName = sc.nextLine();

        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();

        System.out.print("Enter New Phone: ");
        String newPhone = sc.nextLine();

        System.out.print("Enter New Address: ");
        String newAddress = sc.nextLine();

        System.out.print("Enter New Password: ");
        String newPassword = sc.nextLine();

        User updatedUser = new User(
                userId,
                newName,
                newEmail,
                newPhone,
                newAddress,
                newPassword
        );

        userRepo.updateUser(updatedUser);
    }

    private void deleteUser(Scanner sc) {

        System.out.println();
        System.out.println("--- DELETE USER ---");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        userRepo.deleteUser(userId);
    }
}