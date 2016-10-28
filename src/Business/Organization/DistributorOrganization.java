/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.DistributorRole;
import Business.Role.Role;
import Business.Billing.BillingDirectory;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class DistributorOrganization extends Organization{
    
    private BillingDirectory billingDirectory;
    
    public DistributorOrganization(){
        billingDirectory = new BillingDirectory();
    }

    public BillingDirectory getBillingDirectory() {
        return billingDirectory;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorRole());
        return roles;
    }
    
}
