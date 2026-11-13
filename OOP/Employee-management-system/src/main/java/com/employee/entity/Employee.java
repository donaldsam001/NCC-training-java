package com.employee.entity;

import com.employee.exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String id;
    protected String fullName;
    protected LocalDate birthDay;
    protected String email;
    protected int type;
    protected static int count = 0;
    protected List<Certification> certs;
    protected String phone;
    public static final int EXPERIENCE = 0;
    public static final int FRESHER = 1;
    public static final int INTERN = 2;

    public Employee(String id, String fullName, LocalDate birthDay, String phone, String email, int type)  throws EmployeeException  {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.certs = new ArrayList<>();
        count ++;
    }

    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws FullNameException {

        if (fullName == null ||
                !fullName.matches("[\\p{L}]+(?:[ '\\-][\\p{L}]+)*")) {

            throw new FullNameException("Invalid full name!");
        }this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) throws BirthDayException {

        if (birthDay == null ||
                birthDay.isAfter(LocalDate.now())) {

            throw new BirthDayException("Invalid birthday!");
        }this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone)throws PhoneException {

        if (phone == null || !phone.matches("^\\+?[0-9]{10,13}$")) {

            throw new PhoneException("Invalid phone number!");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {

        if (email == null ||
                !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            throw new EmailException("Invalid email!");
        }this.email = email;
    }

    public int getEmployeeType() {
        return type;
    }

    public void setEmployeeType(int employeeType) {
        this.type = employeeType;
    }

    public static int getEmployeeCount() {
        return count;
    }

    public List<Certification> getCertificates() {
        return certs;
    }

    public void addCertificate(Certification certificate) {
        certs.add(certificate);
    }

    public void showCertificates() {
        for (Certification certificate : certs) {
            certificate.showInfo();
        }
    }


}
