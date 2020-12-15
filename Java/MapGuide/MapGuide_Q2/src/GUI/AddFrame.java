/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MainAndSystemClass.MapSis;
import javax.swing.JComboBox;

/**
 *
 * @author Burcu
 */
public class AddFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddFrame
     */
    public AddFrame() {
        initComponents();
    }

    public JComboBox<String> getSectionsCB() {
        return sectionsCB;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stunameLabel = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        stuNameTF = new javax.swing.JTextField();
        sectionsCB = new javax.swing.JComboBox<>();
        adddButton = new javax.swing.JButton();
        closeBUtton = new javax.swing.JButton();
        msgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Frame");

        stunameLabel.setText("Student Name:");

        sectionLabel.setText("Section:");

        adddButton.setText("ADD");
        adddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddButtonActionPerformed(evt);
            }
        });

        closeBUtton.setText("CLOSE");
        closeBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBUttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(closeBUtton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stunameLabel)
                            .addComponent(sectionLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sectionsCB, 0, 89, Short.MAX_VALUE)
                            .addComponent(stuNameTF)))
                    .addComponent(msgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stunameLabel)
                    .addComponent(stuNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sectionLabel)
                    .addComponent(sectionsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adddButton)
                    .addComponent(closeBUtton))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddButtonActionPerformed
        String studentInfo = stuNameTF.getText();
        int sec = Integer.parseInt(sectionsCB.getSelectedItem().toString());
        MapSis.addStudentToSection(sec, studentInfo);
        msgLabel.setText("Student is added");
    }//GEN-LAST:event_adddButtonActionPerformed

    private void closeBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBUttonActionPerformed
        stuNameTF.setText("");
        msgLabel.setText("");
        sectionsCB.setSelectedIndex(0);
        dispose();
    }//GEN-LAST:event_closeBUttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adddButton;
    private javax.swing.JButton closeBUtton;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JComboBox<String> sectionsCB;
    private javax.swing.JTextField stuNameTF;
    private javax.swing.JLabel stunameLabel;
    // End of variables declaration//GEN-END:variables
}
