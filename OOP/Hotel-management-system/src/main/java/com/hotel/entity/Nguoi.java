package com.hotel.entity;

public class Nguoi {
    private String name;
    private int age;
    private String code;

    public Nguoi(String name, int age, String code){
        this.name = name;
        this.age = age;
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public String getName(){
        return name;
    }

}
