package com.collection;

import java.util.*;

public class Bai2 {
    private static final int STUDENT_COUNT = 10000;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final Random random = new Random();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args){
        students = generateStudent();
        List<String> ids = new ArrayList<>();

        for (int i=0; i< STUDENT_COUNT; i++){
            String id = students.get(i).getStudentCode();
            ids.add(id);
        }
        List<Student> result = getListOfStudent(ids);

        for(Student student: result){
            student.display();
        }
    }

    public static String generateStudentCode(){
        StringBuilder code = new StringBuilder();

        for (int i=0; i<16; i++){
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }

        return code.toString();
    }

    public static List<Student> generateStudent(){
        List<Student> listStudents = new ArrayList<>();

        for (int i=0; i<STUDENT_COUNT; i++){
            String studentCode = generateStudentCode();
            String name = "Student " + i;
            Student student = new Student(studentCode, name);
            listStudents.add(student);
        }

        return listStudents;
    }

    public static List<Student> getListOfStudent(List<String> ids){
        List<Student> result = new ArrayList<>();
        Map<String, Student> listStudent = new HashMap<>();

        for (Student student : students){
            listStudent.put(student.getStudentCode(), student);
        }

        for (String id: ids){
            Student student = listStudent.get(id);

            if (student != null){
                result.add(student);
            }
        }

        return result;
    }
}
