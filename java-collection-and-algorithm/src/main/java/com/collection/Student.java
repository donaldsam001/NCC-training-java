package com.collection;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentCode;
    private String name;

    public String getStudentCode(){
        return this.studentCode;
    }

    public String getName(){
        return this.name;
    }

    public Student(String studentCode, String name){
        this.studentCode = studentCode;
        this.name = name;
    }

    public void display(){
        System.out.println("Student code: " + studentCode + " name:" + name);

    }
}
