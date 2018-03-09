/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaocalculadora;

import java.rmi.Remote;

/**
 *
 * @author Carlos
 */
public interface ServerInterface extends Remote {

    public String sayHello() throws java.rmi.RemoteException;

    public void registerClient(ClientInterface callbackClientObject) throws java.rmi.RemoteException;
    
    public String Calculate(String pt1, String pt2, String op) throws java.rmi.RemoteException;

}
