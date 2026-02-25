# Student Management System

A console-based Java application to manage student records using MySQL and JDBC.

## Features

- Add a new student
- Display all students
- Update student semester and CGPA by ID
- Search a student by ID
- Delete a student by ID
- Menu-driven CLI workflow

## Tech Stack

- Java 17
- Maven
- MySQL
- JDBC (`mysql-connector-j:9.6.0`)

## Project Structure

```text
src/main/java/com/managent
|- StudentManagementSystem.java
|- controller/StudentController.java
|- dao/StudentDAO.java
|- dao/StudentDAOImplementation.java
|- database/DatabaseOperation.java
|- database/StudentDatabase.java
|- model/Student.java
`- view/StudentView.java
```

## Prerequisites

- JDK 17+
- Maven 3.8+
- MySQL 8+

## Database Setup

Run the following SQL in MySQL:

```sql
CREATE DATABASE StudentDB;
USE StudentDB;

CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL,
    dept VARCHAR(80) NOT NULL,
    sem INT NOT NULL,
    cgpa DOUBLE NOT NULL
);
```

## Configuration

Update database credentials in:

`src/main/java/com/managent/database/StudentDatabase.java`

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/StudentDB";
private static final String USER = "root";
private static final String PASS = "your_password";
```

## Build and Run

From the project root (`student_management_system`):

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.managent.StudentManagementSystem"
```

If you prefer, run `StudentManagementSystem.java` directly from your IDE.

## Menu Options

```text
1. add new student
2. display all student
3. update student
4. search student
5. delete student
6. exit from system
```

## Notes

- This is a console CRUD project designed for learning MVC + DAO patterns in Java.
- Database credentials are currently hard-coded and should be externalized for production use.
