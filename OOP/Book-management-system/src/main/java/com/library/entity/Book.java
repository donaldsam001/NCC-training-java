package com.library.entity;

public class Book extends Document {
    private String author;
    private int pageNumber;

    public Book(String id, String publisher, int quantity ,String author, int pageNumber){
        super(id, publisher, quantity);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    @Override
    public void displayInfo(){
        super.display();

        System.out.println("Tac gia: " + author);
        System.out.println("So trang: " + pageNumber);
    }
}
