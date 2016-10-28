/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public abstract class Role {
    public enum Type{
        
        CDCRole("CDC Role"),
        CVSRole("CVS Role"),
        ClinicRole("Clinic Role"),
        DistributorRole("Distributor Role"),
        HospitalRole("Hospital Role"),
        ManufacturerRole("Manufacturer Role"),
        NetworkRole("Network Role"),
        PHDRole("PHD Role"),
        SysAdminRole("SysAdmin Role");
        
        private String type;
        
        private Type(String type){
        this.type = type;
    }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return type;
        }
        
        
    }
    
    
    public abstract JPanel CreateWorkArea(
        JPanel userProcessContainer,
        UserAccount userAccount,
        Network network,
        Enterprise enterprise,
        Organization organization,
        Business business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
        
        
        
    
    
    
}
