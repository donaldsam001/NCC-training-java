package com.university.entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Student {
    private int studentCode;
    private String fullName;
    private LocalDate dob;
    private int studentYear;
    private double inputScore;
    private List<AcademicResult> academicResults;

    public Student() {
        this(1, "Unknown", LocalDate.of(2000, 1, 1),
                2020, 0.0, new ArrayList<>());
    }

    public Student(int studentCode, String fullName, LocalDate dob,
                   int studentYear, double inputScore,
                   List<AcademicResult> academicResults) {
        setStudentCode(studentCode);
        setFullName(fullName);
        setDob(dob);
        setStudentYear(studentYear);
        setInputScore(inputScore);
        setAcademicResults(academicResults);
    }

    public Student(Student other) {
        if (other == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        this.studentCode = other.studentCode;
        this.fullName = other.fullName;
        this.dob = other.dob;
        this.studentYear = other.studentYear;
        this.inputScore = other.inputScore;
        setAcademicResults(other.academicResults);
    }

    public abstract boolean isRegular();
    public abstract String getStudentType();
    public abstract Student copy();

    public void input(Scanner scanner) {
        System.out.println("--- Enter student information ---");
        setStudentCode(readInt(scanner, "Student code: ",
                value -> value > 0, "Student code must be positive."));
        setFullName(readNonBlank(scanner, "Full name: "));
        setDob(readDate(scanner, "Date of birth (yyyy-MM-dd): "));
        setStudentYear(readInt(scanner, "Enrollment year: ",
                value -> value >= 1900 && value <= LocalDate.now().getYear(),
                "Enrollment year is invalid."));
        setInputScore(readDouble(scanner, "Entrance score (0-100): ",
                value -> Double.isFinite(value) && value >= 0 && value <= 100,
                "Entrance score must be between 0 and 100."));

        int numberOfSemesters = readInt(scanner, "Number of semesters: ",
                value -> value >= 0, "Number of semesters cannot be negative.");

        List<AcademicResult> results = new ArrayList<>();
        for (int i = 1; i <= numberOfSemesters; i++) {
            final int semester = i;
            double gpa = readDouble(scanner,
                    "GPA for semester " + semester + " (0-10): ",
                    value -> Double.isFinite(value) && value >= 0 && value <= 10,
                    "GPA must be between 0 and 10.");
            results.add(new AcademicResult(semester, gpa));
        }
        setAcademicResults(results);
    }

    public void output() {
        System.out.println("----------------------------------------");
        System.out.println("Student type: " + getStudentType());
        System.out.println("Student code: " + studentCode);
        System.out.println("Full name: " + fullName);
        System.out.println("Date of birth: " + dob);
        System.out.println("Enrollment year: " + studentYear);
        System.out.printf("Entrance score: %.2f%n", inputScore);
        System.out.println("Academic results:");
        if (academicResults.isEmpty()) {
            System.out.println("  No academic results.");
        } else {
            for (AcademicResult result : academicResults) {
                System.out.println("  " + result);
            }
        }
    }

    public double getGpaBySemester(int semester) {
        return academicResults.stream()
                .filter(result -> result.getSemester() == semester)
                .mapToDouble(AcademicResult::getGpa)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No GPA found for semester " + semester));
    }

    private static int readInt(Scanner scanner, String prompt,
                               IntCondition condition, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (!condition.test(value)) {
                    throw new IllegalArgumentException(errorMessage);
                }
                return value;
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt,
                                     DoubleCondition condition, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (!condition.test(value)) {
                    throw new IllegalArgumentException(errorMessage);
                }
                return value;
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        }
    }

    private static String readNonBlank(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private static LocalDate readDate(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                LocalDate date = LocalDate.parse(scanner.nextLine().trim());
                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Date of birth cannot be in the future.");
                    continue;
                }
                return date;
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date. Use yyyy-MM-dd, e.g. 2002-05-20.");
            }
        }
    }

    @FunctionalInterface
    private interface IntCondition {
        boolean test(int value);
    }

    @FunctionalInterface
    private interface DoubleCondition {
        boolean test(double value);
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        if (studentCode <= 0) {
            throw new IllegalArgumentException("Student code must be positive.");
        }
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be empty.");
        }
        this.fullName = fullName.trim();
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        if (dob == null || dob.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth is invalid.");
        }
        this.dob = dob;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        if (studentYear < 1900 || studentYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Enrollment year is invalid.");
        }
        this.studentYear = studentYear;
    }

    public double getInputScore() {
        return inputScore;
    }

    public void setInputScore(double inputScore) {
        if (!Double.isFinite(inputScore) || inputScore < 0 || inputScore > 100) {
            throw new IllegalArgumentException(
                    "Entrance score must be between 0 and 100.");
        }
        this.inputScore = inputScore;
    }

    public List<AcademicResult> getAcademicResults() {
        List<AcademicResult> copy = new ArrayList<>();
        for (AcademicResult result : academicResults) {
            copy.add(new AcademicResult(result));
        }
        return copy;
    }

    public void setAcademicResults(List<AcademicResult> academicResults) {
        this.academicResults = new ArrayList<>();
        if (academicResults == null) {
            return;
        }

        for (AcademicResult result : academicResults) {
            if (result == null) {
                throw new IllegalArgumentException("Academic result cannot be null.");
            }
            this.academicResults.add(new AcademicResult(result));
        }
    }
}