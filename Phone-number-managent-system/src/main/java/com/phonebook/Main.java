package com.phonebook;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        PhoneBook phoneBook = new PhoneBook();

        do {

            System.out.println("\n===== PHONEBOOK MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Display All Contacts");
            System.out.println("7. Add demo data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            String name;
            String phone;

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    phone = scanner.nextLine();

                    phoneBook.insertPhone(name, phone);
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    name = scanner.nextLine();

                    phoneBook.removePhone(name);
                    break;

                case 3:
                    System.out.print("Enter name to update: ");
                    name = scanner.nextLine();

                    System.out.print("Enter new phone number: ");
                    phone = scanner.nextLine();

                    phoneBook.updatePhone(name, phone);
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();

                    phoneBook.searchPhone(name);
                    break;

                case 5:
                    phoneBook.sort();
                    break;

                case 6:
                    phoneBook.displayPhoneList();
                    break;

                case 7:
                    System.out.println("Add demo data.");
                    phoneBook.insertPhone("sam", "0123456");
                    phoneBook.insertPhone("sparrow", "0234567");
                    phoneBook.insertPhone("luffy", "0345678");

                    break;
                case 8:
                    System.out.println("Exiting PhoneBook Management System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);
        scanner.close();
    }

}
