package GUI;

import MainAndSystemClass.MapSis;
import javax.swing.DefaultComboBoxModel;

public class MainFrame extends javax.swing.JFrame {

    AddFrame addFrame = new AddFrame();

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fillMapButton = new javax.swing.JButton();
        addBUtton = new javax.swing.JButton();
        dispMapButton = new javax.swing.JButton();
        dispSectionStudentButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayArea_TA = new javax.swing.JTextArea();
        txtSection = new javax.swing.JTextField();
        sectionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Frame");

        fillMapButton.setText("FILL MAP");
        fillMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillMapButtonActionPerformed(evt);
            }
        });

        addBUtton.setText("ADD");
        addBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBUttonActionPerformed(evt);
            }
        });

        dispMapButton.setText("DISPLAY MAP");
        dispMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispMapButtonActionPerformed(evt);
            }
        });

        dispSectionStudentButton.setText("Display Section Students");
        dispSectionStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispSectionStudentButtonActionPerformed(evt);
            }
        });

        displayArea_TA.setColumns(20);
        displayArea_TA.setRows(5);
        jScrollPane1.setViewportView(displayArea_TA);

        sectionLabel.setText("Section:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addBUtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fillMapButton, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(dispMapButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sectionLabel)
                        .addGap(17, 17, 17)
                        .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dispSectionStudentButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(fillMapButton)
                .addGap(32, 32, 32)
                .addComponent(addBUtton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(dispMapButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionLabel))
                .addGap(18, 18, 18)
                .addComponent(dispSectionStudentButton)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBUttonActionPerformed
         
        addFrame.getSectionsCB().setModel(new DefaultComboBoxModel<String>(MapSis.getSections()));
        addFrame.setVisible(true);    }//GEN-LAST:event_addBUttonActionPerformed

    private void dispSectionStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispSectionStudentButtonActionPerformed
        if (txtSection.getText().isEmpty()) {
            displayArea_TA.setText("Enter a Section Number");
        } else {
            displayArea_TA.setText(MapSis.displaySectionStudents(txtSection.getText()));
        }

    }//GEN-LAST:event_dispSectionStudentButtonActionPerformed

    private void fillMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillMapButtonActionPerformed
        MapSis.readStudentsAccordingToSections();
        displayArea_TA.setText("File is read");
    }//GEN-LAST:event_fillMapButtonActionPerformed

    private void dispMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispMapButtonActionPerformed
        if(MapSis.getMap().isEmpty())
            displayArea_TA.setText("First read the files!!");
        else
            displayArea_TA.setText(MapSis.displayStudents());
        
    }//GEN-LAST:event_dispMapButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBUtton;
    private javax.swing.JButton dispMapButton;
    private javax.swing.JButton dispSectionStudentButton;
    private javax.swing.JTextArea displayArea_TA;
    private javax.swing.JButton fillMapButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JTextField txtSection;
    // End of variables declaration//GEN-END:variables
}
