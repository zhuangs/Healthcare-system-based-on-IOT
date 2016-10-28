/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Role.CDCRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class CDCEnterprise extends Enterprise{

    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CDCRole());
        return roles;
    }
    
}
