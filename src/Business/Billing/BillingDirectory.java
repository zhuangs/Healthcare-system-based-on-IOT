/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Billing;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class BillingDirectory {
    private ArrayList<Billing> billingList;
    
    public BillingDirectory(){
        billingList = new ArrayList<>();
    }

    public ArrayList<Billing> getBillingList() {
        return billingList;
    }

    public void setBillingList(ArrayList<Billing> billingList) {
        this.billingList = billingList;
    }
    public Billing addBilling(){
        Billing billing = new Billing();
        billingList.add(billing);
        return billing;
    }
    
    
    
}
