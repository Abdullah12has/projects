/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import SistemClassAndMain.*;
import SocialMediaInheritance.*;
import SocialMediaHasA.*;
import java.util.ArrayList;
/**
 *
 * @author Leyla
 */
public class InstagramAccountFrame extends javax.swing.JFrame {

    String url;
    /**
     * Creates new form InstagramAccountFrame
     */
    public InstagramAccountFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(350,500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numOfFollow = new javax.swing.JLabel();
        txtFollow = new javax.swing.JTextField();
        lblFollower = new javax.swing.JLabel();
        txtFollower = new javax.swing.JTextField();
        lblPstInfo = new javax.swing.JLabel();
        lblPostId = new javax.swing.JLabel();
        txtPostId = new javax.swing.JTextField();
        lblUrl = new javax.swing.JLabel();
        lblTopic = new javax.swing.JLabel();
        txtTopic = new javax.swing.JTextField();
        lblImageID = new javax.swing.JLabel();
        txtimageId = new javax.swing.JTextField();
        btnAddAcc = new javax.swing.JButton();
        lblCreate = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblImageInst = new javax.swing.JLabel();
        lblAddAccount = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Instagram Account");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numOfFollow.setText("Number of Follow:");
        getContentPane().add(numOfFollow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 20));
        getContentPane().add(txtFollow, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 180, 20));

        lblFollower.setText("Number Of Follower:");
        getContentPane().add(lblFollower, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 20));
        getContentPane().add(txtFollower, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, 20));

        lblPstInfo.setText("Enter Post Information:");
        getContentPane().add(lblPstInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 30));

        lblPostId.setText("Post ID:");
        getContentPane().add(lblPostId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        getContentPane().add(txtPostId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 180, -1));
        getContentPane().add(lblUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, 20));

        lblTopic.setText("Topic:");
        getContentPane().add(lblTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 40, 20));
        getContentPane().add(txtTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 180, -1));

        lblImageID.setText("Image ID:");
        getContentPane().add(lblImageID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        getContentPane().add(txtimageId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 20));

        btnAddAcc.setText("ADD ACCOUNT");
        btnAddAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        lblCreate.setText("Create a new account:");
        getContentPane().add(lblCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 150, 20));

        lblName.setText("Enter name:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 180, 20));

        lblSurname.setText("Enter surname:");
        getContentPane().add(lblSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 20));
        getContentPane().add(txtSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180, -1));

        lblImageInst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instagram.jpg"))); // NOI18N
        getContentPane().add(lblImageInst, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));
        getContentPane().add(lblAddAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccActionPerformed
        String name = txtName.getText();
        String surname = txtSurname.getText();
        String url = SocialMediaAccountSys.createUrl(name,surname,"instagram");
        lblUrl.setText(url);
        int numOfFollow = Integer.parseInt(txtFollow.getText());
        int numOfFollower = Integer.parseInt(txtFollower.getText());
        int postID = Integer.parseInt(txtPostId.getText());
        String topic = txtTopic.getText();
        int imageID = Integer.parseInt(txtimageId.getText());
        ArrayList<Posts> temp = new ArrayList();
        Posts post = new Posts(postID,topic,imageID);
        temp.add(post);
        InstagramAccount instacc = new InstagramAccount("instagram", url, 2019, numOfFollow, numOfFollower, 1, temp);
        lblAddAccount.setText(name+" "+surname+" is added");
        SocialMediaAccountSys.accountList.add(instacc);
    }//GEN-LAST:event_btnAddAccActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
       dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAcc;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblAddAccount;
    private javax.swing.JLabel lblCreate;
    private javax.swing.JLabel lblFollower;
    private javax.swing.JLabel lblImageID;
    private javax.swing.JLabel lblImageInst;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPostId;
    private javax.swing.JLabel lblPstInfo;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTopic;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JLabel numOfFollow;
    private javax.swing.JTextField txtFollow;
    private javax.swing.JTextField txtFollower;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPostId;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTopic;
    private javax.swing.JTextField txtimageId;
    // End of variables declaration//GEN-END:variables
}