/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JTextArea;

/**
 *
 * @author Leyla
 */
public class DisplaySocialMediaAccountsFrame extends javax.swing.JFrame {

    /**
     * Creates new form DisplaySocialMediaACcountsFrame
     */
    public DisplaySocialMediaAccountsFrame() {
        setLocationRelativeTo(null);
        setSize(300,300);
        initComponents();
    }

    public JTextArea getTxtAreaDisplay() {
        return txtAreaDisplay;
    }

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDisplay = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Display Frame");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblContent.setText("Content of the file:");
        getContentPane().add(lblContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 20));

        txtAreaDisplay.setColumns(20);
        txtAreaDisplay.setRows(5);
        jScrollPane1.setViewportView(txtAreaDisplay);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, 220));

        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContent;
    private javax.swing.JTextArea txtAreaDisplay;
    // End of variables declaration//GEN-END:variables
}
