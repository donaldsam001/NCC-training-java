package com.masks;

public class StudentMark implements IStudentMark{
    private int id;
    private String fullName;
    private String studentClass;
    private int semester;
    private float averageMark;
    private int[] subjectMarkList = new int[5];

    public int getId(){
        return this.id;
    }

    public String getFullName(){
        return this.fullName;
    }

    public String getStudentClass(){
        return this.studentClass;
    }

    public int getSemester(){
        return this.semester;
    }

    public float getAverageMark(){
        return this.averageMark;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStudentClass(String studentClass){
        this.studentClass=studentClass;
    }

    public void setSemester(int semester){
        this.semester = semester;
    }

    @Override
    public void display(){
        System.out.println("Id: " + id);
        System.out.println("Full name: " + fullName);
        System.out.println("Class: "+ studentClass);
        System.out.println("Semester: " + semester);
        System.out.println("Average mark: " + averageMark);
    }

    public void aveCal(){
        int total = 0;
        for (int i=0; i< 5; i++){
            total += subjectMarkList[i];
        }

        this.averageMark = (float) (total/subjectMarkList.length);
    }
}
