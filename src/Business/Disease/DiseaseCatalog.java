/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Disease;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class DiseaseCatalog {
    private ArrayList<Disease> diseaseList;
    public DiseaseCatalog(){
        diseaseList = new ArrayList<>();
    }

    public ArrayList<Disease> getDiseaseList() {
        return diseaseList;
    }
    
    public Disease addDisease(){
        Disease disease = new Disease();
        diseaseList.add(disease);
        return disease;
    }
    public void deleteDisease(Disease disease){
        diseaseList.remove(disease);
    }
}
