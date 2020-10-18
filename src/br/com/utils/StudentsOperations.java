package br.com.utils;

import br.com.controller.Student;
import br.com.model.StudentDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class StudentsOperations {
    public static ArrayList<Student> setListStudentsInJTable(DefaultTableModel tableStudents) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        tableStudents.setNumRows(0);

        ArrayList<Student> students = studentDAO.selectAllStudents();

        students.forEach((student) -> {
            tableStudents.addRow(
                new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getCourse()
                }
            );
        });
        
        return students;
    }
}
