/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Insurance;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class InsuranceCatalog {
    private ArrayList<Insurance> insuranceList;
    
    public InsuranceCatalog(){
        insuranceList = new ArrayList<>();
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }
    public Insurance addInsurance(){
        Insurance insurance = new Insurance();
        insuranceList.add(insurance);
        return insurance; 
    }
    public void deleteInsurance(Insurance insurance){
        insurance.setStatus("Disable");
    }
}
