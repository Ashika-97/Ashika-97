package taxiRun;

import java.util.Scanner;

import taxiCache.TaxiLogicalLayer;
import taxiPojo.CustomException;
import taxiPojo.CustomerPojo;

public class TaxiCallLogic {
	TaxiLogicalLayer logic=new TaxiLogicalLayer();
	Scanner scan=new Scanner(System.in);
	
	public void addDummyCustomer()
	{
		CustomerPojo custom=new CustomerPojo();
		custom.setPickup('C');
		custom.setDrop('A');
		custom.setCustomerId(2);
		//custom.setTaxiNumber(1209);
		custom.setAmount(100);
		try {
		int time=logic.showTimeForCustomer('C', 'A');
			custom.setTime(time);
			System.out.println(logic.customerBookingTaxi(custom));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		
		CustomerPojo custom1=new CustomerPojo();
		custom1.setPickup('B');
		custom1.setDrop('A');
		custom1.setCustomerId(3);
		//custom.setTaxiNumber(1209);
		custom1.setAmount(100);
		try {
		int time=logic.showTimeForCustomer('A', 'B');
			custom1.setTime(time);
			System.out.println(logic.customerBookingTaxi(custom1));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		
		CustomerPojo custom2=new CustomerPojo();
		custom2.setPickup('D');
		custom2.setDrop('A');
		custom2.setCustomerId(4);
		//custom.setTaxiNumber(1209);
		custom2.setAmount(100);
		try {
		int time=logic.showTimeForCustomer('D', 'A');
			custom2.setTime(time);
			System.out.println(logic.customerBookingTaxi(custom2));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		CustomerPojo custom3=new CustomerPojo();
		custom3.setPickup('F');
		custom3.setDrop('A');
		custom3.setCustomerId(5);
		//custom.setTaxiNumber(1209);
		custom3.setAmount(100);
		try {
		int time=logic.showTimeForCustomer('F', 'A');
		custom3.setTime(time);
//		int totalAmount=logic.balanceAmount(time, custom3.getAmount());
//		System.out.println("kidly give the balance Amount rs."+ totalAmount);
//		int amountgiven=scan.nextInt();
//		while(amountgiven !=totalAmount)
//		{
//			 System.out.println("kidly give the balance Amount rs."+ totalAmount);
//			 amountgiven=scan.nextInt();
//		}
			System.out.println(logic.customerBookingTaxi(custom3));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	
	
	
	
	public void customerBookingTaxi()
	{
		CustomerPojo custom=new CustomerPojo();
		System.out.println("Enter the pickup point");
		char ch=scan.next().charAt(0);
		custom.setPickup(ch);
		System.out.println("Enter the drop point");
		char ch1=scan.next().charAt(0);
		custom.setDrop(ch1);
		
		
		try {
		  int taxiAvailable=logic.showAvailableTAxi(ch);	
		  System.out.println("Available taxi are "+ taxiAvailable);
		  if(taxiAvailable!=0)
		  {
		  int time=logic.showTimeForCustomer(ch, ch1);
		  System.out.println("the respective time is "+ time +" hr");
		scan.nextLine();
		System.out.println("if you want to further proceed ");
		String confirm=scan.nextLine();
		if(confirm.equals("yes"))
		{
			System.out.println("Enter your customerId");
			int id=scan.nextInt();
			custom.setCustomerId(id);
	        System.out.println("Enter the initial Amount rs.100");
	        int amount=scan.nextInt();
	        while(amount != 100)
	        {
	        	 System.out.println("Enter the initial Amount rs.100");
	  	         amount=scan.nextInt();
	        	
	        }
	        custom.setAmount(amount);
	        
	       System.out.println(logic.customerBookingTaxi(custom));
	       double amountTaxi=custom.getAmount();
	  // 	int totalAmount=logic.balanceAmount(time, custom.getAmount());
		System.out.println("kidly give the balance Amount rs."+ amountTaxi);
		double amountgiven=scan.nextDouble();
		while(amountgiven !=amountTaxi)
		{
			System.out.println("kidly give the balance Amount rs."+ amountTaxi);
			 amountgiven=scan.nextInt();
		}
		custom.setAmount((int)amountgiven);
		boolean flag=logic.taxiDrop(amountgiven, id);
		System.out.println(flag);
	    }
		}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
