/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Disease;

/**
 *
 * @author yufeng
 */
public class Disease {
    private static int count = 0;
    private int diseaseID;
    private String diseaseName;
    
    public Disease(){
        count++;
        diseaseID = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Disease.count = count;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public String toString() {
        return String.valueOf(diseaseID);
    }
    
}
