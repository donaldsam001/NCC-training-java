package com.books;

public class Book implements  IBook{
    private int id;
    private String name;
    private String publishDate;
    private String author;
    private String language;
    private double averagePrice;
    private int[] priceList = new int[5];

    public String getName(){
        return this.name;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public String getPublishDate(){
        return this.publishDate;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getLanguage(){
        return this.language;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPublishDate(String publishDate){
        this.publishDate = publishDate;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Book(int id, String name, String publishDate,
                String author, String language, int[] PriceList) {

        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.language = language;
        this.priceList = PriceList;
    }


    @Override
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Publish date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average price: " + averagePrice);
    }

    public void calculate(){
        int total = 0;
        for (int i : priceList){
            total += i;
        }

        this.averagePrice = total / priceList.length;
    }
}
