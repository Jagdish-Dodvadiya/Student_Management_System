package com.management.controller;

import com.management.dao.StudentDAOImplementation;
import com.management.view.StudentView;

public class StudentController {

    private final StudentView view;
    private final StudentDAOImplementation dao;

    public StudentController(StudentView view, StudentDAOImplementation dao) {
        this.view = view;
        this.dao = dao;
    }

    public void start() {
        int choice;
        do {
            choice = view.showMenu();
            switch (choice) {
                case 1 -> dao.addStudent();
                case 2 -> dao.displayStudent();
                case 3 -> dao.updateStudent();
                case 4 -> dao.searchStudents();
                case 5 -> dao.deleteStudent();
                case 6 -> view.showMessage("Exitting from the System");
                default -> view.showMessage("Invalid choice !");
            }
        } while (choice != 6);
    }
}
