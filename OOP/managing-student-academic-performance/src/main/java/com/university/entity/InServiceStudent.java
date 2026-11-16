package com.university.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InServiceStudent extends Student{

    private String trainingPartnershipLocation;

    public InServiceStudent(int studentCode, String fullName, LocalDate dob, int studentYear,
                            double inputScore, List<AcademicResult> academicResults,
                            String trainingPartnershipLocation) {
        super(studentCode, fullName, dob, studentYear, inputScore, academicResults);
        setTrainingPartnershipLocation(trainingPartnershipLocation);
    }

    public InServiceStudent() {
        super();
        this.trainingPartnershipLocation = "Unknow";
    }

    public InServiceStudent(InServiceStudent other) {
        super(other);
        this.trainingPartnershipLocation = other.trainingPartnershipLocation;
    }

    @Override
    public void input(Scanner scanner){
        System.out.println("In service student");
        super.input(scanner);

        System.out.print("Training Partnership Location");
        String location = scanner.nextLine();

        setTrainingPartnershipLocation(location);
    }

    @Override
    public void output(){
        System.out.println("In service student");
        super.output();

        System.out.println("Training Partnership Location: "+ trainingPartnershipLocation);
    }


    @Override
    public boolean isRegular(){
        return false;
    }

    @Override
    public String getStudentType() {
        return "In service";
    }

    @Override
    public Student copy() {
        return new InServiceStudent(this);
    }

    public String getTrainingPartnershipLocation() {
        return trainingPartnershipLocation;
    }

    public void setTrainingPartnershipLocation(String trainingPartnershipLocation) {
        if (trainingPartnershipLocation == null || trainingPartnershipLocation.isBlank()){
            throw new IllegalArgumentException("Training location cannot be empty.");
        }
        this.trainingPartnershipLocation = trainingPartnershipLocation;
    }
}
