/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.Role;
import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory(){
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization addOrganization(OrganizationType type){
        Organization organization = null;
        if(OrganizationType.ClinicOrganization.getValue().equals(type.getValue())){
            organization = new ClinicOrganization();
            organization.setType("Clinic");
            organizationList.add(organization);
        }
        else if(OrganizationType.DistributorOrganization.getValue().equals(type.getValue())){
            organization = new DistributorOrganization();
            organization.setType("Distributor");
            organizationList.add(organization);
        }
        else if(OrganizationType.PHDOrganization.getValue().equals(type.getValue())){
            organization = new PHDOrganization();
            organization.setType("PHD");
            organizationList.add(organization);
        }
        
        return organization;
    }
}
