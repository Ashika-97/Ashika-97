package tarincache;

import java.util.ArrayList;

import trainpojo.*;


public class TrainLogicalLayer {


	static TrainCache intermediate=new TrainCache();
	
	public void setSeats(int bookingTicket,int racTicket,int waitingTicket) throws CustomException
	{
		intermediate.setSeatLimit(bookingTicket, racTicket, waitingTicket);
	}
	
	public int lowerBerthSeats(int seat) throws CustomException
	{
		return intermediate.lowerBerthAllocate(seat);
	}
	public int middleBerthSeats(int seat) throws CustomException
	{
		return intermediate.lowerBerthAllocate(seat);
	}
	public int upperBerthSeats(int seat) throws CustomException
	{
		return intermediate.lowerBerthAllocate(seat);
	}
	public int sideBerthSeats(int seat) throws CustomException
	{
		return intermediate.lowerBerthAllocate(seat);
	}
	public ArrayList<TicketPojo> bookTrainTicketNumber(ArrayList<PassengerPojo> pojo) throws CustomException
	{
		return intermediate.bookTrain(pojo);
	}
	public String cancelTicketSeat(int ticketNumber,int seatNumber) throws CustomException
	{
		return intermediate.cancelTicket(seatNumber, ticketNumber);
	}
	
	public String racMovementseeking(int seat) throws CustomException
	{
	  return intermediate.racSeek(seat);
	}
	public String waitSeek(int seat) throws CustomException
	{
		return intermediate.waitListSeek(seat);
	}
	public String bookedTicketSeek(int ticket,int seat) throws CustomException
	{
		return intermediate.seatNumberConfirmationSeek(ticket, seat);
	}
}