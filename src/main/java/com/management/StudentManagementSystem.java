package com.management;

import com.management.controller.StudentController;
import com.management.dao.StudentDAOImplementation;
import com.management.database.StudentDatabase;
import com.management.view.StudentView;

public class StudentManagementSystem {
    public static void main(String[] args) {
        
        StudentView view = new StudentView();
        StudentDatabase db = new StudentDatabase();
        StudentDAOImplementation dao = new StudentDAOImplementation(db, view);

        StudentController controller = new StudentController(view, dao);

        controller.start();
    }
}