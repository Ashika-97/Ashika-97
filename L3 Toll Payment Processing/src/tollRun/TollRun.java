package tollRun;

import java.util.Scanner;

import tollCache.CacheCall;
import tollPojo.CustomException;
import tollPojo.VehicleTicket;

public class TollRun {

	
	static CacheCall call=new CacheCall();
	static Scanner scan=new Scanner(System.in);
	
	
	
	public void addDetails()
	{
		VehicleTicket ticket=new VehicleTicket();
		System.out.println("Are you a vip user");
		String vipuser=scan.nextLine();
		System.out.println("Enter the vehicle type");
		String vehicleType=scan.nextLine();
		ticket.setVehicleType(vehicleType);
		try {
			checkVehicle(vehicleType,vipuser);
		}
		catch (CustomException e)
		{
		      System.out.println("The loop in  adddetails ");
		}
		System.out.println("Enter the amount");
		double amount=scan.nextDouble();
		ticket.setAmount(amount);
		System.out.println("Enter the vehcile number");
		int vehicleNumber=scan.nextInt();
		scan.nextLine();
		ticket.setVehicleNumber(vehicleNumber);
		System.out.println("Enter the toll name");
		String name=scan.nextLine();
		ticket.setTollName(name);
		System.out.println("Starting place is ?");
		String start=scan.nextLine();
		ticket.setStart(start);
		System.out.println("Destination place is ?");
		String destination=scan.nextLine();
		ticket.setDestiantion(destination);
		System.out.println("Type of return single/return");
		String  returnType=scan.nextLine();
		ticket.setTollReturn(returnType);
		
		try {
			call.addTollTicket(ticket, vipuser);
		}
		catch(CustomException exception)
		{
			System.out.println("The loop is in add "+ exception.getMessage());
		}
		
		
	}
	
	public void checkVehicle(String vehicleType,String user) throws CustomException
	{
		if(user.equals("yes"))
		{
			call.getVipUser(vehicleType);
		}
		else {
			call.getVehcielTypeUser(vehicleType);
		}
	}
	
	public void getTicketEvident()
	{
		System.out.println("Enter the toll name ");
		String name=scan.nextLine();
		System.out.println("Enter the ticket number");
		int number=scan.nextInt();
		scan.nextLine();
		try {
			String val=call.getTollTicket(number, name);
			System.out.println(val);
		}
		catch(CustomException exception)
		{
			System.out.println("The loop is in "+ exception.getMessage());
		}
	}
	public void getReturnTicket()
	{
		System.out.println("Enter your toll name");
		String name=scan.nextLine();
		System.out.println("Enter the ticket number");
		int ticketNumber=scan.nextInt();
		System.out.println("Enter the vehicle Number ");
		int vehicleNumber=scan.nextInt();
		scan.nextLine();
		try {
			call.returnTicket(ticketNumber, name);
			System.out.println("Enter the amount ");
			double amount=scan.nextDouble();
			call.totalAmount(ticketNumber, vehicleNumber, amount);
		}
		catch(CustomException custom)
		{
			System.out.println("The loop is in get Ticket "+ custom.getLocalizedMessage());
		}
	}
	
	/*
	 * public void allDetailsVehicle() { try {
	 * 
	 * System.out.println(call.allVehicleDetailsShow());
	 * 
	 * } catch(CustomException exception) {
	 * System.out.println("The loop is in all details "+ exception.getMessage()); }
	 * }
	 */
	
	/*
	 * public void vehcileType() { System.out.println("Enter the vechile type ");
	 * String vehicleType=scan.nextLine(); try {
	 * 
	 * 
	 * System.out.println(call.detailsOfCustomVehicle(vehicleType));
	 * 
	 * } catch(CustomException exception) { System.out.println("The loop is in "+
	 * exception.getMessage()); } }
	 */
	
	public void allDetails()
	{
		try {
			System.out.println(call.allDetails());
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage()+" the loop is in alldetails ");
		}
	}
	
	public void allVehicleType()
	{
		
		try {
			System.out.println(call.returnAllPassing());
		}
		catch(CustomException exception)
		{
			System.out.println("The loop is in "+ exception.getMessage());
		}
				
	}
	public void totalPassing()
	{
		try {
			call.totalAmountDetails();
		}
		catch(CustomException exception)
		{
			System.out.println("The loop is in "+ exception.getMessage());
		}
	}
	
	public void allOptions()
	{
		System.out.println();
		System.out.println("1-check the options");
		System.out.println();
		System.out.println("2-add vehicle");
		System.out.println();
		System.out.println("3- get the ticket ");
		System.out.println();
		System.out.println("4-return ticket process");
		System.out.println();
		System.out.println("5-vehicleType details");
		System.out.println();
		System.out.println("6-All vehicle details ");
		System.out.println();
		System.out.println("7-all details show in list ");
		System.out.println();
		System.out.println("8-total Amounts receive ");
		System.out.println();
		
	}
	
	public static void main(String[] args)
	{
		TollRun run=new TollRun();
	
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("Enter the number to proceed the process ");
			int n=scan.nextInt();
			scan.nextLine();
			switch(n)
			{
			    case 1:run.allOptions();
			    break;
				case 2:run.addDetails();
				break;
				
				case 3:run.getTicketEvident();
				break;
				
				case 4:run.getReturnTicket();
				break;
				
				case 5:run.allVehicleType();
				break;
				
			/*
			 * case 6: run.allDetailsVehicle(); break;
			 */
				
				case 6:run.allDetails();
				break;
				
				case 7: run.totalPassing();
				break;
				case 8:flag=false;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
