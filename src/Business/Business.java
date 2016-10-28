/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Disease.DiseaseCatalog;
import Business.Network.NetworkDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SysAdminRole;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class Business extends Organization{
    private static Business business;
    private NetworkDirectory networkDirectory;
    private DiseaseCatalog diseaseCatalog;
    private Business(){
        this.networkDirectory = new NetworkDirectory();
        this.diseaseCatalog = new DiseaseCatalog();
    }
    public static Business getInstance(){
        if(business == null){
            business = new Business();
        }
        return business;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
    }
    
    @Override
    public ArrayList<Role> getSupportedType() {
        {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SysAdminRole());
        return roles;
        
        }
    }
    
    
    
    
}
