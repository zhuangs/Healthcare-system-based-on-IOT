/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface.Network;

import Business.Insurance.Insurance;
import Business.Role.NetworkRole;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class EditInsurance extends javax.swing.JPanel {

    /**
     * Creates new form EditInsurance
     */
    JPanel userProcessContainer;
    Insurance insurance;
    private float coverRange;
    public EditInsurance(JPanel userProcessContainer, Insurance insurance) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.insurance = insurance;
        nameJTextField.setText(insurance.getInsuranceName());
        coverRangeJTextField1.setText(String.valueOf(insurance.getCoverRange()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();
        coverRangeJTextField1 = new javax.swing.JTextField();
        backJButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cr100jRadioButton1 = new javax.swing.JRadioButton();
        cr80jRadioButton3 = new javax.swing.JRadioButton();
        cr0jRadioButton5 = new javax.swing.JRadioButton();
        cr30jRadioButton2 = new javax.swing.JRadioButton();
        cr50jRadioButton4 = new javax.swing.JRadioButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cover Range:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Insurance Name:");

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save-Small-icon.png"))); // NOI18N
        submitJButton.setText("Save");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        coverRangeJTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        coverRangeJTextField1.setEnabled(false);

        backJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back-3-icon.png"))); // NOI18N
        backJButton1.setText("Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cr100jRadioButton1);
        cr100jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cr100jRadioButton1.setText("100%");
        cr100jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cr100jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cr80jRadioButton3);
        cr80jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cr80jRadioButton3.setText("80%");
        cr80jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cr80jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cr0jRadioButton5);
        cr0jRadioButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cr0jRadioButton5.setText("0%");
        cr0jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cr0jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cr30jRadioButton2);
        cr30jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cr30jRadioButton2.setText("30%");
        cr30jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cr30jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cr50jRadioButton4);
        cr50jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cr50jRadioButton4.setText("50%");
        cr50jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cr50jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cr100jRadioButton1)
                            .addGap(36, 36, 36)
                            .addComponent(cr80jRadioButton3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cr50jRadioButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cr30jRadioButton2)))
                    .addComponent(cr0jRadioButton5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cr100jRadioButton1)
                    .addComponent(cr80jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cr30jRadioButton2)
                    .addComponent(cr50jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cr0jRadioButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addComponent(coverRangeJTextField1)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(coverRangeJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        
        insurance.setInsuranceName(nameJTextField.getText());
        insurance.setCoverRange(coverRange);
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void cr100jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cr100jRadioButton1ActionPerformed
        // TODO add your handling code here:
        coverRange = 1;
    }//GEN-LAST:event_cr100jRadioButton1ActionPerformed

    private void cr80jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cr80jRadioButton3ActionPerformed
        // TODO add your handling code here:
        coverRange = (float) 0.8;
                
    }//GEN-LAST:event_cr80jRadioButton3ActionPerformed

    private void cr50jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cr50jRadioButton4ActionPerformed
        // TODO add your handling code here:
        coverRange = (float) 0.5;
    }//GEN-LAST:event_cr50jRadioButton4ActionPerformed

    private void cr30jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cr30jRadioButton2ActionPerformed
        // TODO add your handling code here:
        coverRange = (float) 0.3;
    }//GEN-LAST:event_cr30jRadioButton2ActionPerformed

    private void cr0jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cr0jRadioButton5ActionPerformed
        // TODO add your handling code here:
        coverRange = 0;
    }//GEN-LAST:event_cr0jRadioButton5ActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField coverRangeJTextField1;
    private javax.swing.JRadioButton cr0jRadioButton5;
    private javax.swing.JRadioButton cr100jRadioButton1;
    private javax.swing.JRadioButton cr30jRadioButton2;
    private javax.swing.JRadioButton cr50jRadioButton4;
    private javax.swing.JRadioButton cr80jRadioButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}