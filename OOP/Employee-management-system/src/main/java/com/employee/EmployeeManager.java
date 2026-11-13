package com.employee;

import com.employee.entity.Employee;
import com.employee.entity.Experience;
import com.employee.entity.Fresher;
import com.employee.entity.Intern;
import com.employee.exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeManager(){
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if (findById(employee.getId()) != null) {
            System.out.println("Employee ID existed");
            return;
        }

        employees.add(employee);
        System.out.println("Added");
    }

    public void getAllIntern(){
        for (Employee employee: employees){
            if (employee instanceof Intern){
                Intern intern = (Intern) employee;
                intern.showInfo();
            }
        }
    }

    public void getAllFresher(){
        for (Employee employee: employees){
            if (employee instanceof Fresher){
                Fresher fresher = (Fresher) employee;
                fresher.showInfo();
            }
        }
    }

    public void getAllExperience(){
        for (Employee employee: employees){
            if (employee instanceof Experience){
                Experience experience = (Experience) employee;
                experience.showInfo();
            }
        }
    }

    public Employee findById(String id){
        if (employees.isEmpty()){
            System.out.println("Empty");

        }

        for (Employee employee: employees){
            if (employee.getId().equalsIgnoreCase(id)){
                return employee;
            }
        }

        return null;
    }

    public void getListOfEmployee(){
        if (employees.isEmpty()){
            System.out.println("Empty");
        }

        for (Employee employee: employees){
            employee.showInfo();
        }
    }

    public void deleteEmployee(String id){
        Employee employee = findById(id);

        if (employee!= null){
            System.out.println("Not found");
            return;
        }

        employees.remove(employee);

        System.out.println("Removed");
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void updateInternInfor(String id, String fullName, LocalDate birthDay, String phone,
                                  String email, String university, String major, int semester)
    {
        Employee employee = findById(id);
        if (employee == null){
            System.out.println("Not found");
            return;
        }

        if (!(employee instanceof Intern)){
            System.out.println("This employee is not Intern");
        }

        try {
            Intern intern = (Intern) employee;

            intern.setFullName(fullName);
            intern.setBirthDay(birthDay);
            intern.setPhone(phone);
            intern.setEmail(email);

            intern.setUniversity(university);
            intern.setMajor(major);
            intern.setSemester(semester);

            System.out.println("Updated");
        } catch (EmailException | BirthDayException | PhoneException | FullNameException e) {
            System.out.println("Fail: "+e.getMessage());
        }

    }

    public void updateFresherInfor(String id, String fullName, LocalDate birthDay, String phone,
                                  String email, LocalDate graduationDate,
                                   String graduationRank, String education){
        Employee employee = findById(id);
        if (employee == null){
            System.out.println("Not found");
            return;
        }

        if (!(employee instanceof Fresher)){
            System.out.println("This employee is not Fresher");
        }

        try {
            Fresher fresher = (Fresher) employee;
            fresher.setFullName(fullName);
            fresher.setBirthDay(birthDay);
            fresher.setPhone(phone);
            fresher.setEmail(email);

            fresher.setGraduationDate(graduationDate);
            fresher.setGraduationRank(graduationRank);
            fresher.setEducation(education);

            System.out.println("Updated");
        }  catch (EmailException | BirthDayException | PhoneException | FullNameException e) {
            System.out.println("Fail: "+e.getMessage());
        }

    }

    public void updateExperienceInfor(String id, String fullName, LocalDate birthDay, String phone,
                                  String email, int expInYear, String proSkill){
        Employee employee = findById(id);
        if (employee == null){
            System.out.println("Not found");
            return;
        }

        if (!(employee instanceof Experience)){
            System.out.println("This employee is not Intern");
        }
        try {
            Experience experience = (Experience) employee;
            experience.setFullName(fullName);
            experience.setBirthDay(birthDay);
            experience.setPhone(phone);
            experience.setEmail(email);

            experience.setExpInYear(expInYear);
            experience.setProSkill(proSkill);

            System.out.println("Updated");
        } catch (EmailException | BirthDayException | PhoneException | FullNameException e) {
            System.out.println("Fail: "+e.getMessage());
        }

    }

}
