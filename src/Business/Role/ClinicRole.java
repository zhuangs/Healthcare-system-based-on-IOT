/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Inventory.Inventory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.PatientDirectory;
import Business.UserAccount.UserAccount;
import Interface.Clinic.ClinicWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class ClinicRole extends Role {

   private PatientDirectory patientDirectory;
   private Inventory inventory;
   
   public ClinicRole(){
       patientDirectory = new PatientDirectory();
       inventory = new Inventory();
               
   }

    public Inventory getInventory() {
        return inventory;
    }

    

   
   
    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    
   
    
    @Override
    public JPanel CreateWorkArea(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, Organization organization, Business business) {
        return new ClinicWorkArea(userProcessContainer,userAccount,network,enterprise,organization,business);
    }

  

   
    
}
