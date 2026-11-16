package com.university.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String facultyName;
    private List<Student> students = new ArrayList<>();

    public Faculty(String facultyName, List<Student> students) {
        this.facultyName = facultyName;
        this.students = students;
    }

    public Faculty() {
        this.facultyName = "Unknow";
        this.students = null;
    }

    public Faculty(Faculty other) {
        this.facultyName = other.facultyName;
        this.students = other.students;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
