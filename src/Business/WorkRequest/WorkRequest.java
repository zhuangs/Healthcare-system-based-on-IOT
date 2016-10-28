/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkRequest;

import Business.UserAccount.UserAccount;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yufeng
 */
public abstract class WorkRequest {
    private UserAccount CDCAdmin;
    private UserAccount clinicAdmin;
    private UserAccount distributor;
    private UserAccount hospitalCVSAdmin;
    private UserAccount manufacturer;
    private UserAccount PHDAdmin;
    private String status;
    private String createTime;
    private String timestampe;
    private static int count = 0;
    private int workRequestID;
    private String PHDName;
    
    public WorkRequest(){
        count++;
        workRequestID = count;
    }

    public String getPHDName() {
        return PHDName;
    }

    public void setPHDName(String PHDName) {
        this.PHDName = PHDName;
    }

    
    public int getWorkRequestID() {
        return workRequestID;
    }

    
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getTimestampe(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.timestampe = dateFormat.format(date);
        return timestampe;
    }
    
    public UserAccount getCDCAdmin() {
        return CDCAdmin;
    }

    public void setCDCAdmin(UserAccount CDCAdmin) {
        this.CDCAdmin = CDCAdmin;
    }

    

    public UserAccount getClinicAdmin() {
        return clinicAdmin;
    }

    public void setClinicAdmin(UserAccount clinicAdmin) {
        this.clinicAdmin = clinicAdmin;
    }

    public UserAccount getDistributor() {
        return distributor;
    }

    public void setDistributor(UserAccount distributor) {
        this.distributor = distributor;
    }

    public UserAccount getHospitalCVSAdmin() {
        return hospitalCVSAdmin;
    }

    public void setHospitalCVSAdmin(UserAccount hospitalCVSAdmin) {
        this.hospitalCVSAdmin = hospitalCVSAdmin;
    }

    

    public UserAccount getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(UserAccount manufacturer) {
        this.manufacturer = manufacturer;
    }

    public UserAccount getPHDAdmin() {
        return PHDAdmin;
    }

    public void setPHDAdmin(UserAccount PHDAdmin) {
        this.PHDAdmin = PHDAdmin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(workRequestID);
    }
    
    
    
}
