package com.news;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageNews {
    private static ArrayList<News> newsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int choice = 0;

        do {
            System.out.println("//============= News management system =============//");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewListNew();
                    break;
                case 3:
                    getAverageRate();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while(choice != 4);

    }

    public static void insertNews(){
        String title;
        String publishDate;
        String author;
        String content;

        News news = new News();
        System.out.print("Enter title: ");
        title = scanner.nextLine();
        news.setTitle(title);

        System.out.print("Enter publish date: ");
        publishDate = scanner.nextLine();
        news.setPublishDate(publishDate);

        System.out.print("Enter author: ");
        author = scanner.nextLine();
        news.setAuthor(author);

        System.out.print("Enter content: ");
        content = scanner.nextLine();
        news.setContent(content);

        for (int i = 0; i < 3; i ++){
            int rate;

            while (true ){
                System.out.println("Enter rating: " + (i + 1) + " (1-10): ");
                try{
                    rate = Integer.parseInt(scanner.nextLine());
                    if (rate >=1 && rate <= 10){
                        break;
                    }

                    System.out.println("Rate must be 1-10");
                } catch (NumberFormatException e){
                    System.out.println("Pls enter integer");
                }
            }

            news.setRateList(i, rate);
        }

        newsList.add(news);
        System.out.println("Added");
    }

    public static void viewListNew(){
        if (newsList.isEmpty()){
            System.out.println("Empty");
            return;
        }
        for (News news : newsList){
            news.display();
        }
    }

    public static void getAverageRate(){
        if (newsList.isEmpty()){
            System.out.println("Empty");
            return;
        }

        for (News news : newsList){
            news.calculate();
            news.display();
        }
    }


}
