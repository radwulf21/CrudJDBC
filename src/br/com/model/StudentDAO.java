package br.com.model;

import br.com.controller.Student;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO extends DAO {
    public void insertStudent(Student student) throws SQLException {
        openConnection();

        String query = "INSERT INTO tb_student (id, name, email, course) VALUES (null, ?, ?, ?)";
        ps = (PreparedStatement) conn.prepareStatement(query);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getCourse());
        ps.execute();

        closeQuery(); 
    }
    
    public boolean validateEmail(String email) throws SQLException {
        openConnection();
        
        String query = "SELECT * FROM tb_student WHERE email = ?";
        ps = (PreparedStatement) conn.prepareStatement(query);
        ps.setString(1, email);
        rs = ps.executeQuery();
        rs.last();
        int affectedRows = rs.getRow();
        
        closeQuery();
        
        return affectedRows == 0;
    }
    
    public ArrayList<Student> selectAllStudents() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        
        openConnection();
        
        String query = "SELECT * FROM tb_student";
        ps = (PreparedStatement) conn.prepareStatement(query);
        rs = ps.executeQuery();
        
        Student student;
        while (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setCourse(rs.getString("course"));
            students.add(student);
        }
        
        closeQuery();
        
        return students;
    }
    
    public Student selectSpecificStudent(int id) throws SQLException {
        openConnection();
        
        String query = "SELECT * FROM tb_student WHERE id = ?";
        ps = (PreparedStatement) conn.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
        Student student = null;
        if (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setCourse(rs.getString("course"));
        }
        
        closeQuery();
        
        return student;
    }
    
    public void deleteStudent(int id) throws SQLException {
        openConnection();
        
        String query = "DELETE FROM tb_student WHERE id = ?";
        ps = (PreparedStatement) conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
        
        closeQuery();
    }
    
    public void editStudent(Student student) throws SQLException {
        openConnection();
        
        String query = "UPDATE tb_student set name = ?, email = ?, course = ? WHERE id = ?";
        ps = (PreparedStatement) conn.prepareStatement(query);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getCourse());
        ps.setInt(4, student.getId());
        ps.executeUpdate();
        
        closeQuery();
    }
}
