package com.library.entity;

public class Paper extends Document {
    private String date;

    public Paper(String id, String publisher, int quantity, String date){
        super(id, publisher, quantity);
        this.date = date;
    }

    @Override
    public void displayInfo(){
        super.display();

        System.out.println("Ngay phat hanh: " + date);
    }
}
