package trainrun;

import java.util.ArrayList;
import java.util.Scanner;

import tarincache.TrainLogicalLayer;
import trainpojo.*;

public class TrainRun {

	static TrainLogicalLayer layer=new TrainLogicalLayer();
    static Scanner scan=new Scanner(System.in);
    int bookingLimit=0,racLimit=0,waitLimit=0;
    
    
    public void dummyValuesForTrain() throws CustomException
    {
    	TicketPojo train=new TicketPojo();
//    	train.setTrainName("RMM Express");
//    	train.setCompartmentNumber(5);
//        train.setFromPlace("chennai");
//        train.setToPlace("Rameshwaram");
//        train.setSeatNumber(10);
//        train.setSumOfAmount(750);
//        train.setTrainNumber(35107);
//        train.setTotalAvailableSeats(train.getCompartmentNumber()*train.getSeatNumber());
//        
//    
    
    
    
    
    
    }
    public void setNumberOfSeats()
    {
    	System.out.println("Enter the number of booking tickets ");
    	int bookingTicket=scan.nextInt();
    	bookingLimit=bookingTicket;
    	System.out.println("Enter the number of rac tickets ");
    	int racTicket=scan.nextInt();
    	racLimit=racTicket;
    	System.out.println("Enter the waiting list tickets ");
    	int wait=scan.nextInt();
    	waitLimit=wait;
    	scan.nextLine();
    	try {
    		layer.setSeats(bookingTicket, racTicket, wait);
    	}
    	catch(CustomException exception)
    	{
    		System.out.println(exception.getMessage());
    	}
    }
    
    public void addTrainBooking()
    {
    	String seatAllocate="";
    	
    	System.out.println("How many passengers to add");
    	int n=scan.nextInt();
    	scan.nextLine();
    	ArrayList<PassengerPojo> list=new ArrayList<>();
    	for(int i=0;i<n;i++)
    	{
    	PassengerPojo pass=new PassengerPojo();
    	System.out.println("Enter your name ");
    	String name=scan.nextLine();
    	pass.setPassengerName(name);
    	System.out.println("Enter you age ");
        int age=scan.nextInt();
    	pass.setAge(age);
    	pass.setAmount(750);
    	scan.nextLine();
    	System.out.println("Enter your gender");
    	String gender=scan.nextLine();
    	pass.setGender(gender);
    	System.out.println("Enter the starting place");
    	String fromPlace=scan.nextLine();
    	pass.setFromPlace(fromPlace);
    	System.out.println("Enter the ending place ");
    	String toPlace=scan.nextLine();
    	pass.setToPlace(toPlace);
    	System.out.println("Enter the respective berth preference types upper,lowerberth,middle");
    	String seats=scan.nextLine();
    	seatAllocate=setBerthTypes(seats);
    	pass.setSeatTypes(seatAllocate);
    	System.out.println("Enter the train number ");
    	int trainNumber=scan.nextInt();
    	pass.setTrainNumber(trainNumber);
    	scan.nextLine();
    	System.out.println("Enter the train name ");
    	String trainName=scan.nextLine();
    	pass.setTrainName(trainName);
    	list.add(pass);
    	}
    
		try {
			
			System.out.println(layer.bookTrainTicketNumber(list));
		}
		catch(CustomException custom)
		{
			System.out.println("The exception in  add train booking");
		}
    	
    	
    }
    
    int count=0,count1=0;
    public String setBerthTypes(String seatType)
    {
    	String seatSet="";
        int number=0;
    	try {
    	if(seatType.equals("lowerberth"))
    	{
    		number=layer.lowerBerthSeats(1);
    		
    		if(number > 1 && count < bookingLimit)
    		{
    			count++;
    			seatSet="lowerberth";
    			return seatSet;
    		}
    		else if(count >= bookingLimit && count1 < racLimit)
    		{
    			number=layer.sideBerthSeats(1);
        		if(number > 1 && count1 < racLimit)
        		{
        			count1++;
        			seatSet="sideberth";
        			return seatSet;
        		}
    		}
    	}
    	else if(seatType.equals("middle"))
    	{
    		number=layer.middleBerthSeats(1);
    		
    		if(number > 1 && count < bookingLimit)
    		{
    			count++;
    			seatSet="middle";
    			return seatSet;
    		}
    		else if(count >= bookingLimit)
    		{
    			number=layer.sideBerthSeats(1);
        		if(number > 1 && count1 < racLimit)
        		{
        			count1++;
        			seatSet="sideberth";
        			return seatSet;
        		}
    		}
    	}
    	else if (seatType.equals("upper"))
    	{
    		number=layer.upperBerthSeats(1);
    	
    		if(number > 1 && count < bookingLimit)
    		{
    			count++;
    			seatSet="upper";
    			return seatSet;
    		}
    		else if(count >= bookingLimit)
    		{
    			number=layer.sideBerthSeats(1);
        		if(number > 1 && count1 < racLimit)
        		{
        			count1++;
        			seatSet="sideberth";
        			return seatSet;
        		}
    		}
    	}
    	
    	}
    	catch(CustomException exception)
    	{
    		System.out.println("The error in seat type booking "+ exception.getMessage());
    	}
    	return "waiting list";
    }
    
    
    
    
    
    
//    public void printLowerDetails()
//    {
//    	try {
//    		layer.showAvailableBerth();
//    	}
//    	catch(CustomException exception)
//    	{
//    		System.out.println("The Exception in availabelberthdetails");
//    	}
//    }
    
    public void cancelTicket()
    {
    	System.out.println("Enter your ticket number");
    	int ticket=scan.nextInt();
    	System.out.println("Enter you seat number");
    	int seat=scan.nextInt();
    	try {
    		System.out.println(layer.cancelTicketSeat(ticket, seat));
    	}
    	catch(CustomException exception)
    	{
    		System.out.println("the cancel ticket "+exception.getMessage());
    	}
    }
    public void ticketInfoSeek()
    {
    	System.out.println("Enter the ticket number");
    	int ticketNum=scan.nextInt();
    	System.out.println("Enter your seat number");
    	int seatNumber=scan.nextInt();
    	
    	try {
    		System.out.println(layer.bookedTicketSeek(ticketNum, seatNumber));
    	}
    	catch(CustomException exception)
    	{
    		System.out.println("the ticket in message ticket Info seek "+exception.getMessage());
    	}
    }
    
    public void infoMethodDetails()
    {
    	System.out.println("1-Check options");
    	System.out.println();
    	System.out.println("2-Book tickets in train");
    	System.out.println();
    	System.out.println("3-Get your ticket details ");
    	System.out.println();
    	System.out.println("4-Cancel your ticket");
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args)
    {
    	TrainRun run=new TrainRun();
    	boolean flag=true;
    	run.setNumberOfSeats();
    	while(flag) 
    	{
    	System.out.println("Enter the number ");
       	int n=scan.nextInt();
       	scan.nextLine();
    	switch(n)
    	{
    	case 1:run.infoMethodDetails();
    	break;
    	case 2:run.addTrainBooking();
    	break;
    	case 3:run.ticketInfoSeek();
    	break;
    	case 4:run.cancelTicket();
    	break;
    	case 5:flag=false;
    	break;
    	}
    	}
    	
    	
    	
    	
    	
    }	
   
    
}