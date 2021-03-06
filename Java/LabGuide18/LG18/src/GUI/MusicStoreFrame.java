package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import SystemClassAndMain.MusicStoreSys;

/**
 *
 * @author Burcu
 */
public class MusicStoreFrame extends javax.swing.JFrame {

    AddFrame af = new AddFrame();

    public MusicStoreFrame() {
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

        displayButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgTA = new javax.swing.JTextArea();
        AddButton = new javax.swing.JButton();
        dispIDBUTTON = new javax.swing.JButton();
        dispprtypeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Music Store Frame");

        displayButton.setText("DISPLAY");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        msgTA.setColumns(20);
        msgTA.setRows(5);
        jScrollPane1.setViewportView(msgTA);

        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        dispIDBUTTON.setText("Display by ID");
        dispIDBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispIDBUTTONActionPerformed(evt);
            }
        });

        dispprtypeButton.setText("Display by Product Type");
        dispprtypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispprtypeButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dispIDBUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dispprtypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(displayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayButton)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddButton)
                        .addGap(37, 37, 37)
                        .addComponent(dispIDBUTTON)
                        .addGap(37, 37, 37)
                        .addComponent(dispprtypeButton)
                        .addGap(96, 96, 96))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        if (MusicStoreSys.getStoreSet().isEmpty()) {
            msgTA.setText("Read File First");
        } else {
            msgTA.setText(MusicStoreSys.displaySet());
        }
    }//GEN-LAST:event_displayButtonActionPerformed

    private void dispIDBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispIDBUTTONActionPerformed
        if (MusicStoreSys.getStoreSet().isEmpty()) {
            msgTA.setText("Read File First");
        } else {
            msgTA.setText( MusicStoreSys.displayTreeSetByMusicStoreId());
        }
    }//GEN-LAST:event_dispIDBUTTONActionPerformed

    private void dispprtypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispprtypeButtonActionPerformed
        if (MusicStoreSys.getStoreSet().isEmpty()) {
            msgTA.setText("ReadFile First");
        } else {
            MusicStoreSys.readFromBinary();
            msgTA.setText(MusicStoreSys.displayTreeSetByProductType());
        }
    }//GEN-LAST:event_dispprtypeButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        af.setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton dispIDBUTTON;
    private javax.swing.JButton displayButton;
    private javax.swing.JButton dispprtypeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgTA;
    // End of variables declaration//GEN-END:variables
}
