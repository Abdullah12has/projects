/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import SistemClassAndMain.*;

/**
 *
 * @author Leyla
 */
public class SocialMediaAccountFrame extends javax.swing.JFrame {

    DisplaySocialMediaAccountsFrame df = new DisplaySocialMediaAccountsFrame();
    InstagramAccountFrame instf = new InstagramAccountFrame();
    FacebookAccountFrame facef = new FacebookAccountFrame();
    public SocialMediaAccountFrame() {
        setLocationRelativeTo(null);
        setSize(250,450);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAccountInfo = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        lblFileRead = new javax.swing.JLabel();
        btnDisplau = new javax.swing.JButton();
        lblSocialImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SocialMediaAccount Frame");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAccountInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAccountInfo.setText("Social Media Account Type:");
        getContentPane().add(lblAccountInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 260, -1));

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Instagram", "Facebook", " " }));
        getContentPane().add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 130, -1));

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 110, -1));

        btnRead.setText("READ FROM FILE");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        getContentPane().add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, 30));

        lblFileRead.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblFileRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 250, 30));

        btnDisplau.setText("DISPLAY");
        btnDisplau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplauActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisplau, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 130, 30));

        lblSocialImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media.jpg"))); // NOI18N
        getContentPane().add(lblSocialImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisplauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplauActionPerformed
        if(SocialMediaAccountSys.accountList.isEmpty())
        {
            lblFileRead.setText("First read the file");
        }
        else
        {
            df.setVisible(true);
            df.getTxtAreaDisplay().setText(SocialMediaAccountSys.display());
        }
    }//GEN-LAST:event_btnDisplauActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        if(SocialMediaAccountSys.accountList.isEmpty())
            lblFileRead.setText(SocialMediaAccountSys.readFromFile());
        else
            lblFileRead.setText("File already read!");
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String selection = cmbType.getSelectedItem().toString();
        if(selection.equalsIgnoreCase("instagram"))
            instf.setVisible(true);
        else
            facef.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDisplau;
    private javax.swing.JButton btnRead;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel lblAccountInfo;
    private javax.swing.JLabel lblFileRead;
    private javax.swing.JLabel lblSocialImage;
    // End of variables declaration//GEN-END:variables
}
