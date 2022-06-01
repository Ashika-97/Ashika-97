package taxiRun;

import java.util.Scanner;

import taxiCache.TaxiCache;
import taxiPojo.CustomerPojo;

public class TaxiRun {
	static TaxiCallLogic cache=new TaxiCallLogic();
	static Scanner scan=new Scanner(System.in);
	
	
	public void methodCall()
	{
		System.out.println("1-Customer booking for taxi");
		System.out.println();
		System.out.println("2-cancel taxi ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		
       System.out.println("Enter a number to run the loop ");
       int n=scan.nextInt();
		scan.nextLine();
		cache.addDummyCustomer();
		
		
		switch(n)
		{
		case 1:cache.customerBookingTaxi();
			break;
	
		}
	
	}

}
