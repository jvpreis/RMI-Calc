package RMI_Calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class RMI_CalcServer extends UnicastRemoteObject implements RMI_Calc_Interface {

	/**
     * Methods for remote call em JAVA RMI
     */
	
	public RMI_CalcServer() throws RemoteException {
		super();
	}
	
	@Override
	public double getCircle(double radius) throws RemoteException {
		return Math.PI*(radius*radius);
	}

	@Override
	public double getTriangle(double base, double height) throws RemoteException {
		return (base*height)/2;
	}

	@Override
	public double getSquare(double side) throws RemoteException {
		return side*side;
	}

	public static void main(String[] args) throws RemoteException {
		try {
			Registry registry=LocateRegistry.createRegistry(7777);
			registry.bind("Calc", new RMI_CalcServer());
			System.out.println("RMI Server RMI_Calc is running and ready ...");
		} catch (Exception e) {
			System.out.println("ERROR: Server RMI_Calc is not running ...");
		}
		
	}

}
