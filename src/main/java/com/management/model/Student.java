package com.management.model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String dept;
    private int sem;
    private double cgpa;

    //constructor
    public Student(int id, String name, String email, String dept, int sem, double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.sem = sem;
        this.cgpa = cgpa;
    }

    //getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDept() {
        return dept;
    }

    public int getSem() {
        return sem;
    }

    public double getCgpa() {
        return cgpa;
    }

    //setter methods
    public void setSem(int sem) {
        this.sem = sem;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    
}
