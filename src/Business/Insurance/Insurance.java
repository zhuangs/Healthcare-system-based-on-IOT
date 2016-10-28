/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Insurance;

/**
 *
 * @author yufeng
 */
public class Insurance {
    private static int count = 0;
    private String insuranceName;
    private float coverRange;
    private int insuranceID;
    private String status = "Active";
    
    public Insurance(){
        count++;
        insuranceID = count;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public float getCoverRange() {
        return coverRange;
    }

    public void setCoverRange(float coverRange) {
        this.coverRange = coverRange;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(insuranceID);
    }
    
}
