/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkRequest;

import java.util.ArrayList;



/**
 *
 * @author yufeng
 */
public class ClinicRequest extends WorkRequest{
    private ArrayList<VaccineRequestItem> vaccineRequestItemList;
    private String clinicName;
    
    public ClinicRequest(){
        vaccineRequestItemList = new ArrayList<>();
    }

    public ArrayList<VaccineRequestItem> getVaccineRequestItemList() {
        return vaccineRequestItemList;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
    
    
}
