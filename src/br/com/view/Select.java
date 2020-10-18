package br.com.view;

import br.com.controller.Student;
import br.com.model.StudentDAO;
import br.com.utils.OnlyNumbers;
import static br.com.utils.StudentsOperations.setListStudentsInJTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Select extends javax.swing.JFrame {

    public Select() {
        initComponents();
        txtId.setDocument(new OnlyNumbers());
    }
    
    public void cleanTextField() {
        txtId.setText(null);
        txtId.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnSelectAllStudents = new javax.swing.JButton();
        btnCleanTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnSearchStudentById = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Select Students");

        btnSelectAllStudents.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSelectAllStudents.setText("Select All Studens");
        btnSelectAllStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllStudentsActionPerformed(evt);
            }
        });

        btnCleanTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCleanTable.setText("Clean Table");
        btnCleanTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanTableActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Student id");

        btnSearchStudentById.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchStudentById.setText("Search");
        btnSearchStudentById.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStudentByIdActionPerformed(evt);
            }
        });

        tbStudents.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Email", "Course"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbStudents.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbStudents);
        if (tbStudents.getColumnModel().getColumnCount() > 0) {
            tbStudents.getColumnModel().getColumn(0).setResizable(false);
            tbStudents.getColumnModel().getColumn(1).setResizable(false);
            tbStudents.getColumnModel().getColumn(2).setResizable(false);
            tbStudents.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelectAllStudents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCleanTable, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchStudentById)
                        .addGap(374, 374, 374))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCleanTable, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnSelectAllStudents, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchStudentById, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectAllStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllStudentsActionPerformed
        DefaultTableModel tableStudents = (DefaultTableModel) tbStudents.getModel();
        
        try {
            if (tableStudents.getRowCount() != 0) {
                JOptionPane.showMessageDialog(null, "Students are already selected.");
            } else {
                ArrayList<Student> students = setListStudentsInJTable(tableStudents);
                
                if (students.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No students found.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSelectAllStudentsActionPerformed

    private void btnCleanTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanTableActionPerformed
        DefaultTableModel tableStudents = (DefaultTableModel) tbStudents.getModel();
        
        if (tableStudents.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "The table is already clean.");
        } else {
            tableStudents.setNumRows(0);   
        }
    }//GEN-LAST:event_btnCleanTableActionPerformed

    private void btnSearchStudentByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStudentByIdActionPerformed
        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill the field with id.");
        } else {
            StudentDAO studentDAO = new StudentDAO();
            DefaultTableModel tableStudents = (DefaultTableModel) tbStudents.getModel();
            int id = Integer.parseInt(txtId.getText());
        
            try {
                Student student = studentDAO.selectSpecificStudent(id);
                
                if (student == null) {
                    JOptionPane.showMessageDialog(null, "No student found.");
                    cleanTextField();
                } else {
                    for (int i = 0; i < tableStudents.getRowCount(); i++) {
                        if (tableStudents.getValueAt(i, 0).equals(id)) {
                            JOptionPane.showMessageDialog(null, "Student are already selected.");
                            cleanTextField();
                            return;
                        }
                    }
                    tableStudents.addRow(
                            new Object[]{
                                student.getId(),
                                student.getName(),
                                student.getEmail(),
                                student.getCourse()
                            }
                    );
                    cleanTextField();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSearchStudentByIdActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Select().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanTable;
    private javax.swing.JButton btnSearchStudentById;
    private javax.swing.JButton btnSelectAllStudents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbStudents;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
