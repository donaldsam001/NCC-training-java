package com.university.service;

import com.university.entity.Faculty;
import com.university.entity.InServiceStudent;
import com.university.entity.Student;

import java.util.List;
import java.util.Map;

public class StudentService {

    public long countRegularStudents(Faculty faculty) {
        return faculty.countRegularStudents();
    }

    public List<Student> findHighestEntranceScoreStudents(Faculty faculty) {
        return faculty.findStudentsWithHighestEntranceScore();
    }

    public List<InServiceStudent> findInServiceStudentsByLocation(
            Faculty faculty, String location) {
        return faculty.findInServiceStudentsByLocation(location);
    }

    public List<Student> findStudentsWithLatestGpaAtLeast(
            Faculty faculty, double threshold) {
        return faculty.findStudentsWithLatestGpaAtLeast(threshold);
    }

    public List<Student> findStudentsWithHighestSemesterGpa(Faculty faculty) {
        return faculty.findStudentsWithHighestSemesterGpa();
    }

    public List<Student> sortStudents(Faculty faculty) {
        return faculty.getStudentsSortedByTypeThenEnrollmentYear();
    }

    public Map<Integer, Long> countByEnrollmentYear(Faculty faculty) {
        return faculty.countStudentsByEnrollmentYear();
    }
}