/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface.CDC;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Manufactrurer.Manufacturer;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.Organization.PHDOrganization;
import Business.Role.CDCRole;
import Business.Role.DistributorRole;
import Business.Role.ManufacturerRole;
import Business.Role.PHDRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineLimit;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yufeng
 */
public class CDCWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form CDCWorkArea
     */
    JPanel userProcessContainer;
    Business business;
    Network network;
    Enterprise enterprise;
    UserAccount userAccount;
    public CDCWorkArea(JPanel userProcessContainer,UserAccount userAccount,Network network,Enterprise enterprise,Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.network = network;
       
        populateTable();
        populateClinicTable();
        populateUserTable();
        populatePHDvaccineTable();
        populateVaccineJTable();
    }

    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) organizationJTable.getModel();
        dtm.setRowCount(0);
        for(Organization organizationhere : enterprise.getOrganizationDirectory().getOrganizationList()){
            
                Object[] row = new Object[4];
                row[0] = organizationhere;
                row[1] = organizationhere.getName();
                row[2] = organizationhere.getStatus();
                row[3] = organizationhere.getType();
                dtm.addRow(row);
             
        }
    }
    public void populatePHDvaccineTable(){
        DefaultTableModel dtm = (DefaultTableModel) PHDvaccineJTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[7];
            row[0] = workRequest;
            row[1] = workRequest.getClinicAdmin();
            row[2] = workRequest.getHospitalCVSAdmin();
            row[3] = workRequest.getPHDAdmin();
            row[4] = workRequest.getStatus() == "Sent to CDC" ? "Pending" : workRequest.getStatus();
            row[5] = workRequest.getCDCAdmin() == null ? null : workRequest.getCDCAdmin();
            row[6] = workRequest.getCreateTime();
            dtm.addRow(row);
        }
        
    }
    public void populateByDate(String time){
        DefaultTableModel dtm = (DefaultTableModel) PHDvaccineJTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()){
            if(workRequest.getCreateTime().equals(time)){
                Object[] row = new Object[7];
                row[0] = workRequest;
                row[1] = workRequest.getClinicAdmin();
                row[2] = workRequest.getHospitalCVSAdmin();
                row[3] = workRequest.getPHDAdmin();
                row[4] = workRequest.getStatus() == "Sent to CDC" ? "Pending" : workRequest.getStatus();
                row[5] = workRequest.getCDCAdmin() == null ? null : workRequest.getCDCAdmin();
                row[6] = workRequest.getCreateTime();
                dtm.addRow(row);
        
            }
        }    
            
    }
    
    public void populateClinicTable(){
        DefaultTableModel dtm = (DefaultTableModel) clinicJTable1.getModel();
        dtm.setRowCount(0);
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if(organization instanceof ClinicOrganization){
                    for(UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()){
                        
                    Object[] row = new Object[4];
                    row[0] = organization;
                    row[1] = organization.getName();
                    row[2] = userAccount;
                    row[3] = organization.getStatus();
                    dtm.addRow(row);
                    }    
                }
            }
        }
        
    }
    
    public void populateUserTable(){
        DefaultTableModel dtm = (DefaultTableModel) userjTable1.getModel();
        dtm.setRowCount(0);
        for(Organization organizationhere : enterprise.getOrganizationDirectory().getOrganizationList()){
            for(UserAccount userAccounthere : organizationhere.getUserAccountDirectory().getUserAccountList()){
                Object[] row = new Object[3];
                row[0] = organizationhere;
                row[1] = organizationhere.getName();
                row[2] = userAccounthere;
                dtm.addRow(row);
            }
        }
    }
    
    public void populateVaccineJTable(){
        DefaultTableModel dtm = (DefaultTableModel) vaccineJTable1.getModel();
        dtm.setRowCount(0);
        for(Enterprise enterprisehere : network.getEnterpriseDirectory().getEnterpriseList()){
            if(enterprisehere instanceof Manufacturer){
                for(UserAccount userAccounthere : enterprisehere.getUserAccountDirectory().getUserAccountList()){
                    for(Vaccine vaccine : ((ManufacturerRole)userAccounthere.getRole()).getVaccineCatalog().getVaccineList()){
                      Object[] row = new Object[3];
                      row[0] = vaccine;
                      row[1] = vaccine.getName();
                      row[2] = vaccine.getManufacturerName();
                      dtm.addRow(row);
                    }
                }
            }
           
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
        organizationJTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        refreshJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        viewJButton1 = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        userjTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        refreshJButton2 = new javax.swing.JButton();
        addJButton1 = new javax.swing.JButton();
        editJButton1 = new javax.swing.JButton();
        deleteJButton1 = new javax.swing.JButton();
        viewJButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PHDvaccineJTable1 = new javax.swing.JTable();
        viewJButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        viewJButton3 = new javax.swing.JButton();
        submitJButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        vaccineJTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        limitjSpinner2 = new javax.swing.JSpinner();
        vaccinejTextField2 = new javax.swing.JTextField();
        PHDjLabel1 = new javax.swing.JLabel();
        phdjTextField1 = new javax.swing.JTextField();
        PHDjLabel2 = new javax.swing.JLabel();
        PHDjLabel3 = new javax.swing.JLabel();
        refreshJButton1 = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        clinicJTable1 = new javax.swing.JTable();
        approveJButton1 = new javax.swing.JButton();

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization ID", "Organization Name", "Status", "Organization Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton.setText("Refresh ");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete-icon.png"))); // NOI18N
        deleteJButton.setText("Delete Organization");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        editJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-icon.png"))); // NOI18N
        editJButton.setText("Edit Organization Info");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        viewJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-view-list-details-icon.png"))); // NOI18N
        viewJButton1.setText("View Organization");
        viewJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton1ActionPerformed(evt);
            }
        });

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Add-icon.png"))); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(viewJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Organizations", jPanel1);

        userjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization ID", "Organization Name", "UserAccount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(userjTable1);

        refreshJButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton2.setText("Refresh ");
        refreshJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton2ActionPerformed(evt);
            }
        });

        addJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Add-icon.png"))); // NOI18N
        addJButton1.setText("Add User Account");
        addJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButton1ActionPerformed(evt);
            }
        });

        editJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-icon.png"))); // NOI18N
        editJButton1.setText("Edit Employee Info");
        editJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButton1ActionPerformed(evt);
            }
        });

        deleteJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete-icon.png"))); // NOI18N
        deleteJButton1.setText("Delete ");
        deleteJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButton1ActionPerformed(evt);
            }
        });

        viewJButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-view-list-details-icon.png"))); // NOI18N
        viewJButton4.setText("View Employee");
        viewJButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewJButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewJButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(editJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Organizaiton UserAccount", jPanel3);

        PHDvaccineJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Order ID", "Sender", "Hospital Reciver", "PHD Name", "Status", "CDC Receiver", "Created Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(PHDvaccineJTable1);

        viewJButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-view-list-details-icon.png"))); // NOI18N
        viewJButton2.setText("View All Orders");
        viewJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton2ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy/MM/dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        viewJButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search-icon.png"))); // NOI18N
        viewJButton3.setText("Search");
        viewJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton3ActionPerformed(evt);
            }
        });

        submitJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Circle-apply-icon.png"))); // NOI18N
        submitJButton1.setText("Approve");
        submitJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(viewJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(viewJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(submitJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(viewJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Vaccine Order", jPanel2);

        vaccineJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine name", "Manufacturer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vaccineJTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vaccineJTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(vaccineJTable1);

        limitjSpinner2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        vaccinejTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vaccinejTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccinejTextField2ActionPerformed(evt);
            }
        });
        vaccinejTextField2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                vaccinejTextField2PropertyChange(evt);
            }
        });

        PHDjLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PHDjLabel1.setText("The PHD you choose is :");

        phdjTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phdjTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phdjTextField1ActionPerformed(evt);
            }
        });
        phdjTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                phdjTextField1PropertyChange(evt);
            }
        });

        PHDjLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PHDjLabel2.setText("The Vaccine you choose is :");

        PHDjLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PHDjLabel3.setText("The Limit on this vaccine is :");

        refreshJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton1.setText("Refresh ");
        refreshJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton1ActionPerformed(evt);
            }
        });

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Circle-apply-icon.png"))); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(PHDjLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limitjSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PHDjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PHDjLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vaccinejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phdjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PHDjLabel1)
                            .addComponent(phdjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PHDjLabel2)
                            .addComponent(vaccinejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(refreshJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PHDjLabel3)
                    .addComponent(limitjSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Vaccine Limit", jPanel4);

        clinicJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClinicID", "Clinic Name", "User Account", "Clinic Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(clinicJTable1);

        approveJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approveJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Circle-apply-icon.png"))); // NOI18N
        approveJButton1.setText("Approve");
        approveJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(approveJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(approveJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Approve Clinic", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        AddOrganization ado = new AddOrganization(userProcessContainer,enterprise);
        userProcessContainer.add("AddOrganization",ado);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addJButtonActionPerformed

    private void viewJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Organization organization = (Organization)organizationJTable.getValueAt(selectedRow, 0);
            ViewOrganization vo = new ViewOrganization(userProcessContainer,organization);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewJButton1ActionPerformed

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        // TODO add your handling code here
        int selectedRow = organizationJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Organization organization = (Organization)organizationJTable.getValueAt(selectedRow, 0);
            EditOrganization eo = new EditOrganization(userProcessContainer, organization);
            userProcessContainer.add("EditOrganization", eo);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Organization organization = (Organization)organizationJTable.getValueAt(selectedRow, 0);
            
            int p =  JOptionPane.showConfirmDialog(null, "Do you want to delete this?","Delete",JOptionPane.YES_NO_OPTION);
            if(p == 0){
                organization.setStatus("Disable");
            }

        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void viewJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton2ActionPerformed
        // TODO add your handling code here:
        populatePHDvaccineTable();
        
    }//GEN-LAST:event_viewJButton2ActionPerformed

    private void viewJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton3ActionPerformed
        // TODO add your handling code here:
        Date date = jDateChooser1.getDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd") ;
        String time = formatter.format(date);
        populateByDate(time);
    }//GEN-LAST:event_viewJButton3ActionPerformed

    private void addJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Organization organization = (Organization) organizationJTable.getValueAt(selectedRow,0);
            if(organization instanceof PHDOrganization) {
                try{
                    organization.getUserAccountDirectory().getUserAccountList().get(0);
                    JOptionPane.showMessageDialog(null, "You can create only one account for PHD!");
                    return;
                }
                catch(Exception e){
                    AddPHDUserAccount addpa = new AddPHDUserAccount(userProcessContainer,organization);
                    userProcessContainer.add("AddPHDUserAccount", addpa);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
                
            }
            else{
                AddPHDUserAccount addpa = new AddPHDUserAccount(userProcessContainer,organization);
                userProcessContainer.add("AddPHDUserAccount", addpa);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
            
        }
    }//GEN-LAST:event_addJButton1ActionPerformed

    private void refreshJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton2ActionPerformed
        // TODO add your handling code here:
        populateUserTable();
    }//GEN-LAST:event_refreshJButton2ActionPerformed

    private void viewJButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton4ActionPerformed
        // TODO add your handling code here:
         int selectedRow = organizationJTable.getSelectedRow();
         if(selectedRow < 0 ){
             JOptionPane.showMessageDialog(null, "Please select a row!");
         }
         else{
            
            UserAccount userAccounthere = (UserAccount) userjTable1.getValueAt(selectedRow, 2);
            ViewOrganizationUserAccount vo = new ViewOrganizationUserAccount(userProcessContainer,userAccounthere);
            userProcessContainer.add("ViewOrganizationUserAccount",vo);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
         }
    }//GEN-LAST:event_viewJButton4ActionPerformed

    private void editJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        UserAccount userAccount = (UserAccount) userjTable1.getValueAt(selectedRow, 2);
        if(userAccount == null){
            JOptionPane.showMessageDialog(null, "Please select a valid UserAccount");
        }
        else{
            EditOrganizationUserAccount eua = new EditOrganizationUserAccount(userProcessContainer,userAccount);
            userProcessContainer.add("EditOrganizationUserAccount", eua);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_editJButton1ActionPerformed

    private void deleteJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
           UserAccount userAccounthere = (UserAccount) userjTable1.getValueAt(selectedRow,2);
           Organization organizationhere = (Organization) userjTable1.getValueAt(selectedRow, 0);
           int p =  JOptionPane.showConfirmDialog(null, "Do you want to delete this?","Delete",JOptionPane.YES_NO_OPTION);
            if(p == 0){
              organizationhere.getUserAccountDirectory().getUserAccountList().remove(userAccounthere);
            }
            
        }
    }//GEN-LAST:event_deleteJButton1ActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        int selected1 = organizationJTable.getSelectedRow();
        Organization or = (Organization) organizationJTable.getValueAt(selected1, 0);
        int selected2 = vaccineJTable1.getSelectedRow();
        Vaccine va = (Vaccine) vaccineJTable1.getValueAt(selected2, 0);
        UserAccount userAccount = or.getUserAccountDirectory().getUserAccountList().get(0);
        if(userAccount.getRole() instanceof DistributorRole){
            JOptionPane.showMessageDialog(null, "Please select a PHD organization");
            return;
        }
        else{
            VaccineLimit vaccineLimit = new VaccineLimit();
            vaccineLimit.setVaccine(va);
            vaccineLimit.setLimitAmount((int)limitjSpinner2.getValue());
            ((PHDRole)userAccount.getRole()).getVaccineLimitlist().add(vaccineLimit);
        }
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void approveJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = clinicJTable1.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        else{
                Organization or = (Organization) clinicJTable1.getValueAt(selectedRow, 0);
                if(or.getStatus().equals("Active")){
                 JOptionPane.showMessageDialog(null,"This Account has already been actived!");
                 return;   
                }
                else{
                    or.setStatus("Active");
                    JOptionPane.showMessageDialog(null,"Successfully!");
                    populateClinicTable();
                }
        }
        

    }//GEN-LAST:event_approveJButton1ActionPerformed

    private void submitJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = PHDvaccineJTable1.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        else{
            WorkRequest workRequestintable = (WorkRequest) PHDvaccineJTable1.getValueAt(selectedRow, 0);
            ProcessVaccineOrder pvr = new ProcessVaccineOrder(userProcessContainer,workRequestintable,network ,enterprise,userAccount);
            userProcessContainer.add("ProcessVaccineOrder", pvr);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_submitJButton1ActionPerformed

    private void phdjTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_phdjTextField1PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_phdjTextField1PropertyChange

    private void vaccinejTextField2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_vaccinejTextField2PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vaccinejTextField2PropertyChange

    private void phdjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phdjTextField1ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_phdjTextField1ActionPerformed

    private void vaccinejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccinejTextField2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vaccinejTextField2ActionPerformed

    private void refreshJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton1ActionPerformed
        // TODO add your handling code here:
         int selected1 = organizationJTable.getSelectedRow();
        Organization or = (Organization) organizationJTable.getValueAt(selected1, 0);
        if( or != null){
            phdjTextField1.setText(or.getName());
        }
        
        int selected2 = vaccineJTable1.getSelectedRow();
        Vaccine va = (Vaccine) vaccineJTable1.getValueAt(selected2, 0);
        if( va != null){
            vaccinejTextField2.setText(va.getName());
        }
    }//GEN-LAST:event_refreshJButton1ActionPerformed

    private void vaccineJTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaccineJTable1MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_vaccineJTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PHDjLabel1;
    private javax.swing.JLabel PHDjLabel2;
    private javax.swing.JLabel PHDjLabel3;
    private javax.swing.JTable PHDvaccineJTable1;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton addJButton1;
    private javax.swing.JButton approveJButton1;
    private javax.swing.JTable clinicJTable1;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton deleteJButton1;
    private javax.swing.JButton editJButton;
    private javax.swing.JButton editJButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner limitjSpinner2;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTextField phdjTextField1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton refreshJButton1;
    private javax.swing.JButton refreshJButton2;
    private javax.swing.JButton submitJButton;
    private javax.swing.JButton submitJButton1;
    private javax.swing.JTable userjTable1;
    private javax.swing.JTable vaccineJTable1;
    private javax.swing.JTextField vaccinejTextField2;
    private javax.swing.JButton viewJButton1;
    private javax.swing.JButton viewJButton2;
    private javax.swing.JButton viewJButton3;
    private javax.swing.JButton viewJButton4;
    // End of variables declaration//GEN-END:variables
}
