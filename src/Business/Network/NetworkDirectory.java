/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;

import java.util.ArrayList;

/**
 *
 * @author yufeng
 */
public class NetworkDirectory {
    private ArrayList<Network> networkList;
    public NetworkDirectory(){
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    public Network addNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }
}
