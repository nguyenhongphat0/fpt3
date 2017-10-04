/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import threads.OutputThread;

/**
 *
 * @author Phat
 */
public class ManagerChat extends javax.swing.JFrame implements Runnable {
    ServerSocket srvSocket;
    BufferedReader br;
    DataOutputStream os;
    static Thread thread;
    int port;
    ChatPanel p;
    
    /**
     * Creates new form ManagerChat
     */
    public ManagerChat() {
        try {
            initComponents();
            port = Integer.parseInt(portTxt.getText());
            srvSocket = new ServerSocket(port);
            JOptionPane.showMessageDialog(this, "Connection establish");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error create server with port " + port);
        }
        
        
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
        jLabel1 = new javax.swing.JLabel();
        portTxt = new javax.swing.JTextField();
        tabPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Port: ");
        jPanel1.add(jLabel1);

        portTxt.setText("6334");
        portTxt.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel1.add(portTxt);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(tabPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ManagerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManagerChat t = new ManagerChat();
                t.setVisible(true);
                thread = new Thread(t);
                thread.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField portTxt;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            while (true) {
                Socket staffSocket = srvSocket.accept();
                JOptionPane.showMessageDialog(this, "Some one connecting");
                if (staffSocket != null) {
                    br = new BufferedReader(new InputStreamReader(staffSocket.getInputStream()));
                    os = new DataOutputStream(staffSocket.getOutputStream());
                    String staffName = br.readLine();
                    p = new ChatPanel(staffSocket, "Manager", staffName);
                    p.getLogsTxt().append("Connect to " + staffName + " successful\n");
                    tabPane.addTab(staffName, p);
                    OutputThread ot = new OutputThread(staffSocket, p.getLogsTxt(), "Manager", staffName);
                    ot.start();
                }
                Thread.sleep(500);
            }
        } catch (Exception e) {
        }
    
    }
}
