/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface.Clinic;

import Business.Billing.Billing;
import Business.Billing.InjectionItem;
import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Role.ClinicRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkRequest.ClinicRequest;
import Business.WorkRequest.VaccineRequestItem;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yufeng
 */
public class ClinicWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ClinicWorkArea
     */
    JPanel userProcessContainer;
    Business business;
    Network network;
    Enterprise enterprise;
    Organization organization;
    UserAccount userAccount;
    private String gender;
    private Billing billing;
    Boolean isCheckedOut = false;
    public ClinicWorkArea(JPanel userProcessContainer,UserAccount userAccount,Network network,Enterprise enterprise,Organization organization,Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        populateTable();
        this.billing = new Billing();
        populateBillVaccineTable();
        populateVaccineTable();
        populateRequestShippmentJTable();
        populateVaccineInventoryTable();
        populateBillingHistoryTable();
    }
    
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) patientJTable.getModel();
        dtm.setRowCount(0);
        for(Patient patient : ((ClinicRole)userAccount.getRole()).getPatientDirectory().getPatientList()){
            Object[] row = new Object[6];
            row[0] = patient;
            row[1] = patient.getFirstname() + patient.getLastname();
            row[2] = patient.getGender();
            row[3] = patient.getAge();
            row[4] = patient.getInsurance().getInsuranceName();
            row[5] = patient.getInsurance().getCoverRange();
            dtm.addRow(row);
        }
        
        
    }
    
    
    public void populateVaccineTable(){
        DefaultTableModel dtm = (DefaultTableModel) vaccinebillJTable1.getModel();
        dtm.setRowCount(0);
        for(InventoryItem inventoryItem : ((ClinicRole)userAccount.getRole()).getInventory().getInventoryItemList()){
            Object[] row = new Object[5];
            row[0] = inventoryItem;
            row[1] = inventoryItem.getVaccine().getName();
            row[2] = inventoryItem.getVaccine().getManufacturerName();
            row[3] = inventoryItem.getVaccine().getPrice();
            row[4] = inventoryItem.getAmount();
            dtm.addRow(row);
        }
    }
    
    public void populateBillVaccineTable(){
        DefaultTableModel dtm = (DefaultTableModel) billJTable.getModel();
        dtm.setRowCount(0);
        for(InjectionItem item : billing.getInjectionItemList()){
            Object[] row = new Object[4];
            row[0] = item;
            row[1] = item.getVaccine().getName();
            row[2] = item.getVaccine().getPrice();
            row[3] = item.getQuantity();
            dtm.addRow(row);
        }
        
    }
    public void populateBillingHistoryTable(){
        DefaultTableModel dtm = (DefaultTableModel) billingHistoryJTable.getModel();
        dtm.setRowCount(0);
        for(Enterprise enterprisehere :network.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization oi : enterprisehere.getOrganizationDirectory().getOrganizationList()){
                if(oi instanceof DistributorOrganization){
                    for(Billing billinghere : ((DistributorOrganization)oi).getBillingDirectory().getBillingList()){
                        Object[] row = new Object[5];
                        row[0] = billinghere;
                        row[1] = billinghere.getPatient();
                        row[2] = billinghere.getInjectiontime();
                        row[3] = billinghere.getTotalPrice();
                        row[4] = billinghere.getStatus();
                        dtm.addRow(row);
                    }
                }
            }
        }
          
    }
    
    public void populateBillingHistoryVaccine(Billing billing){
        DefaultTableModel dtm = (DefaultTableModel) billinghistoryVaccinelJTable2.getModel();
        dtm.setRowCount(0);
        for(InjectionItem injectionItem : billing.getInjectionItemList()){
            Object[] row = new Object[4];
            row[0] = injectionItem.getVaccine();
            row[1] = injectionItem.getVaccine().getName();
            row[2] = injectionItem.getVaccine().getPrice();
            row[3] = injectionItem.getQuantity();
            dtm.addRow(row);
        }
        
    }
    
     public void populateVaccineInventoryTable(){
        DefaultTableModel dtm = (DefaultTableModel) vaccineInventoryJTable2.getModel();
        dtm.setRowCount(0);
        for(InventoryItem inventoryItem : ((ClinicRole)userAccount.getRole()).getInventory().getInventoryItemList()){
            Object[] row = new Object[3];
            row[0] = inventoryItem;
            row[1] = inventoryItem.getVaccine().getName();
            row[2] = inventoryItem.getAmount();
            dtm.addRow(row);
        }
    }
    
    public void populateRequestShippmentJTable(){
        DefaultTableModel dtm = (DefaultTableModel) requestshippmentJTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[3];
            row[0] = workRequest;
            if(workRequest.getStatus().equals("Shipped")){
                workRequest.setStatus("Arrival");
            }
            row[1] = workRequest.getStatus() == "Shipped" ? "Arrival": workRequest.getStatus();
            row[2] = workRequest.getClinicAdmin().getEmployee().getFirstname();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientJTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        addpatientJButton = new javax.swing.JButton();
        lastnamejTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstnamejTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        malejRadioButton1 = new javax.swing.JRadioButton();
        femalejRadioButton3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        ageJSpinner2 = new javax.swing.JSpinner();
        viewJButton1 = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billJTable = new javax.swing.JTable();
        submitJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        vaccinebillJTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        quantityjSpinner2 = new javax.swing.JSpinner();
        addJButton1 = new javax.swing.JButton();
        refreshJButton2 = new javax.swing.JButton();
        deleteJButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        billingHistoryJTable = new javax.swing.JTable();
        viewJButton2 = new javax.swing.JButton();
        viewJButton3 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        billinghistoryVaccinelJTable2 = new javax.swing.JTable();
        refreshJButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        vaccineInventoryJTable2 = new javax.swing.JTable();
        createVaccineOrderJButton = new javax.swing.JButton();
        receiveJButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        requestshippmentJTable = new javax.swing.JTable();
        refreshJButton1 = new javax.swing.JButton();

        patientJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Gender", "Age", "Insurance Name", "Cover Range"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientJTable);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quick Add", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), new java.awt.Color(0, 153, 204))); // NOI18N

        addpatientJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addpatientJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Add-icon.png"))); // NOI18N
        addpatientJButton.setText("ADD");
        addpatientJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpatientJButtonActionPerformed(evt);
            }
        });

        lastnamejTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Firstname:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Lastname:");

        firstnamejTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender:");

        buttonGroup1.add(malejRadioButton1);
        malejRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        malejRadioButton1.setText("Male");
        malejRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malejRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(femalejRadioButton3);
        femalejRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        femalejRadioButton3.setText("Female");
        femalejRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femalejRadioButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Age:");

        ageJSpinner2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(firstnamejTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastnamejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ageJSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(malejRadioButton1))
                                .addGap(26, 26, 26)
                                .addComponent(femalejRadioButton3))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(addpatientJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnamejTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lastnamejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(malejRadioButton1)
                    .addComponent(femalejRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageJSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(addpatientJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        viewJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-view-list-details-icon.png"))); // NOI18N
        viewJButton1.setText("View Patient");
        viewJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton1ActionPerformed(evt);
            }
        });

        editJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-icon.png"))); // NOI18N
        editJButton.setText("Edit Patient Info");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete-icon.png"))); // NOI18N
        deleteJButton.setText("Delete ");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton.setText("Refresh ");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(viewJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Patient", jPanel1);

        billJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(billJTable);

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Circle-apply-icon.png"))); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        vaccinebillJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Manufacturer Name", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(vaccinebillJTable1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Quantity:");

        quantityjSpinner2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        addJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Add-icon.png"))); // NOI18N
        addJButton1.setText("ADD to Cart");
        addJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButton1ActionPerformed(evt);
            }
        });

        refreshJButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton2.setText("Refresh ");
        refreshJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(quantityjSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(addJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(deleteJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshJButton2)
                        .addGap(68, 68, 68))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityjSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Patient Bills Management", jPanel2);

        billingHistoryJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Billing ID", "Patient ID", "Injection Date", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(billingHistoryJTable);

        viewJButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-view-list-details-icon.png"))); // NOI18N
        viewJButton2.setText("View Biiling Info");
        viewJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton2ActionPerformed(evt);
            }
        });

        viewJButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewJButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-view-list-details-icon.png"))); // NOI18N
        viewJButton3.setText("View Patient Info");
        viewJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton3ActionPerformed(evt);
            }
        });

        billinghistoryVaccinelJTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(billinghistoryVaccinelJTable2);

        refreshJButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton3.setText("Refresh ");
        refreshJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(viewJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(viewJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshJButton3)
                        .addGap(57, 57, 57))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bill History", jPanel4);

        vaccineInventoryJTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(vaccineInventoryJTable2);
        if (vaccineInventoryJTable2.getColumnModel().getColumnCount() > 0) {
            vaccineInventoryJTable2.getColumnModel().getColumn(1).setHeaderValue("Vaccine Name");
            vaccineInventoryJTable2.getColumnModel().getColumn(2).setHeaderValue("Amount");
        }

        createVaccineOrderJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createVaccineOrderJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email-send-icon.png"))); // NOI18N
        createVaccineOrderJButton.setText("Create Vaccine Request");
        createVaccineOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createVaccineOrderJButtonActionPerformed(evt);
            }
        });

        receiveJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        receiveJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Download-icon.png"))); // NOI18N
        receiveJButton.setText("Receive Vaccine");
        receiveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveJButtonActionPerformed(evt);
            }
        });

        requestshippmentJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Order ID", "Status", "Clinic Employee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(requestshippmentJTable);

        refreshJButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refreshJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reload-icon.png"))); // NOI18N
        refreshJButton1.setText("Refresh ");
        refreshJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(receiveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(refreshJButton1)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(createVaccineOrderJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(createVaccineOrderJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vaccine Inventory", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addpatientJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpatientJButtonActionPerformed
        // TODO add your handling code here:
        Patient patient = ((ClinicRole)userAccount.getRole()).getPatientDirectory().addPatient();
        patient.setFirstname(firstnamejTextField4.getText());
        patient.setLastname(lastnamejTextField3.getText());
        patient.setGender(gender);
        patient.setAge((int)ageJSpinner2.getValue());
        AddPatient ado = new AddPatient(userProcessContainer,patient,network);
        userProcessContainer.add("AddPatient",ado);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addpatientJButtonActionPerformed

    private void viewJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Patient patient = (Patient)patientJTable.getValueAt(selectedRow, 0);
            ViewPatient vp = new ViewPatient(userProcessContainer,patient);
            userProcessContainer.add("ViewPatient",vp);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewJButton1ActionPerformed

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        // TODO add your handling code here
        int selectedRow = patientJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Patient patient = (Patient)patientJTable.getValueAt(selectedRow, 0);
            EditPatient ep = new EditPatient(userProcessContainer, patient, network);
            userProcessContainer.add("EditPatient", ep);
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Patient patient = (Patient)patientJTable.getValueAt(selectedRow, 0);

            int p =  JOptionPane.showConfirmDialog(null, "Do you want to delete this?","Delete",JOptionPane.YES_NO_OPTION);
            if(p == 0){
                ((ClinicRole)userAccount.getRole()).getPatientDirectory().deletePatient(patient);
            }

        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void malejRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malejRadioButton1ActionPerformed
        // TODO add your handling code here:
        gender = "Male";
    }//GEN-LAST:event_malejRadioButton1ActionPerformed

    private void femalejRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femalejRadioButton3ActionPerformed
        // TODO add your handling code here:
        gender = "Female";
    }//GEN-LAST:event_femalejRadioButton3ActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a Patient!");
        }
        else{
            Patient patient = (Patient)patientJTable.getValueAt(selectedRow, 0); 
            Organization oi = null;
            for(Enterprise enterprisehere :network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization organizationhere : enterprisehere.getOrganizationDirectory().getOrganizationList()){
                    if(organizationhere instanceof DistributorOrganization){
                        oi = organizationhere;
                    }
                }
            }
            if(billing.getInjectionItemList() != null){
                billing.setInjectiontime(billing.getTimestampe());
                int total = 0;
                for(InjectionItem item : billing.getInjectionItemList()){
                    total = item.getQuantity()*item.getVaccine().getPrice() + total ;
                }
                billing.setTotalPrice(total);
                billing.setClinicName(organization.getName());
                billing.setClinicUserAccount(userAccount);
                billing.setStatus("Sent");
                billing.setPatient(patient);
                ((DistributorOrganization)oi).getBillingDirectory().getBillingList().add(billing);
                JOptionPane.showMessageDialog(null, "You have create the bill sucessfully!");
            }
            else{
                JOptionPane.showMessageDialog(null, "There is something wrong!");
                return;
            }
            if(!isCheckedOut){
                Billing billing2 = new Billing();
                populateVaccineTable();
                populateBillVaccineTable();
            }
    
        }
                
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void addJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButton1ActionPerformed
        // TODO add your handling code here:
        int seletedRow = vaccinebillJTable1.getSelectedRow();
        if(seletedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            
            InventoryItem inventoryItem = (InventoryItem) vaccinebillJTable1.getValueAt(seletedRow, 0);
            Boolean isinclude = false;
            int quantity = (int) quantityjSpinner2.getValue();
            if(quantity < 0 || quantity > inventoryItem.getAmount()){
                JOptionPane.showMessageDialog(null, "Please input a valid quantity!!");
                return;
            }
            for(InjectionItem itemincart : billing.getInjectionItemList()){
                if(inventoryItem.getVaccine().getName().equals(itemincart.getVaccine().getName())){
                    int newAmount = inventoryItem.getAmount() - quantity;
                    inventoryItem.setAmount(newAmount);
                    quantity = quantity + itemincart.getQuantity();
                    itemincart.setQuantity(quantity);
                    isinclude = true;
                }
            }
            
            if(!isinclude){
                InjectionItem injectionItem = new InjectionItem();
                injectionItem.setVaccine(inventoryItem.getVaccine());
                injectionItem.setQuantity(quantity);
                int newAmount = inventoryItem.getAmount() - quantity;
                inventoryItem.setAmount(newAmount);
                billing.getInjectionItemList().add(injectionItem);
                
            }
            
            populateVaccineTable();
            populateBillVaccineTable();
            
        }
    }//GEN-LAST:event_addJButton1ActionPerformed

    private void viewJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = billingHistoryJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Billing billinghere = (Billing) billingHistoryJTable.getValueAt(selectedRow, 0);
            populateBillingHistoryVaccine(billinghere);
        }
        
        
    }//GEN-LAST:event_viewJButton2ActionPerformed

    private void viewJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = billingHistoryJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            Patient patient = (Patient)billingHistoryJTable.getValueAt(selectedRow, 1);
            ViewPatient vp = new ViewPatient(userProcessContainer,patient);
            userProcessContainer.add("ViewPatient",vp);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewJButton3ActionPerformed

    private void receiveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestshippmentJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            WorkRequest workRequesthere = (WorkRequest) requestshippmentJTable.getValueAt(selectedRow, 0);
            if(workRequesthere.getStatus().equals("Done")){
                JOptionPane.showMessageDialog(null, "It's already done!");
                return;
            }
            else{
                workRequesthere.setStatus("Done");
                Boolean isinclude = false;
                for(VaccineRequestItem clinicRequestItem : ((ClinicRequest)workRequesthere).getVaccineRequestItemList()){
                    for(InventoryItem inventoryItem : ((ClinicRole)userAccount.getRole()).getInventory().getInventoryItemList()){
                        if(clinicRequestItem.getVaccine().getName().equals(inventoryItem.getVaccine().getName()) && clinicRequestItem.getVaccine().getManufacturerName().equals(inventoryItem.getVaccine().getManufacturerName())){
                            int newAmount = inventoryItem.getAmount() + clinicRequestItem.getAmount();
                            inventoryItem.setAmount(newAmount);
                            isinclude = true;
                        }
                    }
                    if(!isinclude){
                        InventoryItem inventoryItemnot = new InventoryItem();
                        inventoryItemnot.setVaccine(clinicRequestItem.getVaccine());
                        inventoryItemnot.setAmount(clinicRequestItem.getAmount());
                        ((ClinicRole)userAccount.getRole()).getInventory().getInventoryItemList().add(inventoryItemnot);

                    }
                }
                populateVaccineInventoryTable();
                populateRequestShippmentJTable();
            }
        }

    }//GEN-LAST:event_receiveJButtonActionPerformed

    private void createVaccineOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createVaccineOrderJButtonActionPerformed
        // TODO add your handling code here:
        CreateVaccineRequset cvr = new CreateVaccineRequset(userProcessContainer,network,enterprise,userAccount,organization);
        userProcessContainer.add("CreateVaccineRequset", cvr);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createVaccineOrderJButtonActionPerformed

    private void refreshJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton1ActionPerformed
        // TODO add your handling code here:
        populateRequestShippmentJTable();
        populateVaccineInventoryTable();
        populateBillVaccineTable();
    }//GEN-LAST:event_refreshJButton1ActionPerformed

    private void refreshJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton2ActionPerformed
        // TODO add your handling code here:
         populateVaccineTable();
         populateBillVaccineTable();
    }//GEN-LAST:event_refreshJButton2ActionPerformed

    private void refreshJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton3ActionPerformed
        // TODO add your handling code here:
        populateBillVaccineTable();
        populateBillingHistoryTable();
       
    }//GEN-LAST:event_refreshJButton3ActionPerformed

    private void deleteJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = billJTable.getSelectedRow();
        if(selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
        else{
            try{
                InjectionItem itemhere = (InjectionItem) billJTable.getValueAt(selectedRow, 0);
                for(InventoryItem inventoryItem : ((ClinicRole)userAccount.getRole()).getInventory().getInventoryItemList()){
                    if(itemhere.getVaccine().getName().equals(inventoryItem.getVaccine().getName())){
                        int newamount = itemhere.getQuantity() + inventoryItem.getAmount();
                        inventoryItem.setAmount(newamount);
                        billing.getInjectionItemList().remove(itemhere);
                    }
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please select a row!");
            }
            
        }
       populateVaccineTable();
       populateBillVaccineTable();
       
        
    }//GEN-LAST:event_deleteJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton1;
    private javax.swing.JButton addpatientJButton;
    private javax.swing.JSpinner ageJSpinner2;
    private javax.swing.JTable billJTable;
    private javax.swing.JTable billingHistoryJTable;
    private javax.swing.JTable billinghistoryVaccinelJTable2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton createVaccineOrderJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton deleteJButton1;
    private javax.swing.JButton editJButton;
    private javax.swing.JRadioButton femalejRadioButton3;
    private javax.swing.JTextField firstnamejTextField4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastnamejTextField3;
    private javax.swing.JRadioButton malejRadioButton1;
    private javax.swing.JTable patientJTable;
    private javax.swing.JSpinner quantityjSpinner2;
    private javax.swing.JButton receiveJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton refreshJButton1;
    private javax.swing.JButton refreshJButton2;
    private javax.swing.JButton refreshJButton3;
    private javax.swing.JTable requestshippmentJTable;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTable vaccineInventoryJTable2;
    private javax.swing.JTable vaccinebillJTable1;
    private javax.swing.JButton viewJButton1;
    private javax.swing.JButton viewJButton2;
    private javax.swing.JButton viewJButton3;
    // End of variables declaration//GEN-END:variables
}
