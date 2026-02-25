package com.managent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.managent.model.Student;

public class StudentDatabase implements DatabaseOperation {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String USER = "root";
    private static final String PASS = "";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Override
    public boolean addStudent(Student student) {
        String query = "INSERT INTO Student(id, name, email, dept, sem, cgpa) VALUES(?,?,?,?,?,?)";
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getDept());
            ps.setInt(5, student.getSem());
            ps.setDouble(6, student.getCgpa());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error occured at add student : " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Student> displayStudent() {
        String query = "SELECT * FROM Student";
        List<Student> list = new ArrayList<>();
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(6)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error occured at display student : " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean searchUpdateStudent(int id) {
        String searchQuery = "SELECT id FROM Student WHERE id = ?";
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(searchQuery);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (id == rs.getInt(1)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error occured at search and update student : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateStudent(int id, int sem, double cgpa) {
        String updateQuery = "UPDATE Student SET sem = ?, cgpa = ? WHERE id = ?";
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(updateQuery);) {
            ps.setInt(1, sem);
            ps.setDouble(2, cgpa);
            ps.setInt(3, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error occured at update student : " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Student> searchStudents(int id) {
        String query = "SELECT * FROM Student WHERE id = ?";
        List<Student> list = new ArrayList<>();
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("dept"),
                        rs.getInt("sem"),
                        rs.getDouble("cgpa")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error occured at search student : " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean deleteStudent(int id) {
        String query = "DELETE FROM Student WHERE id = ?";
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error occured at delete student : " + e.getMessage());
            return false;
        }
    }
}
