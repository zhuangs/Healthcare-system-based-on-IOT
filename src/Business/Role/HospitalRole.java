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
import Interface.Hospital_CVS.HospitalCVSWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class HospitalRole extends Role{

    @Override
    public JPanel CreateWorkArea(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, Organization organization, Business business) {
        return new HospitalCVSWorkArea(userProcessContainer,userAccount,network,enterprise,business);
    }

    

   
    
}
