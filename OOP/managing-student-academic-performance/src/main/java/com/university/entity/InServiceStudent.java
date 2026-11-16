package com.university.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InServiceStudent extends Student {
    private String trainingPartnershipLocation;

    public InServiceStudent() {
        super();
        this.trainingPartnershipLocation = "Unknown";
    }

    public InServiceStudent(int studentCode, String fullName, LocalDate dob,
                            int studentYear, double inputScore,
                            List<AcademicResult> academicResults,
                            String trainingPartnershipLocation) {
        super(studentCode, fullName, dob, studentYear, inputScore, academicResults);
        setTrainingPartnershipLocation(trainingPartnershipLocation);
    }

    public InServiceStudent(InServiceStudent other) {
        super(other);
        this.trainingPartnershipLocation = other.trainingPartnershipLocation;
    }

    @Override
    public boolean isRegular() {
        return false;
    }

    @Override
    public String getStudentType() {
        return "In-service";
    }

    @Override
    public Student copy() {
        return new InServiceStudent(this);
    }

    @Override
    public void input(Scanner scanner) {
        System.out.println("=== IN-SERVICE STUDENT ===");
        super.input(scanner);

        while (true) {
            System.out.print("Training partnership location: ");
            String location = scanner.nextLine().trim();
            try {
                setTrainingPartnershipLocation(location);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        }
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Training partnership location: "
                + trainingPartnershipLocation);
    }

    public String getTrainingPartnershipLocation() {
        return trainingPartnershipLocation;
    }

    public void setTrainingPartnershipLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException(
                    "Training partnership location cannot be empty.");
        }
        this.trainingPartnershipLocation = location.trim();
    }
}