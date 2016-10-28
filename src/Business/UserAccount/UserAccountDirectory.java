/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.UserAccount;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory(){
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount addUserAccount(){
        UserAccount userAccount = new UserAccount();
        userAccountList.add(userAccount);
        return userAccount;
    }
    public UserAccount authenticateUser(String userName, String password){
        for(UserAccount userAccount : userAccountList){
            
                if(userAccount.getUserName().equals(userName)&& userAccount.getPassword().equals(password)){
                    return userAccount;
                }
            
        }
        return null;
    }
    
}
