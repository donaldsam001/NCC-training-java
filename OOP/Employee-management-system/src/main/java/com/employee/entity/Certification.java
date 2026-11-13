package com.employee.entity;

import java.time.LocalDate;

public class Certification {
    private String id;
    private String name;
    private String rank;
    private LocalDate date;

    public Certification(
            String certificatedID,
            String certificateName,
            String certificateRank,
            LocalDate certificatedDate
    ) {
        this.id = certificatedID;
        this.name = certificateName;
        this.rank = certificateRank;
        this.date = certificatedDate;
    }

    public void showInfo() {
        System.out.println("Certificate ID: " + id);
        System.out.println("Certificate Name: " + name);
        System.out.println("Certificate Rank: " + rank);
        System.out.println("Certificate Date: " + date);
    }

    public String getCertificatedID() {
        return id;
    }

    public void setCertificatedID(String certificatedID) {
        this.id = certificatedID;
    }

    public String getCertificateName() {
        return name;
    }

    public void setCertificateName(String certificateName) {
        this.name = certificateName;
    }

    public String getCertificateRank() {
        return rank;
    }

    public void setCertificateRank(String certificateRank) {
        this.rank = certificateRank;
    }

    public LocalDate getCertificatedDate() {
        return date;
    }

    public void setCertificatedDate(LocalDate certificatedDate) {
        this.date = certificatedDate;
    }
}
