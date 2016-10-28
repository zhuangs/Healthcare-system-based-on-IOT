/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Role.CVSRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class CVSEnterprise extends Enterprise{
    private String PHDbelonging;

    public String getPHDbelonging() {
        return PHDbelonging;
    }

    public void setPHDbelonging(String PHDbelonging) {
        this.PHDbelonging = PHDbelonging;
    }
    

    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CVSRole());
        return roles;
    }
    
}
