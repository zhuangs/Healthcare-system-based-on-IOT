/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Manufactrurer;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class ManufacturerDirectory {
    private ArrayList<Manufacturer> manufacturerList;
    
    public ManufacturerDirectory(){
        manufacturerList = new ArrayList<>();
    }

    public ArrayList<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }
    
    public Manufacturer addManufacturer(){
        Manufacturer manufacturer = new Manufacturer();
        manufacturerList.add(manufacturer);
        return manufacturer;
    }
    
}
