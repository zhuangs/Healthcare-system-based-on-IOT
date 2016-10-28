/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Insurance.InsuranceCatalog;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.Network.NetworkWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class NetworkRole extends Role{

    
    @Override
    public JPanel CreateWorkArea(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, Organization organization, Business business) {
        return new NetworkWorkAreaJPanel(userProcessContainer,userAccount,network,business);
    }

    
    
}
