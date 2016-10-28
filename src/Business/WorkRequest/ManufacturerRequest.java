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
public class ManufacturerRequest extends WorkRequest{
    private ArrayList<VaccineRequestItem> vaccineRequestItemList;
    private String manufacturerName;
    private String option;
    
    
    public ManufacturerRequest(){
        vaccineRequestItemList = new ArrayList<>();
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public ArrayList<VaccineRequestItem> getVaccineRequestItemList() {
        return vaccineRequestItemList;
    }

    
}
