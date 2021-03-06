/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface.Network;

import Business.Insurance.Insurance;
import Business.Network.Network;
import Business.Role.NetworkRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yufeng
 */
public class ManageInsurance extends javax.swing.JPanel {

    /**
     * Creates new form ManageInsurance
     */
    JPanel userProcessContainer;
    Network network;
    
    
    public ManageInsurance(JPanel userProcessContainer,Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        
        populateTable();
    }

    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) insuranceJTable.getModel();
        dtm.setRowCount(0);
        for(Insurance insurance : network.getInsuranceCatalog().getInsuranceList()){
            Object row[] = new Object[3];
            row[0] = insurance;
            row[1] = insurance.getInsuranceName();
            row[2] = insurance.getCoverRange();
            dtm.addRow(row);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        insuranceJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        refreshJButton1 = new javax.swing.JButton();

        insuranceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Insurace ID", "Insurance Name", "Cover Range"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(insuranceJTable);

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Add-icon.png"))); // NOI18N
        addJButton.setText("Add  Insurance");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        editJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-icon.png"))); // NOI18N
        editJButton.setText("Edit Insurance");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete-icon.png"))); // NOI18N
        deleteJButton.setText("Delete Insurance");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton.setText("Refresh Model");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        refreshJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back-3-icon.png"))); // NOI18N
        refreshJButton1.setText("Back");
        refreshJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(refreshJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(editJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshJButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        AddInsurance ai = new AddInsurance(userProcessContainer,network);
        userProcessContainer.add("AddInsurance",ai);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addJButtonActionPerformed

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        // TODO add your handling code here
        int seletedRow = insuranceJTable.getSelectedRow();
        if(seletedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Insurance insurance = (Insurance) insuranceJTable.getValueAt(seletedRow, 0);
            EditInsurance ei = new EditInsurance(userProcessContainer, insurance);
            userProcessContainer.add("EditInsurance", ei);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        int seletedRow = insuranceJTable.getSelectedRow();
        if(seletedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Insurance insurance = (Insurance) insuranceJTable.getValueAt(seletedRow, 0);
            network.getInsuranceCatalog().getInsuranceList().remove(insurance);
            populateTable();
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void refreshJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_refreshJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton editJButton;
    private javax.swing.JTable insuranceJTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton refreshJButton1;
    // End of variables declaration//GEN-END:variables
}
