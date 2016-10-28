/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.Role;
import Business.Address.Address;
import Business.Employee.EmployeeDirectory;
import Business.Patient.PatientDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkRequest.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public abstract class Organization {
    
    private static int count = 0;
    private String name;
    private EmployeeDirectory employeeDirectory;
    private Address address;
    private PatientDirectory patientDirectory;
    private WorkQueue workQueue;
    private int organizationID;
    private UserAccountDirectory userAccountDirectory;
    private String status = "Active";
    private String type;
    
    
    public enum OrganizationType{
        
        
        ClinicOrganization("Clinic Organization"),
        DistributorOrganization("Distributor Organization"),
        PHDOrganization("PHD Organization");
        
        
        private String value;
        private OrganizationType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public Organization(){
        count++;
        organizationID = count;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        patientDirectory = new PatientDirectory();
        address = new Address();
        workQueue = new WorkQueue();
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public int getOrganizationID() {
        return organizationID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    @Override
    public String toString() {
        return String.valueOf(organizationID);
    }

    
    
    
    
    
    public abstract ArrayList<Role> getSupportedType();
}
