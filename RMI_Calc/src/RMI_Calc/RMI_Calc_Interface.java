package RMI_Calc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_Calc_Interface extends Remote {
	public double getCircle (double radius) throws RemoteException;
	public double getTriangle (double base, double height) throws RemoteException;
	public double getSquare (double side) throws RemoteException;
}
