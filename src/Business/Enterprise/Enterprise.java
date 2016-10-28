/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;


/**
 *
 * @author yufeng
 */
public abstract class Enterprise extends Organization{
    private static int count = 0;
    private int enterpriseID;
    private OrganizationDirectory organizationDirectory;
    private String Enterprisename;
    private String networkName;
    
    public enum EnterpriseType{
        Hospital("Hospital"),
        CDC("CDC"),
        CVS("CVS"),
        Manufacturer("Manufacturer");
        
        private String value;
        
        private EnterpriseType(String value){
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
    public Enterprise(){
        count++;
        enterpriseID = count;
        organizationDirectory = new OrganizationDirectory();
       
    }

    public String getEnterprisename() {
        return Enterprisename;
    }

    public void setEnterprisename(String Enterprisename) {
        this.Enterprisename = Enterprisename;
    }

    

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public int getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(int enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    @Override
    public String toString() {
        return String.valueOf(enterpriseID);
    }
    
}
