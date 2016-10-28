/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Billing;

import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author yufeng
 */
public class Billing {
    private int billingID;
    private static int count = 0;
    private Patient patient;
    private UserAccount clinicUserAccount;
    private String clinicName;
    private String status = "Sent";
    private String injectiontime;
    private ArrayList<InjectionItem> injectionItemList;
    private int totalPrice;
    
    public Billing(){
        count++;
        billingID = count;
        injectionItemList = new ArrayList<>();
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    
    public ArrayList<InjectionItem> getInjectionItemList() {
        return injectionItemList;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getClinicUserAccount() {
        return clinicUserAccount;
    }

    public void setClinicUserAccount(UserAccount clinicUserAccount) {
        this.clinicUserAccount = clinicUserAccount;
    }

    public int getBillingID() {
        return billingID;
    }

    public String getInjectiontime() {
        return injectiontime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrise) {
        this.totalPrice = totalPrise;
    }
    
    
    
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setInjectiontime(String injectiontime) {
        this.injectiontime = injectiontime;
    }
    
    public String getTimestampe(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.injectiontime = dateFormat.format(date);
        return injectiontime;
    }

    @Override
    public String toString() {
        return String.valueOf(billingID);
    }

}
