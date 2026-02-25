package com.management.database;

import java.util.List;

import com.management.model.Student;

public interface DatabaseOperation {

    boolean addStudent(Student student);

    List<Student> displayStudent();

    boolean searchUpdateStudent(int id);

    boolean updateStudent(int id, int sem, double cgpa);

    List<Student> searchStudents(int id);

    boolean deleteStudent(int id);
}
