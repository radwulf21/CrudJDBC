package br.com.view;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        operations = new javax.swing.JMenu();
        operationRegister = new javax.swing.JMenuItem();
        operationDelete = new javax.swing.JMenuItem();
        operationEdit = new javax.swing.JMenuItem();
        operationSelect = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        operations.setText("Operations");

        operationRegister.setText("Register Student");
        operationRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationRegisterActionPerformed(evt);
            }
        });
        operations.add(operationRegister);

        operationDelete.setText("Delete Student");
        operationDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationDeleteActionPerformed(evt);
            }
        });
        operations.add(operationDelete);

        operationEdit.setText("Edit Student");
        operationEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationEditActionPerformed(evt);
            }
        });
        operations.add(operationEdit);

        operationSelect.setText("Select Student");
        operationSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationSelectActionPerformed(evt);
            }
        });
        operations.add(operationSelect);

        jMenuBar1.add(operations);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void operationRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationRegisterActionPerformed
        Register register = new Register();
        
        register.setVisible(true);
    }//GEN-LAST:event_operationRegisterActionPerformed

    private void operationDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationDeleteActionPerformed
        Delete delete = new Delete();
        
        delete.setVisible(true);
    }//GEN-LAST:event_operationDeleteActionPerformed

    private void operationEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationEditActionPerformed
        Edit edit = new Edit();
        
        edit.setVisible(true);
    }//GEN-LAST:event_operationEditActionPerformed

    private void operationSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationSelectActionPerformed
        Select select = new Select();
        
        select.setVisible(true);
    }//GEN-LAST:event_operationSelectActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem operationDelete;
    private javax.swing.JMenuItem operationEdit;
    private javax.swing.JMenuItem operationRegister;
    private javax.swing.JMenuItem operationSelect;
    private javax.swing.JMenu operations;
    // End of variables declaration//GEN-END:variables
}
