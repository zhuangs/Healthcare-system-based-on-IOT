/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Manufactrurer.ManufacturerVaccineSaleItem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineCatalog;
import Interface.Manufacturer.ManufacturerWorkArea;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author yufeng
 */
public class ManufacturerRole extends Role{
    private VaccineCatalog vaccineCatalog;
    private ArrayList<ManufacturerVaccineSaleItem> manufacturerVaccineSaleItemList;
    
    public ManufacturerRole(){
        vaccineCatalog = new VaccineCatalog();
        manufacturerVaccineSaleItemList = new ArrayList<ManufacturerVaccineSaleItem>();
    }

    public ArrayList<ManufacturerVaccineSaleItem> getManufacturerVaccineSaleItemList() {
        return manufacturerVaccineSaleItemList;
    }
    
    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }
    
    
    @Override
    public JPanel CreateWorkArea(JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, Organization organization, Business business) {
        return new ManufacturerWorkArea(userProcessContainer,userAccount,network,enterprise,organization,business);
    }

   

    
    
}
