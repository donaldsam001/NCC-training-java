package com.hotel.entity;

import java.util.ArrayList;
import java.util.List;

public class KhachSan {

    public static class KhachThue {
        private final String type;
        private final Nguoi nguoi;
        private final int date;

        public KhachThue(Nguoi nguoi, int date, String type) {
            this.nguoi = nguoi;
            this.date = date;
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public Nguoi getNguoi() {
            return nguoi;
        }

        public int getDate() {
            return date;
        }

        public void display() {
            System.out.println("Name: " + nguoi.getName());
            System.out.println("Code: " + nguoi.getCode());
            System.out.println("Room type: " + type);
            System.out.println("Rental days: " + date);
            System.out.println("--------------------------");
        }
    }

    private final List<KhachThue> customerList = new ArrayList<>();

    private KhachThue findCustomer(String code) {
        if (code == null) {
            return null;
        }

        for (KhachThue customer : customerList) {
            if (customer.nguoi.getCode().equalsIgnoreCase(code)) {
                return customer;
            }
        }

        return null;
    }

    public void addCustomer(Nguoi nguoi, int date, String type) {

        if (nguoi == null || nguoi.getCode() == null) {
            System.out.println("Invalid customer information");
            return;
        }

        if (date <= 0) {
            System.out.println("Invalid rental days");
            return;
        }

        if (type == null) {
            System.out.println("Invalid room type");
            return;
        }

        type = type.trim().toUpperCase();

        if (!type.equals("A") && !type.equals("B") && !type.equals("C")) {
            System.out.println("Room type must be A, B or C");
            return;
        }

        if (findCustomer(nguoi.getCode()) != null) {
            System.out.println("Customer already exists");
            return;
        }

        customerList.add(new KhachThue(nguoi, date, type));

        System.out.println("Customer added successfully");
    }

    public void removeCustomer(String code) {

        if (customerList.isEmpty()) {
            System.out.println("Customer list is empty");
            return;
        }

        KhachThue customer = findCustomer(code);

        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        customerList.remove(customer);

        System.out.println("Customer removed successfully");
    }

    public void calculate(String code) {

        KhachThue customer = findCustomer(code);

        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        int price = getRoomPrice(customer.getType());

        double amount = customer.getDate() * price;

        System.out.println("\n========== RENTAL BILL ==========");
        System.out.println("Customer: " + customer.getNguoi().getName());
        System.out.println("Identification code: " + customer.getNguoi().getCode());
        System.out.println("Room type: " + customer.getType());
        System.out.println("Rental days: " + customer.getDate());
        System.out.println("Price per day: " + price + "$");
        System.out.println("Total amount: " + amount + "$");
        System.out.println("=================================");
    }


    private int getRoomPrice(String type) {

        switch (type) {
            case "A":
                return 500;

            case "B":
                return 300;

            case "C":
                return 100;

            default:
                throw new IllegalArgumentException("Invalid room type");
        }
    }


    public void getList() {

        if (customerList.isEmpty()) {
            System.out.println("Customer list is empty");
            return;
        }

        System.out.println("\n========== CUSTOMER LIST ==========");

        for (KhachThue customer : customerList) {
            customer.display();
        }
    }
}