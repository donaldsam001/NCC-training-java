package com.companys.entity;

public abstract class CanBo {
    protected String fullName;
    protected int age;
    protected String gender;
    protected String address;

    public CanBo(){}

    public CanBo(String fullName, int age, String gender, String address) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getFullName(){
        return this.fullName;
    }

    public void display(){
        System.out.println("Ho ten: " + fullName);
        System.out.println("Tuoi: " + age );
        System.out.println("Gioi tinh: "+ gender);
        System.out.println("Dia chi: " + address);
    }

    public abstract void displayInfo();

}
