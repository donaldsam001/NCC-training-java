package com.library.entity;

public abstract class Document {
    protected String id;
    protected String publisher;
    protected int quantity;

    public Document(String id, String publisher, int quantity){
        this.id = id;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public void display(){
        System.out.println("Ma tai lieu: " + id);
        System.out.println("Nha phat hanh: " + publisher );
        System.out.println("So ban phat hanh: "+ quantity);
    }

    public String getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void displayInfo();
}
