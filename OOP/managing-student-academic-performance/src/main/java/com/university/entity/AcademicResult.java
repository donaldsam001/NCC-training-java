package com.university.entity;

public class AcademicResult {
    private int semester;
    private double gpa;

    public AcademicResult() {
        this(1, 0.0);
    }

    public AcademicResult(int semester, double gpa) {
        setSemester(semester);
        setGpa(gpa);
    }

    public AcademicResult(AcademicResult other) {
        if (other == null) {
            throw new IllegalArgumentException("AcademicResult cannot be null.");
        }
        this.semester = other.semester;
        this.gpa = other.gpa;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester <= 0) {
            throw new IllegalArgumentException("Semester must be greater than 0.");
        }
        this.semester = semester;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (!Double.isFinite(gpa) || gpa < 0 || gpa > 10) {
            throw new IllegalArgumentException("GPA must be between 0 and 10.");
        }
        this.gpa = gpa;
    }

    public void display() {
        System.out.printf("Semester: %d | GPA: %.2f%n", semester, gpa);
    }

    @Override
    public String toString() {
        return String.format("Semester %d: %.2f", semester, gpa);
    }
}