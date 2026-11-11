package com.companys.entity;

public class CongNhan extends CanBo{
    private int level;
    public CongNhan(String fullName, int age, String gender, String address, int level ){
        super(fullName, age, gender, address);
        this.level=level;
    }

    @Override
    public void displayInfo() {
        super.display();

        System.out.println("Chuc vu: Cong nhan");
        System.out.println("Bac: " + level);
    }
}
