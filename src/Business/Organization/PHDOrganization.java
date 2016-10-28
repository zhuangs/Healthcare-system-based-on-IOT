/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.PHDRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class PHDOrganization extends Organization{
    private int population;

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    

    @Override
    public ArrayList<Role> getSupportedType() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PHDRole());
        return roles;
    }
    
}
