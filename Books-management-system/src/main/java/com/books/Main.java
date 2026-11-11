package com.books;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int id = 0;
    static ArrayList<Book> bookList = new ArrayList<>();
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("//=================== BOOK MANAGEMENT SYSTEM ===================//");
            System.out.println("1. Insert new book");
            System.out.println("2. View list of books");
            System.out.println("3. Average Price");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    insertBook();
                    break;
                case 2:
                    getListOfBook();
                    break;
                case 3:
                    getAveragePrice();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Pls try again");
            }
        } while (choice != 4);
    }

    public static void insertBook(){
        Scanner scanner = new Scanner(System.in);

        String name;
        String publishDate;
        String author;
        String language;

        System.out.println("\n--- Insert New Book ---");

        System.out.print("Enter book name: ");
        name = scanner.nextLine();

        System.out.print("Enter publish date: ");
        publishDate = scanner.nextLine();

        System.out.print("Enter author: ");
        author = scanner.nextLine();

        System.out.print("Enter language: ");
        language = scanner.nextLine();

        int[] priceList = new int[5];
        for (int i =0; i< 5; i++){
            System.out.print("Enter price: " + (i+1)+ ": ");
            priceList[i] = Integer.parseInt(scanner.nextLine());
        }
        Book book = new Book(id, name, publishDate, author, language, priceList);
        bookList.add(book);
        id++;
        System.out.println("Added");
    }

    public static void getListOfBook(){
        if(bookList.isEmpty()){
            System.out.println("Empty");
            return;
        }
        for (Book book: bookList){
            book.display();
        }
    }

    public static void getAveragePrice(){
        if(bookList.isEmpty()){
            System.out.println("Empty");
            return;
        }

        for(Book book:bookList){
            book.calculate();
            book.display();
        }
    }
}
