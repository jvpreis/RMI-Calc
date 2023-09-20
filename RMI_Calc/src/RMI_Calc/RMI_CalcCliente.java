package RMI_Calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMI_CalcCliente {

	private static Scanner scan=null;
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		try {
			RMI_Calc_Interface CalcApi = (RMI_Calc_Interface) Naming.lookup("rmi://localhost:7777/Calc");
			
			scan=new Scanner(System.in);
			for(;;) {
				System.out.println(".....................................");
				System.out.println(" RMI application for calculate areas");
				System.out.println(".....................................");
				System.out.println();
				System.out.println("Option?");
				System.out.println("1 - Area of Circle");
				System.out.println("2 - Area of Triangle");
				System.out.println("3 - Area of Square");
				System.out.println("4 - Exit");
				
				int choice=getChoice();
				if (choice==1){
					System.out.println(CalcApi.getCircle(getInput()));
				}
				else if (choice==2){
					System.out.println(CalcApi.getTriangle(getInput(), getInput()));
				}
				else if (choice==3){
					System.out.println(CalcApi.getSquare(getInput()));
				}
				else {
					System.out.println("Exit success");
					System.exit(0);
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("ERROR: Client RMI_Calc is not running ...");
			e.printStackTrace();
		}

	}
	/**
     * Read choice (option) between 1 and 3 
     * @return choice - option insert by the user
     */
	public static int getChoice() {
		try {
			System.out.println("Enter choice:");
			int input =scan.nextInt();
			if(input<1 || input>4) throw new Exception();
			return input;			
		} catch (Exception e) {
			System.err.println("ERROR: Please input a number from 1 to 4.");
			return getChoice();
		}
	}
	
	/**
     * Get the number between 1 and 3 
     * @return the number insert by the user
     */
	public static double getInput() {
		try {
			System.out.println("Enter a number ");
			double input =scan.nextDouble();
			return input;
		} catch (Exception e) {
			System.err.println("ERROR: Please type a valid number.");
			return getInput();
		}
	}

}
