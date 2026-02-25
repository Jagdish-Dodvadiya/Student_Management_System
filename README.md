## 🧑‍🎓 Student Record Management System

The **Student Record Management System** is a Java-based CLI application designed to manage student data efficiently.  
It follows the **MVC (Model-View-Controller)** pattern with a **DAO layer** for database access, giving clean separation between business logic, UI, and persistence. The app connects to **MySQL** using **JDBC** for permanent storage.

## 🚀 Features

1. Add Student
2. View All Students
3. Update Student Semester and CGPA
4. Search Student by ID
5. Delete Student
6. Exit

## 🛠️ Tech Stack

- **Language:** Java (JDK 17+)
- **Build Tool:** Maven
- **Database:** MySQL
- **Database Connectivity:** JDBC (`mysql-connector-j`)
- **Architecture:** MVC + DAO
- **UI:** Command Line Interface (CLI)

## 📂 Project Structure

```text
student_management_system
|-- pom.xml
`-- src
    `-- main
        `-- java
            `-- com
                `-- managent
                    |-- StudentManagementSystem.java
                    |-- controller
                    |   `-- StudentController.java
                    |-- dao
                    |   |-- StudentDAO.java
                    |   `-- StudentDAOImplementation.java
                    |-- database
                    |   |-- DatabaseOperation.java
                    |   `-- StudentDatabase.java
                    |-- model
                    |   `-- Student.java
                    `-- view
                        `-- StudentView.java
```

## 🧰 Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/Jagdish-Dodvadiya/Student_Management_System.git
cd Student_Management_System
```

2. Create the MySQL database and table:

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

3. Update database credentials in `src/main/java/com/managent/database/StudentDatabase.java`:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/StudentDB";
private static final String USER = "root";
private static final String PASS = "your_password";
```

4. Build and run the project:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.managent.StudentManagementSystem"
```

5. Alternatively, run `StudentManagementSystem.java` directly from your IDE.

## 📋 Menu

```text
1. add new student
2. display all student
3. update student
4. search student
5. delete student
6. exit from system
```

## 👤 Author

- **Jagdish Dodvadiya**
- **GitHub:** https://github.com/Jagdish-Dodvadiya
- **Email:** jagdishdodvadiya545@gmail.com

## 📃 License

This project is open-source and available under the **MIT License**.  
See the [LICENSE](LICENSE) file for details.

## ⚡ Built For

Learning, practicing, and building real-world Java CRUD applications with MVC, DAO, JDBC, and MySQL.
