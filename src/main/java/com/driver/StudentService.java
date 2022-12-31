package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public static void addStudentAtService(Student student) {
        StudentRepository.addStudentToDb(student);
    }
    public static void addTeacherAtService(Teacher teacher) {
        StudentRepository.addTeacherToDb(teacher);
    }
    public static void addStudentTeacherPair(String student, String teacher) {
        StudentRepository.addStudentTeacherPairToDb(student,teacher);
    }
    public static Student getStudentbyName(String name) {
        Student student=StudentRepository.getStudentByNameFromDb(name);
        return student;
    }
    public static Teacher getTeacherbyName(String name) {
        Teacher teacher=StudentRepository.getTeacherByNameFromDb(name);
        return teacher;
    }
    public static List<String> getStudentsByTeacherName(String name) {
        return StudentRepository.getStudentsByTeacherNameFromDb(name);
    }
    public static List<String> getAllStudentsAdded() {
        return StudentRepository.getAllStudentsAddedFromDb();
    }
    public static void deleteTeacherbyName(String teacher) {
        StudentRepository.deleteTeacherByNameFromDb(teacher);
    }
    public static void deleteAllTeachers() {
        StudentRepository.deleteAllTeachersFromDb();
    }
}
