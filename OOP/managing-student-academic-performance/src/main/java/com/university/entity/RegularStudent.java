package com.university.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RegularStudent extends Student {

    public RegularStudent() {
        super();
    }

    public RegularStudent(int studentCode, String fullName, LocalDate dob,
                          int studentYear, double inputScore,
                          List<AcademicResult> academicResults) {
        super(studentCode, fullName, dob, studentYear, inputScore, academicResults);
    }

    public RegularStudent(RegularStudent other) {
        super(other);
    }

    @Override
    public boolean isRegular() {
        return true;
    }

    @Override
    public String getStudentType() {
        return "Regular";
    }

    @Override
    public Student copy() {
        return new RegularStudent(this);
    }

    @Override
    public void input(Scanner scanner) {
        System.out.println("=== REGULAR STUDENT ===");
        super.input(scanner);
    }
}