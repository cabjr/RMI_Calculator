/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaocalculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author Carlos
 */
public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
    
	private Vector clientList;

	public ServerImplementation() throws RemoteException {
		super();
		clientList = new Vector();
	}

	public String sayHello() throws java.rmi.RemoteException {
		return ("Conectado ao servidor.");
	}

	public synchronized void registerClient(ClientInterface callbackClientObject)
			throws java.rmi.RemoteException {
		// store the callback object into the vector
		if (!(clientList.contains(callbackClientObject))) {
			clientList.addElement(callbackClientObject);
			System.out.println("Novo cliente registrado! ");
			doCallbacks();
		} // end if
	}

	/*
	 * Este método remoto permite um objeto cliente cancelar o seu
	 * registro de retorno de chamada.
	 * 
	 * @param callbackClientObject é um objeto que implementa a interface
	 * CallbackClientInterface.
	 */
	public synchronized void unregisterForCallback(ClientInterface callbackClientObject)
			throws java.rmi.RemoteException {
		if (clientList.removeElement(callbackClientObject)) {
			System.out.println("Cliente desregistrado ");
		} else {
			System.out.println("Desregistro: o cliente não foi registrado.");
		}
	}

	private synchronized void doCallbacks() throws java.rmi.RemoteException {
		// Criar callback para cada cliente registrado
		System.out.println("**************************************\n" + "Iniciando callbacks ---");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.println("Fazendo o " + (i+1) + "º callback\n");
			// Converte o objeto do vetor em um objeto de callback
			ClientInterface nextClient = (ClientInterface) clientList.elementAt(i);
			// Invoca o método de callback
			nextClient.notifyMe("Número de clientes registrados="	+ clientList.size());
		}// end for
		System.out.println("********************************\n"
				+ "O servidor completou os callbacks ---");
	} // doCallbacks

    @Override
    public String Calculate(String pt1, String pt2, String op) throws RemoteException {
        int parte1 = Integer.parseInt(pt1);
        int parte2 = Integer.parseInt(pt2);
        int resultado = 0;
        switch(op){
            case "+":
                resultado = parte1 + parte2;
                break;
            case "-":
                resultado = parte1 - parte2;
                break;
            case "*":
                resultado = parte1 * parte2;
                break;
            case "/":
                resultado = parte1 / parte2;
                break;
        }
        return String.valueOf(resultado);
        
    }

}
