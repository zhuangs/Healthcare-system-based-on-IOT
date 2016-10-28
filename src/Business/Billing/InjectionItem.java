/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Billing;

import Business.Vaccine.Vaccine;

/**
 *
 * @author yufeng
 */
public class InjectionItem {
    
    private Vaccine vaccine;
    private int quantity;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccine.getVaccineID());
    }
    
}
