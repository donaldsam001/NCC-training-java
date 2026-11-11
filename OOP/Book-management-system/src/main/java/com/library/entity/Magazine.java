package com.library.entity;

public class Magazine extends Document {
    private String publishNumber;
    private String month;

    public Magazine(String id, String publisher, int quantity ,String publishNumber, String month){
        super(id, publisher, quantity);
        this.publishNumber = publishNumber;
        this.month = month;
    }

    @Override
    public void displayInfo(){
        super.display();

        System.out.println("So phat hanh: " + publishNumber);
        System.out.println("Thang phat hanh: " + month);
    }
}
