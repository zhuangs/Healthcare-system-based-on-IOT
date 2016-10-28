/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Manufactrurer;

import Business.Vaccine.Vaccine;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yufeng
 */
public class ManufacturerVaccineSaleItem {
    
    private Vaccine vaccine;
    private int amount;
    private String timestampe;
    private String vaccineSaleTime;
    private String type;
    
    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getAmount() {
        return amount;
    }

    public String getVaccineSaleTime() {
        return vaccineSaleTime;
    }

    public void setVaccineSaleTime(String vaccineSaleTime) {
        this.vaccineSaleTime = vaccineSaleTime;
    }
    public String getTimestampe(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.timestampe = dateFormat.format(date);
        return timestampe;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
