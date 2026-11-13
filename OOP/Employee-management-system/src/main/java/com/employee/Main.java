package com.employee;


import com.employee.entity.Experience;
import com.employee.entity.Fresher;
import com.employee.entity.Intern;
import com.employee.exception.EmployeeException;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

            try {
            Experience experience = new Experience(
                    "E01",
                    "Nguyen Van A",
                    LocalDate.of(1998, 5, 10),
                    "0987654321",
                    "a@gmail.com",
                    5,
                    "Java"
            );

            employeeManager.addEmployee(experience);

            Fresher fresher = new Fresher(
                    "E02",
                    "Tran Van B",
                    LocalDate.of(2002, 8, 15),
                    "0912345678",
                    "b@gmail.com",
                    LocalDate.of(2025, 6, 10),
                    "Excellent",
                    "HUST"
            );

            employeeManager.addEmployee(fresher);

            Intern intern = new Intern(
                    "E03",
                    "Le Van C",
                    LocalDate.of(2004, 3, 20),
                    "0901234567",
                    "c@gmail.com",
                    "ABC University",
                    "Information Technology",
                    6
            );

            employeeManager.addEmployee(intern);

            System.out.println("Employees created successfully!");

        } catch (EmployeeException e) {

            System.out.println("Create employee failed: " + e.getMessage());
        }

        // 2. DISPLAY EMPLOYEES

        System.out.println("\n===== ALL EMPLOYEES =====");
        employeeManager.getListOfEmployee();

        // 3. UPDATE INTERN

        try {
            employeeManager.updateInternInfor(
                    "E03",
                    "Le Van D",
                    LocalDate.of(2003, 5, 15),
                    "0912345678",
                    "invalid-email",
                    "HUST",
                    "Software Engineering",
                    7
            );

            System.out.println("Update successfully!");

        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n===== AFTER UPDATE =====");
        employeeManager.getListOfEmployee();

    }

}