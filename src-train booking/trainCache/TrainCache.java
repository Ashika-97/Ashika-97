package trainCache;

import java.util.*;

import trainPojo.CustomException;
import trainPojo.PassengerPojo;
import trainPojo.TicketPojo;

public class TrainCache {


	static Map<Integer,ArrayList<TicketPojo>> bookTicketMap=new HashMap<>();//ticketBooking
	static ArrayList<TicketPojo> racList= new ArrayList<>();//rac seats
	static ArrayList<TicketPojo> waitList=new ArrayList<>();//waitingList
	static Map<Integer,ArrayList<PassengerPojo>> passengerMap=new HashMap<>();//passenger
	int bookTicket=0,seatNumber=0;

	int[] lowerBerth= {0,1,4,9,12,17,20,25,28,33,36,41,44,49,52,57,60,65,68};
    int[] middle= {0,2,5,10,13,18,21,26,29,34,37,42,45,50,53,58,61,66,69};
    int[] upper= {0,3,6,11,14,19,22,27,30,35,38,43,46,51,54,59,62,67,70};
	int[] side= {0,7,8,15,16,23,24,31,32,39,40,47,48,55,56,63,64,71,72};
    int bookingLimit=0,racLimit=0,waitLimit=0;
    
    public void setSeatLimit(int bookTicket,int racTicket,int waitTicket) throws CustomException
    {
    	bookingLimit=bookTicket;
    	racLimit=racTicket;
    	waitLimit=waitTicket;
    	
    }
    
    
	public int ticketAutoGenerate()
	{
		return ++bookTicket;
	}
	public int seatAutoGenerate()
	{
		return ++seatNumber;
	}
	
    public String calculateDaysYear() throws CustomException
    {

		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int date=cal.get(Calendar.DATE);
		//int day=cal.get(Calendar.DAY_OF_MONTH);
		String res= date+"/"+month +"/"+ year;
	
		return res;	
    }
    

    public int lowerBerthAllocate(int seatsLower) throws CustomException
    {
    	//String seats=""+seatsLower;
    	for(int i=seatsLower;i<=1;i++)
    	{
    		
    			lowerBerth[i]=0;
    			}
    	ArrayList<Integer> list=new ArrayList<>();
    	for(int i=1;i<lowerBerth.length;i++)
    	{
    	
    	if(lowerBerth[i] != 0)
    	{
    		list.add(lowerBerth[i]);
    		
    		}
    	 
         }
    	return list.size();
    	}

    public int MiddleBerthAllocate(int seatsLower) throws CustomException
    {
    	//String seats=""+seatsLower;
    	for(int i=seatsLower;i<=1;i++)
    	{
    		
    			lowerBerth[i]=0;
    			}
    		ArrayList<Integer> list=new ArrayList<>();
    	for(int i=1;i<lowerBerth.length;i++)
    	{
    	
    	if(lowerBerth[i] != 0)
    	{
    		list.add(lowerBerth[i]);
    		   		}
    	 
         }
    	return list.size();
    	}

    public int upperBerthAllocate(int seatsLower) throws CustomException
    {
    	//String seats=""+seatsLower;
    	for(int i=seatsLower;i<=1;i++)
    	{
    		
    			lowerBerth[i]=0;
    			}
    	ArrayList<Integer> list=new ArrayList<>();
    	for(int i=1;i<lowerBerth.length;i++)
    	{
    	
    	if(lowerBerth[i] != 0)
    	{
    		list.add(lowerBerth[i]);
    		
    		}
    	 
         }
    	return list.size();
    	}
    public int sideBerthAllocate(int seatsLower) throws CustomException
    {
    	//String seats=""+seatsLower;
    	for(int i=seatsLower;i<=1;i++)
    	{
    		
    			lowerBerth[i]=0;
    			}
    	ArrayList<Integer> list=new ArrayList<>();
    	for(int i=1;i<lowerBerth.length;i++)
    	{
    	
    	if(lowerBerth[i] != 0)
    	{
    		list.add(lowerBerth[i]);
    		
    		}
    	 
         }
    	return list.size();
    }
    
    public ArrayList<TicketPojo> bookTrain(ArrayList<PassengerPojo> passenger) throws CustomException
    {
    	if(passenger.size() == 0)
    	{
    		throw new CustomException("Passenger details are empty");
    	}
    	
    	int ticket=0;
    	
    	int seatNumber=0;
    	
   
    	if(seatNumber > bookingLimit)
    	{
    		throw new CustomException("All seats are booked");
    	}
    	
    
    	ArrayList<TicketPojo> mapSeat=new ArrayList<>();
    	PassengerPojo pojo=null;
    	 TicketPojo tick=null;
    	for(int i=0;i< passenger.size();i++)
    	{
    	ticket=	ticketAutoGenerate();
        seatNumber=seatAutoGenerate();
    	pojo=new PassengerPojo();
        tick=new TicketPojo();
    	String typeSeat=calculateDaysYear();
    	pojo=passenger.get(i);
    	tick.setAmountPaid("paid");
    	tick.setPassengerName(pojo.getPassengerName());
    	tick.setSeatNumber(seatNumber);
    	tick.setSeatType(pojo.getSeatTypes());
    	tick.setTicketNumber(ticket);
    	tick.setDateOfJourney(typeSeat);
    	tick.setTrainName(pojo.getTrainName());
    	tick.setTrainNumber(pojo.getTrainNumber());
    	//tick.setDateOfJourney(pojo.getDate());
    	tick.setTimeofTrain(15.45);
    	tick.setTicketConfirmation(true);
    	mapSeat.add(tick);
          }   
    	bookTicketMap.put(ticket,mapSeat);
    	if(mapSeat.size() > bookingLimit && seatNumber > bookingLimit)
    	{
    		tick.setSeatType("sideberth");
    		racList.add(tick);
    		if(racList.size() > racLimit)
    		{
    			waitList.add(tick);
    			if(waitList.size() > waitLimit )
    			{
    				throw new CustomException("Wait list is filled ");
    			}
    		}
    	}
    	
    	return bookTicketMap.get(ticket);
    }
    
    public String cancelTicket(int seatNum,int ticketNum) throws CustomException
    {
    	
    	if(bookTicketMap == null || !bookTicketMap.containsKey(ticketNum))
    	{
    		throw new CustomException("Invalid ticket number,please check it.");
    	}
    	ArrayList<TicketPojo> ticketList=bookTicketMap.get(ticketNum);
    	for(int i=0;i< ticketList.size();i++)
    	{
    		TicketPojo tick=ticketList.get(i);
    		if(seatNum == tick.getSeatNumber())
    		{
    			ticketList.remove(i);
    			racMovement(seatNum);
    		}
    		bookTicketMap.put(ticketNum, ticketList);
    		
    	}
       return "your ticket"+ticketNum+"seat number is  "+ seatNum +" has cancelled successfully";	
    }	
  
    public void racMovement( int seatNum) throws CustomException
    {
    	if(racList == null)
    	{
    		throw new CustomException("RAC list is empty ");
    	}
    	TicketPojo tick1=racList.get(0);
    	tick1.setSeatNumber(seatNum);
		ArrayList<TicketPojo> list1=new ArrayList<>();
		list1.add(tick1);
		int ticketNum=ticketAutoGenerate();
		bookTicketMap.put(ticketNum,list1);
		waitListMovement();
		
		//return "your ticket is confirmed,and your ticket Number is "+ ticketNum + "seatNumber is "+ seatNum; 
    }
    
    public void waitListMovement() throws CustomException
    {
    	  
        if(waitList.size() > waitLimit)
        {
        	throw new CustomException("waiting list is full ");
        }
    
    	racList.add(waitList.get(0));
    	
    	//return "your ticket is in Rac ";
  
    }
    
    public String seatNumberConfirmationSeek(int ticketNum,int seat) throws CustomException
    {
    	if(!bookTicketMap.containsKey(ticketNum))
    	{
    		throw new CustomException("ticketNumber is not in the list ");
    	}
    	String varBook="";
    	ArrayList<TicketPojo> list=bookTicketMap.get(ticketNum);
    	if(list == null)
    	{
    		return " Details are empty ";
    	}
    	
    	for(int i=0;i< list.size();i++)
    	{
    		TicketPojo tickPojo=list.get(i);
    		if(tickPojo.getSeatNumber() == seat)
    		{
    			varBook="your ticket number is "+ticketNum +  " seat is "+ tickPojo.isTicketConfirmation()+
    					" and your seat is "+seat +"seat type is "+ tickPojo.getSeatType() ;
    		}
    		else {
    			varBook=racSeek(ticketNum);
    		}
    	}
    	return varBook;
    	
    	
    	
    }
    
    public String racSeek(int ticketNum) throws CustomException
    {
    	if(racList == null)
    	{
    		throw new CustomException("RAC list is empty");
    	}
    	String varResult="";
    	for(int i=0;i< racList.size();i++)
    	{
    	TicketPojo racPojo=racList.get(i);
    	 if(!racList.contains(racPojo.getTicketNumber()) || racPojo.getTicketNumber()!= ticketNum)
    	 {
    			throw new CustomException("sorry, your ticket is not in rac list");
    		}
    	if(racPojo.getTicketNumber() == ticketNum)
    	{
    		varResult="Your ticket is in RAC(Reservetion Against Cancellation) "+ racPojo.getTicketNumber() +
    				"your seat Type is "+racPojo.getSeatType()+"and your seat is "+racPojo.getSeatNumber() ;
    	}
    	else {
    		varResult=waitListSeek(ticketNum);
    	}
    	}
    	return varResult;
    }
    	public String waitListSeek(int ticketNum) throws CustomException
    	{
    		if(waitList == null)
    		{
    			throw new CustomException("wait list is empty");
    		}
    		String varWait="";
    		for(int i=0;i< waitList.size();i++)
    		{
    		 TicketPojo waitPojo=waitList.get(i);
    		 if(!waitList.contains(waitPojo.getTicketNumber()) && waitPojo.getTicketNumber() != ticketNum)
    		 {
    			 throw new CustomException("ticket number is not in the wait list");
    		 }
    		 if(waitPojo.getTicketNumber() == ticketNum)
    		 {
    			 varWait="your Ticket number is in waitlist "+ticketNum;
    		 }
    		 else {
    			 varWait="your ticket is not in the wait list ";
    		 }
    		}
    		return varWait;
    		
    	}
//    public String addRac(PassengerPojo pojo) throws CustomException
//    {
//    	TicketPojo ticket=new TicketPojo();
//    	if(pojo.getAmount() == 750)
//    	{
//    	ticket.setAmountPaid("paid");
//    	}
//    	ticket.setPassengerName(pojo.getPassengerName());
//    	ticket.setDateOfJourney(pojo.getDate());
//    	ticket.setSeatType("side berth");
//    	ticket.setTrainName(pojo.getTrainName());
//    	ticket.setTrainNumber(pojo.getTrainNumber());
//    	ticket.setTimeofTrain(15.45);
//    	ticket.setTicketConfirmation(true);
//    	ticket.setTicketNumber(seatNumber);
//    }
//    
    
    /*	public void showAvailabelLowerBerth() throws CustomException
	{
		System.out.println("we have available number of seats in lower berth are "+ Arrays.toString(lowerBerth));
	}*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
