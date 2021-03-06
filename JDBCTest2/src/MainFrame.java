
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author nguyenhongphat0
 */
public class MainFrame extends javax.swing.JFrame {
    DefaultTableModel model;
    UserDAO dao = new UserDAO();
    List<String> users = new ArrayList<>();
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        model = (DefaultTableModel) dataTable.getModel();
        showUsers("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameTxt = new javax.swing.JTextField();
        fullnameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        rolesTxt = new javax.swing.JTextField();
        insertBtn = new javax.swing.JButton();
        filterBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Manager");

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        usernameTxt.setText("username");
        jPanel1.add(usernameTxt);

        fullnameTxt.setText("fullname");
        jPanel1.add(fullnameTxt);

        passwordTxt.setText("password");
        jPanel1.add(passwordTxt);

        rolesTxt.setText("roles");
        jPanel1.add(rolesTxt);

        insertBtn.setText("Insert");
        insertBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        jPanel1.add(insertBtn);

        filterBtn.setText("Filter");
        filterBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });
        jPanel1.add(filterBtn);

        deleteBtn.setText("Delete");
        deleteBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteBtn);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Fullname", "Password", "Roles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataTable);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void show(String mess) {
        JOptionPane.showMessageDialog(null, mess);
    }
    
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        UserDTO user = new UserDTO(usernameTxt.getText(), fullnameTxt.getText(), passwordTxt.getText(), rolesTxt.getText());
        if (dao.insert(user)) {
            model.addRow(user.toVector());
            users.add(user.username);
            show("++ user " + user.username + " added successful");
        }
        else show("!! user " + user.username + " added failed (username existed or connection error!)");
        user = null;
    }//GEN-LAST:event_insertBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        if (dao.delete(usernameTxt.getText())) {
            int pos = users.indexOf(usernameTxt.getText());
            model.removeRow(pos);
            users.remove(pos);
            show("-- deleted user " + usernameTxt.getText() + " successful");
        } else show("-- unable to delete user " + usernameTxt.getText() + " (user not exist or connection error!)");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void showUsers(String like) {
        model.setRowCount(0);
        users.clear();
        for (UserDTO user : dao.findlike(like)) {
            model.addRow(user.toVector());
            users.add(user.username);
        }
        dataTable.updateUI();
    }
    
    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        // TODO add your handling code here:
        showUsers(fullnameTxt.getText());
    }//GEN-LAST:event_filterBtnActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JTextField fullnameTxt;
    private javax.swing.JButton insertBtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JTextField rolesTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
