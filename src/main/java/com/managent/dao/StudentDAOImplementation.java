package com.managent.dao;

import java.util.InputMismatchException;
import java.util.List;

import com.managent.database.StudentDatabase;
import com.managent.model.Student;
import com.managent.view.StudentView;

public class StudentDAOImplementation implements StudentDAO {

    private final StudentDatabase database;
    private final StudentView view;

    public StudentDAOImplementation(StudentDatabase database, StudentView view) {
        this.database = database;
        this.view = view;
    }

    @Override
    public void addStudent() {
        try {
            int id = view.getInt("Enter the ID : ");
            String name = view.getString("Enter the Name : ");
            String email = view.getString("Enter the Email : ");
            String dept = view.getString("Enter the Department : ");
            int sem = view.getInt("Enter the Semester : ");
            double cgpa = view.getDouble("Enter the CGPA : ");
            Student student = new Student(id, name, email, dept, sem, cgpa);
            if (database.addStudent(student)) {
                view.showMessage("Student added successfully.");
            }
        } catch (InputMismatchException e) {
            view.showMessage("you entered invalid input !");
        }
    }

    @Override
    public void displayStudent() {
        List<Student> list = database.displayStudent();
        if (!list.isEmpty()) {
            System.out.println("\n..........All Students..........");
            for (Student student : list) {
                System.out.printf("ID : %d | Name : %s | Email : %s | Department %s | Semester : %d | CGPA : %2f\n",
                        student.getId(), student.getName(), student.getEmail(), student.getDept(), student.getSem(), student.getCgpa());
            }
        } else {
            view.showMessage("Student Records are Empty !");
        }
    }

    @Override
    public void updateStudent() {
        try {
            int id = view.getInt("Enter the Id for update student : ");
            if (database.searchUpdateStudent(id)) {
                int sem = view.getInt("Enter the new Sem : ");
                double cgpa = view.getDouble("Enter the CGPA : ");

                if (database.updateStudent(id, sem, cgpa)) {
                    view.showMessage("Student updated successfully.");
                } else {
                    view.showMessage("Student not found !");
                }
            } else {
                view.showMessage("Student doesn't exist !");
            }
        } catch (InputMismatchException e) {
            view.showMessage("you entered invalid input !");
        }
    }

    @Override
    public void searchStudents() {
        try {
            int id = view.getInt("Enter the ID for search student : ");
            List<Student> list = database.searchStudents(id);
            if (!list.isEmpty()) {
                System.out.println("\n..........Search Students..........");
                for (Student student : list) {
                    System.out.printf("ID : %d | Name : %s | Email : %s | Department %s | Semester : %d | CGPA : %2f\n",
                            student.getId(), student.getName(), student.getEmail(), student.getDept(), student.getSem(), student.getCgpa());
                }
            } else {
                view.showMessage("Student not found !");
            }
        } catch (InputMismatchException e) {
            view.showMessage("you entered invalid input !");
        }
    }

    @Override
    public void deleteStudent() {
        try {
            int id = view.getInt("Enter the Id for delete student : ");
            if (database.deleteStudent(id)) {
                view.showMessage("Student deleted successfully.");
            } else {
                view.showMessage("Student not found !");
            }
        } catch (InputMismatchException e) {
            view.showMessage("you entered invalid input !");
        }
    }
}
