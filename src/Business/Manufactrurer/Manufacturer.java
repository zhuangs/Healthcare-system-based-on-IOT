/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Manufactrurer;

import Business.Role.ManufacturerRole;
import Business.Role.Role;
import Business.Enterprise.Enterprise;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class Manufacturer extends Enterprise{
    private String name;
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufacturerRole());
        return roles;
    }

}
