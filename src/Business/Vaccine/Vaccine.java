/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yufeng
 */
public class Vaccine {
    private static int count = 0;
    private int vaccineID;
    private String name;
    private String diseaseName;
    private String manufacturerName;
    private String manufacturerDate;
    private String validTerm;
    private int price;
    private int quantity;
    private String timestampe;
    
    
    public Vaccine(){
        count++;
        vaccineID = count;
    }
    
    public String getTimestampe(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.timestampe = dateFormat.format(date);
        return timestampe;
    }

    public int getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(int vaccineID) {
        this.vaccineID = vaccineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerDate() {
        return manufacturerDate;
    }

    public void setManufacturerDate(String manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }

    public String getValidTerm() {
        return validTerm;
    }

    public void setValidTerm(String validTerm) {
        this.validTerm = validTerm;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccineID);
    }
    
    
}
