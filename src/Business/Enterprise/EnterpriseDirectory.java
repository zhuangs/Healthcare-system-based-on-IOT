/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Manufactrurer.Manufacturer;
import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise addEnterprise(EnterpriseType type){
        Enterprise enterprise = null;
        if(type.getValue().equals(EnterpriseType.CDC.getValue())){
            enterprise = new CDCEnterprise();
            enterpriseList.add(enterprise);
        }
        else if(EnterpriseType.CVS.getValue().equals(type.getValue())){
            enterprise = new CVSEnterprise();
            enterpriseList.add(enterprise);
        }
        else if(EnterpriseType.Hospital.getValue().equals(type.getValue())){
            enterprise = new HospitalEnterprise();
            enterpriseList.add(enterprise);
        }
        else if(EnterpriseType.Manufacturer.getValue().equals(type.getValue())){
            enterprise = new Manufacturer();
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
