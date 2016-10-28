/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class VaccineCatalog {
    
    private ArrayList<Vaccine> vaccineList;
    
    public VaccineCatalog(){
        vaccineList = new ArrayList<>();
    }
    public Vaccine addVaccine(){
        Vaccine vaccine = new Vaccine();
        vaccineList.add(vaccine);
        return vaccine;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }
    
}
