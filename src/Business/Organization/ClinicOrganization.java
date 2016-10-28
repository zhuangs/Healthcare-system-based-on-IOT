/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.ClinicRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class ClinicOrganization extends Organization{

    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClinicRole());
        return roles;
    }
    
}
