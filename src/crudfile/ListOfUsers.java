/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudfile;

import DB.CRUD;
import File.CrudFile;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author belciñaan_sd2081
 */
public class ListOfUsers extends javax.swing.JFrame {

    CrudFile cf = new CrudFile();

    public static DefaultTableModel model = new javax.swing.table.DefaultTableModel();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    String email;

    public ListOfUsers() {
        initComponents();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new javax.swing.JTable();
        logoutButton = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Middle Name", "Last Name", "Email"
            }
        ));
        listTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listTable);

        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(199, 199, 199))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableMouseClicked

        JFrame parent = new JFrame();
        JPanel popup = new JPanel();
        JButton delete = new JButton();
        JButton edit = new JButton();
        int row = listTable.getSelectedRow();
        email = model.getValueAt(row, 3).toString();
        delete.setText("Delete");
        edit.setText("EDIT");
        popup.add(edit);
        popup.add(delete);
        parent.add(popup);
        parent.pack();
        parent.setVisible(true);
        parent.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model = (DefaultTableModel) listTable.getModel();
                parent.setVisible(false);
                model.removeRow(row);
                String remove = email;
                String filePath = "Z:\\Java\\CrudFile\\src\\crudfile\\users.txt";
                cf.removeRecord(filePath, remove);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrudFile cf = new CrudFile();
                String [] data = cf.getEmail(email).split(",");
                model = (DefaultTableModel) listTable.getModel();
                parent.setVisible(false);

                UpdateData update = new UpdateData();
                update.setId(data[0]);
                update.setRow(row);
                update.setFname(data[1]);
                update.setMname(data[2]);
                update.setLname(data[3]);
                update.setEmail(data[4]);
                update.setPass(data[5]);
                update.setRepeatpass(data[5]);
                update.setVisible(true);
                parent.setVisible(false);
            }
        });
    }//GEN-LAST:event_listTableMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        Login in = new Login();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonMouseClicked

    static List<String> allLines = null;

    public void showData() {
        try {
            CRUD c = new CRUD();

            allLines = Files.readAllLines(Paths.get("Z:\\Java\\CrudFile\\src\\crudfile\\users.txt"));

            model = (DefaultTableModel) listTable.getModel();
            for (int i = 1; i < allLines.size(); i++) {
                model.addRow(new Object[]{allLines.get(i).split(",")[1], allLines.get(i).split(",")[2], allLines.get(i).split(",")[3], allLines.get(i).split(",")[4]});
            }

        } catch (IOException ex) {
            Logger.getLogger(ListOfUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void listTableMouseClicked(evt){
//    }
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
            java.util.logging.Logger.getLogger(ListOfUsers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfUsers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfUsers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfUsers.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable listTable;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables
}
