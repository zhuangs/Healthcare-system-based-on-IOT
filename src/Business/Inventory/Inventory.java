/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Inventory;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class Inventory {
    private ArrayList<InventoryItem> inventoryItemList;
   
    
    public Inventory(){
        inventoryItemList = new ArrayList<>();
    }

    public ArrayList<InventoryItem> getInventoryItemList() {
        return inventoryItemList;
    }

    public void setInventoryItemList(ArrayList<InventoryItem> inventoryItemList) {
        this.inventoryItemList = inventoryItemList;
    }

   

   
    
}
