/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import System.DocumentSys;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

/**
 *
 * @author Burcu
 */
public class DocumentFrame extends javax.swing.JFrame {

   SearchFrame sf = new SearchFrame();
    AddFrame af = new AddFrame();

    public DocumentFrame() {
        initComponents();
    }

    public void fillComboBox() {
       sf.getId_CMB().setModel(new DefaultComboBoxModel(DocumentSys.getIds()));
    }

    public JTextArea getDisp_TA() {
        return disp_TA;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        writeBinButton = new javax.swing.JButton();
        sidpByNameButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        disp_TA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Document Frame");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        writeBinButton.setText("Write to BIN");
        writeBinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeBinButtonActionPerformed(evt);
            }
        });

        sidpByNameButton.setText("Display By Name");
        sidpByNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidpByNameButtonActionPerformed(evt);
            }
        });

        disp_TA.setEditable(false);
        disp_TA.setColumns(20);
        disp_TA.setRows(5);
        jScrollPane1.setViewportView(disp_TA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(writeBinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidpByNameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addComponent(writeBinButton)
                .addGap(18, 18, 18)
                .addComponent(sidpByNameButton)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        af.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        fillComboBox();
        sf.setVisible(true);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void writeBinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeBinButtonActionPerformed
        DocumentSys.writeToBin();
        disp_TA.setText("Set is written to the binary file!!");
    }//GEN-LAST:event_writeBinButtonActionPerformed

    private void sidpByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidpByNameButtonActionPerformed
        disp_TA.setText(DocumentSys.displayByName());
    }//GEN-LAST:event_sidpByNameButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea disp_TA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton sidpByNameButton;
    private javax.swing.JButton writeBinButton;
    // End of variables declaration//GEN-END:variables
}
