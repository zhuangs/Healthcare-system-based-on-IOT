/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Inventory;

import Business.Vaccine.Vaccine;

/**
 *
 * @author yufeng
 */
public class InventoryItem {
    private Vaccine vaccine;
    private int amount;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccine.getVaccineID());
    }
    
}
