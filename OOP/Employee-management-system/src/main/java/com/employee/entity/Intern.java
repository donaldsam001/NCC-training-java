package com.employee.entity;

import com.employee.exception.EmployeeException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Intern extends Employee{
    private String university;
    private int semester;
    private String major;

    public Intern(String id, String fullName, LocalDate birthDay, String phone,
                  String email, String university, String major, int semester) throws EmployeeException {
        super(id, fullName, birthDay, phone, email, INTERN);
        this.university = university;
        this.semester = semester;
        this.major = major;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birthday: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());

        System.out.println("Employee Type: Intern");
        System.out.println("University: "+ university);
        System.out.println("Major: " + major);
        System.out.println("Semester: " + semester);
        showCertificates();
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public int getSemester() {
        return semester;
    }

    public String getMajor() {
        return major;
    }
}
