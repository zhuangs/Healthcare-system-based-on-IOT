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
import Business.UserAccount.UserAccount;
import Interface.Distributor.DistributorWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class DistributorRole extends Role {

    private Inventory inventory;
    
    public DistributorRole(){
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
    

    @Override
    public JPanel CreateWorkArea(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, Organization organization, Business business) {
        return new DistributorWorkArea(userProcessContainer, userAccount, network, enterprise,organization,business);
    }

   
}
