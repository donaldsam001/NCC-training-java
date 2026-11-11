package com.library;

import com.library.entity.Book;
import com.library.entity.Document;
import com.library.entity.Magazine;
import com.library.entity.Paper;

import javax.print.attribute.standard.DocumentName;
import java.util.*;

public class QuanLySach {

    private static final Scanner scanner = new Scanner(System.in);

    private static List<Document> documents = new ArrayList<>();


    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add Newspaper");
            System.out.println("4. Remove Document");
            System.out.println("5. Display Documents");
            System.out.println("6. Search By Type");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    String bookId = sc.nextLine();

                    System.out.print("Publisher: ");
                    String bookPublisher = sc.nextLine();

                    System.out.print("Quantity: ");
                    int bookQuantity = Integer.parseInt(sc.nextLine());

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Pages: ");
                    int pages = Integer.parseInt(sc.nextLine());

                    addDocument(
                            new Book(bookId, bookPublisher,
                                    bookQuantity, author, pages)
                    );
                    break;

                case 2:
                    System.out.print("ID: ");
                    String magazineId = sc.nextLine();

                    System.out.print("Publisher: ");
                    String magazinePublisher = sc.nextLine();

                    System.out.print("Quantity: ");
                    int magazineQuantity = Integer.parseInt(sc.nextLine());

                    System.out.print("Issue Number: ");
                    String issueNumber = sc.nextLine();

                    System.out.print("Issue Month: ");
                    String issueMonth = sc.nextLine();

                    addDocument(
                            new Magazine(magazineId, magazinePublisher,
                                    magazineQuantity, issueNumber, issueMonth)
                    );
                    break;

                case 3:
                    System.out.print("ID: ");
                    String newspaperId = sc.nextLine();

                    System.out.print("Publisher: ");
                    String newspaperPublisher = sc.nextLine();

                    System.out.print("Quantity: ");
                    int newspaperQuantity = Integer.parseInt(sc.nextLine());

                    System.out.print("Publish Date: ");
                    String publishDate = sc.nextLine();

                    addDocument(
                            new Paper(newspaperId, newspaperPublisher,
                                    newspaperQuantity, publishDate)
                    );
                    break;

                case 4:
                    System.out.print("Enter document ID: ");
                    String id = sc.nextLine();

                    removeDocument(id);
                    break;

                case 5:
                    displayDoc();
                    break;

                case 6:
                    System.out.print("Enter type (Book/Magazine/Newspaper): ");
                    String type = sc.nextLine();

                    searchByType(type);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void addDocument(Document document){
        for (Document doc: documents){
            if (doc.getId().equalsIgnoreCase(document.getId())){
                System.out.println("Document exist");
                return;
            }
        }

        documents.add(document);
        System.out.println("Added");
    }

    public static void removeDocument(String documentId){
        if(documents.isEmpty()){
            System.out.println("Empty");
            return;
        }

        boolean removed = false;
        for (Document doc: documents){
            if (doc.getId().equalsIgnoreCase(documentId)){
                documents.remove(doc);
                System.out.println("Removed");
                removed = true;
            }
        }

        if (removed == false){
            System.out.println("Not found");
        }
    }

    public static void displayDoc(){
        if(documents.isEmpty()){
            System.out.println("Empty");
            return;
        }

        for(Document doc: documents){
            doc.displayInfo();
        }
    }

    public static void searchByType(String type){
        boolean found = false;

        for(Document doc: documents){
            if (type.equalsIgnoreCase("Book") && doc instanceof Book){
                doc.displayInfo();
                found = true;
            }

            else if(type.equalsIgnoreCase("Manazine") && doc instanceof Magazine){
                doc.displayInfo();
                found = true;
            }
            else if(type.equalsIgnoreCase("Paper") && doc instanceof Paper){
                doc.displayInfo();
                found = true;
            }
        }

        if (!found){
            System.out.println("Not found");
        }
    }

}
