package com.management.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentView {

    private final Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n..........Student Management System..........");
        System.out.println("1.add new student");
        System.out.println("2.display all student");
        System.out.println("3.update student");
        System.out.println("4.search student");
        System.out.println("5.delete student");
        System.out.println("6.exit from system");
        System.out.print("enter your choice : ");
        int temp;
        try {
            temp = scanner.nextInt();
            scanner.nextLine();  
            return temp;
        } catch (InputMismatchException e) {
           scanner.nextLine();
           return 0;
        }
    }

    public int getInt(String message){
        System.out.println(message);
        int temp = scanner.nextInt();
        scanner.nextLine();
        return temp;
    }

    public double getDouble(String message) {
        System.out.println(message);
        double temp = scanner.nextDouble();
        scanner.nextLine();
        return temp;
    }

    public String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
