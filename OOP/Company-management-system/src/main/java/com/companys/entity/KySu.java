package com.companys.entity;

public class KySu extends CanBo{

    private String major;

    public KySu(String fullName, int age, String gender, String address, String major ){
        super(fullName, age, gender, address);
        this.major=major;
    }

    @Override
    public void displayInfo() {
        super.display();

        System.out.println("Chuc vu: Ky su");
        System.out.println("Nganh dao tao: " + major);
    }
}
