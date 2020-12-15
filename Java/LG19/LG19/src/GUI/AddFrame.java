/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import System.DocumentSys;

/**
 *
 * @author Burcu
 */
public class AddFrame extends javax.swing.JFrame {

    public AddFrame() {
        initComponents();
        if (cd_RB.isSelected()) {
            Book_Panel.setVisible(false);
            cdPanel.setVisible(true);
        } else {
            Book_Panel.setVisible(true);
            cdPanel.setVisible(false);
        }

    }

    public void clear() {
        id_TF.setText(null);
        name_TF.setText(null);
        size_TF.setText(null);
        extension_TF.setText(null);
        pageNum_TF.setText(null);
        genre_TF.setText(null);
        disp_Label.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        id_TF = new javax.swing.JTextField();
        name_TF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        size_TF = new javax.swing.JTextField();
        cd_RB = new javax.swing.JRadioButton();
        book_RB = new javax.swing.JRadioButton();
        addBtton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Book_Panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pageNum_TF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        authorIdTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        aNameTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        aSuırnameTF = new javax.swing.JTextField();
        cdPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        genre_TF = new javax.swing.JTextField();
        disp_Label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        extension_TF = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Frame");

        jLabel7.setText("ID:");

        jLabel1.setText("Name:");

        jLabel2.setText("Size:");

        buttonGroup1.add(cd_RB);
        cd_RB.setSelected(true);
        cd_RB.setText("CD");
        cd_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd_RBActionPerformed(evt);
            }
        });

        buttonGroup1.add(book_RB);
        book_RB.setText("Book");
        book_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_RBActionPerformed(evt);
            }
        });

        addBtton.setText("Add");
        addBtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBttonActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Book_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Book"));

        jLabel6.setText("PageNUm:");

        jLabel5.setText("Author Id: ");

        jLabel8.setText("Author Name:");

        jLabel9.setText("Author Surname:");

        javax.swing.GroupLayout Book_PanelLayout = new javax.swing.GroupLayout(Book_Panel);
        Book_Panel.setLayout(Book_PanelLayout);
        Book_PanelLayout.setHorizontalGroup(
            Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Book_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Book_PanelLayout.createSequentialGroup()
                        .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pageNum_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(authorIdTF)))
                    .addGroup(Book_PanelLayout.createSequentialGroup()
                        .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(aSuırnameTF))))
                .addContainerGap())
        );
        Book_PanelLayout.setVerticalGroup(
            Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Book_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pageNum_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(authorIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(Book_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aSuırnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        cdPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("CD"));

        jLabel4.setText("Genre:");

        javax.swing.GroupLayout cdPanelLayout = new javax.swing.GroupLayout(cdPanel);
        cdPanel.setLayout(cdPanelLayout);
        cdPanelLayout.setHorizontalGroup(
            cdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cdPanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(genre_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        cdPanelLayout.setVerticalGroup(
            cdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cdPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genre_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Book_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Book_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setText("Extension:");

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(name_TF)
                                    .addComponent(size_TF)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(extension_TF)
                                        .addGap(2, 2, 2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(cd_RB)
                                        .addGap(18, 18, 18)
                                        .addComponent(book_RB))))
                            .addComponent(disp_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(addBtton)
                        .addGap(59, 59, 59)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(id_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(size_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(extension_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cd_RB)
                    .addComponent(book_RB))
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disp_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtton)
                    .addComponent(jButton2)
                    .addComponent(clearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cd_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd_RBActionPerformed
        Book_Panel.setVisible(false);
        cdPanel.setVisible(true);
    }//GEN-LAST:event_cd_RBActionPerformed

    private void book_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_RBActionPerformed
        Book_Panel.setVisible(true);
        cdPanel.setVisible(false);
    }//GEN-LAST:event_book_RBActionPerformed

    private void addBttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBttonActionPerformed

        if (id_TF.getText().equals("") || name_TF.equals("") || size_TF.equals("") || extension_TF.equals("")) {
            disp_Label.setText("Fill the necessary fields!!");
        } else {
            int id = Integer.parseInt(id_TF.getText());
            String name = name_TF.getText();
            double size = Double.parseDouble(size_TF.getText());
            String extension = extension_TF.getText();

            boolean res = false;
            if (cd_RB.isSelected()) {
                if (genre_TF.getText().equals("")) {
                    disp_Label.setText("Fill the necessary fields!!");
                } else {
                    String genre = genre_TF.getText();
                    res = DocumentSys.addCD(id, name, size, extension, genre);
                    if (res) {
                        disp_Label.setText("Document is added!!");
                    } else {
                        disp_Label.setText("Id already exist!!");
                    }
                }
            } else {
                if (pageNum_TF.getText().equals("")) {
                    disp_Label.setText("Fill the necessary fields!!");
                } else {
                    int pagenum = Integer.parseInt(pageNum_TF.getText());
                    String Asurname = aSuırnameTF.getText();
                    String Aname = aNameTF.getText();
                    int Aid = Integer.parseInt(authorIdTF.getText());

                    res = DocumentSys.addBook(id, name, size, extension, pagenum, Aid, Aname, Asurname);
                    if (res) {
                        disp_Label.setText("Document is added!!");
                    } else {
                        disp_Label.setText("Id already exist!!");
                    }
                }
            }

        }
    }//GEN-LAST:event_addBttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        clear();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Book_Panel;
    private javax.swing.JTextField aNameTF;
    private javax.swing.JTextField aSuırnameTF;
    private javax.swing.JButton addBtton;
    private javax.swing.JTextField authorIdTF;
    private javax.swing.JRadioButton book_RB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cdPanel;
    private javax.swing.JRadioButton cd_RB;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel disp_Label;
    private javax.swing.JTextField extension_TF;
    private javax.swing.JTextField genre_TF;
    private javax.swing.JTextField id_TF;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField name_TF;
    private javax.swing.JTextField pageNum_TF;
    private javax.swing.JTextField size_TF;
    // End of variables declaration//GEN-END:variables
}
