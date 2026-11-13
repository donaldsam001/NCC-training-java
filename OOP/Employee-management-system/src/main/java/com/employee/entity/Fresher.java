package com.employee.entity;

import com.employee.exception.EmployeeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class Fresher extends Employee {

    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String id, String fullName, LocalDate birthDay, String phone,
                   String email, LocalDate graduationDate,
                   String graduationRank, String education)  throws EmployeeException  {
        super(id, fullName, birthDay, phone, email, FRESHER );
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void showInfo(){
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birthday: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Fresher");

        System.out.println("Date: "+ graduationDate);
        System.out.println("Education: "+ education);
        System.out.println("Rank: " + graduationRank);
        showCertificates();
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
