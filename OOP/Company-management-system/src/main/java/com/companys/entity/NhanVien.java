package com.companys.entity;

public class NhanVien extends CanBo {
    private String task;

    public NhanVien(String fullName, int age, String gender, String address, String task) {
        super(fullName, age, gender, address);
        this.task = task;
    }

    @Override
    public void displayInfo() {
        super.display();

        System.out.println("Chuc vu: Nhan vien");
        System.out.println("Cong viec: " + task);
    }
}
