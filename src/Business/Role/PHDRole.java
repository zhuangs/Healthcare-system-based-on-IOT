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
import Business.Vaccine.VaccineCatalog;
import Business.Vaccine.VaccineLimit;
import Interface.PHD.PHDWorkArea;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class PHDRole extends Role{
    

private ArrayList<VaccineLimit> vaccineLimitlist;

public PHDRole(){
    vaccineLimitlist = new ArrayList<VaccineLimit>();
}

    public ArrayList<VaccineLimit> getVaccineLimitlist() {
        return vaccineLimitlist;
    }

   

   


    @Override
    public JPanel CreateWorkArea(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, Organization organization, Business business) {
        return new PHDWorkArea(userProcessContainer,userAccount,network,enterprise,organization,business);
    }

    

    
    
}
