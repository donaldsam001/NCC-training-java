package com.employee.entity;

import com.employee.exception.EmployeeException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String fullName, LocalDate birthDay, String phone,
                      String email,int expInYear, String proSkill)  throws EmployeeException  {
        super(id, fullName, birthDay,phone, email, EXPERIENCE);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo(){
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birthday: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Experience");

        System.out.println("Exp: "+ expInYear);
        System.out.println("Skill: " + proSkill);
        showCertificates();
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
