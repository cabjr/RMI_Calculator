/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaocalculadora;

import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public interface ClientInterface extends java.rmi.Remote {

    public String recebeResultado(String resultado) throws RemoteException;

    public String notifyMe(String resultado) throws RemoteException;
}
