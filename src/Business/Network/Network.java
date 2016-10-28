/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;


import Business.Address.Address;
import Business.Enterprise.EnterpriseDirectory;
import Business.Insurance.InsuranceCatalog;
import Business.Organization.Organization;
import Business.Role.NetworkRole;
import Business.Role.Role;
import static Business.Role.Role.Type.NetworkRole;
import java.util.ArrayList;


/**
 *
 * @author yufeng
 */
public class Network extends Organization{
    private String networkName;
    private EnterpriseDirectory enterpriseDirectory;
    private InsuranceCatalog insuranceCatalog;
    
    public Network(){
        enterpriseDirectory = new EnterpriseDirectory();
        insuranceCatalog = new InsuranceCatalog();
    }

    public InsuranceCatalog getInsuranceCatalog() {
        return insuranceCatalog;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkName() {
        return networkName;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString() {
        return networkName;
    }
    

   

    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new NetworkRole());
        return roles;
    }
    
}
