package com.managent;

import com.managent.controller.StudentController;
import com.managent.dao.StudentDAOImplementation;
import com.managent.database.StudentDatabase;
import com.managent.view.StudentView;

public class StudentManagementSystem {
    public static void main(String[] args) {
        
        StudentView view = new StudentView();
        StudentDatabase db = new StudentDatabase();
        StudentDAOImplementation dao = new StudentDAOImplementation(db, view);

        StudentController controller = new StudentController(view, dao);

        controller.start();
    }
}