package com.university.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public abstract class Student {
    protected int studentCode;
    protected String fullName;
    protected LocalDate dob;
    protected int studentYear;
    protected double inputScore;
    protected List<AcademicResult> academicResults;

    public Student(int studentCode, String fullName, LocalDate dob, int studentYear, double inputScore, List<AcademicResult> academicResults) {
        setStudentCode(studentCode);
        setFullName(fullName);
        setDob(dob);
        setStudentYear(studentYear);
        setInputScore(inputScore);
        setAcademicResults(academicResults);
    }

    public Student() {
        this.studentCode = 0;
        this.fullName = "Unknow";
        this.dob = null;
        this.studentYear = 0;
        this.inputScore = 0.0;
        this.academicResults = null;
    }

    public Student(Student other) {
        this.studentCode = other.studentCode;
        this.fullName = other.fullName;
        this.dob = other.dob;
        this.studentYear = other.studentYear;
        this.inputScore = other.inputScore;
        this.academicResults = other.academicResults;
    }


    public abstract boolean isRegular();

    public abstract String getStudentType();

    public abstract Student copy();

//    public abstract void input(Scanner scanner);

    public void input(Scanner scanner) {
        System.out.print("Student code: ");
        int code = Integer.parseInt(scanner.nextLine());

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Dob (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse((scanner.nextLine()));

        System.out.print("Enrollment year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Input score: ");
        double score = Double.parseDouble(scanner.nextLine());



        try {
            setStudentCode(code);
            setFullName(fullName);
            setDob(dob);
            setStudentYear(year);
            setInputScore(score);

            System.out.print("Semester: ");
            int semester = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i< semester; i++ ){
                System.out.println("Semester: " + (i+1));
                System.out.print("Score: ");
                double scoreOfSemester = Double.parseDouble(scanner.nextLine());
                academicResults.add(new AcademicResult(i+1, scoreOfSemester));
            }

            setAcademicResults(academicResults);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void output(){
        System.out.println();System.out.print("Student code: "+ studentCode);

        System.out.print("Full name: " + fullName);

        System.out.print("Dob (YYYY-MM-DD): "+ dob);

        System.out.print("Enrollment year: " + studentYear);

        System.out.print("Input score: " + inputScore);

        for (AcademicResult semester: academicResults){
            semester.display();
        }

    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {

        if (studentCode <= 0) {
            throw new IllegalArgumentException("Student code must be positive");
        }
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException(
                    "Full name cannot be empty."
            );
        }

        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        if (dob == null || dob.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Invalid date of birth."
            );
        }

        this.dob = dob;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        if (studentYear <= 2000 || studentYear > LocalDate.now().getYear()){
            throw new IllegalArgumentException("Invalid enrollment year");
        }
        this.studentYear = studentYear;
    }

    public double getInputScore() {
        return inputScore;
    }

    public void setInputScore(double inputScore) {
        if (inputScore < 0 || inputScore > 100 || !Double.isFinite(inputScore)){
            throw new IllegalArgumentException("score: 0 - 100");
        }
        this.inputScore = inputScore;
    }

    public List<AcademicResult> getAcademicResults() {
        return academicResults;
    }

    public void setAcademicResults(List<AcademicResult> academicResults) {
        this.academicResults = academicResults;
    }
}
