/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;



/**
 *
 * @author yufeng
 */
public class VaccineLimit {
    
   private Vaccine vaccine;
   private int limitAmount;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getLimitAmout() {
        return limitAmount;
    }

    public void setLimitAmount(int limit) {
        this.limitAmount = limit;
    }
    
    
}
