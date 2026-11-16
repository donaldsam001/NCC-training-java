package com.university.entity;

public class AcademicResult {

    private int semester;
    private double GPA;

    // default
    public AcademicResult() {
        this.semester = -1;
        this.GPA = 0.0;
    }

    // parameter
    public AcademicResult(int semester, double GPA) {
        this.semester = semester;
        this.GPA = GPA;
    }

    // copy
    public AcademicResult(AcademicResult other) {
        this.semester = other.semester;
        this.GPA = other.GPA;
    }

    public void display(){
        System.out.println("Semester: " + semester);
        System.out.println("GPA: " + GPA);
    }

//
}
