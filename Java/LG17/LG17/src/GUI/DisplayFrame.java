/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SistemClassAndMain.GameSys;


/**
 *
 * @author Burcu
 */
public class DisplayFrame extends javax.swing.JFrame {

    /**
     * Creates new form DisplayFrame
     */
    public DisplayFrame() {
        initComponents();
    }

    public void setDispTA(String s) {
        typeCMB.setSelectedIndex(0); 
        dispTA.setText(s);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeCMB = new javax.swing.JComboBox<>();
        typeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dispTA = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Display Frame");

        typeCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Published Year" }));
        typeCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCMBActionPerformed(evt);
            }
        });

        typeLabel.setText("Display by:");

        dispTA.setColumns(20);
        dispTA.setRows(5);
        jScrollPane1.setViewportView(dispTA);

        closeButton.setText("CLOSE");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(typeCMB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(closeButton)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void typeCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCMBActionPerformed
        String dispBy = (String) typeCMB.getSelectedItem();
        if (dispBy.equalsIgnoreCase("Category")) {
            dispTA.setText(GameSys.displayGamesByCategory());
        } else {
            dispTA.setText(GameSys.displayGamesByPublishedYear());
        }
    }//GEN-LAST:event_typeCMBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea dispTA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> typeCMB;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
