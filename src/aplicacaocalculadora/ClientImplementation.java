/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaocalculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
public class ClientImplementation extends UnicastRemoteObject implements ClientInterface {
	
   public ClientImplementation() throws RemoteException {
      super( );
   }

   public String notifyMe(String message){
      String returnMessage = "Call back received: " + message;
      System.out.println(returnMessage);
      return returnMessage;
   }      

    @Override
    public String recebeResultado(String resultado) throws RemoteException {
        return resultado;
    }
  
   
}