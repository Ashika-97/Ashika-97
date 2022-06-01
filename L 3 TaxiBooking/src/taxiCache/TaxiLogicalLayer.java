package taxiCache;

import taxiPojo.CustomException;
import taxiPojo.CustomerPojo;

public class TaxiLogicalLayer {
	TaxiCache taxi=new TaxiCache();
	
	
	
	public CustomerPojo customerBookingTaxi(CustomerPojo custom) throws CustomException
	{
		return taxi.bookTaxi(custom);
	}
	public boolean taxiDrop(double amountgiven,int customerId) throws CustomException
	{
		return taxi.customerExits(amountgiven, customerId);
	}
	
	public int showTimeForCustomer(char pickup,char drop) throws CustomException
	{
		return taxi.calculateDistance(pickup, drop);
	}
	
	public int balanceAmount(int time,long amount) throws CustomException
	{
		return taxi.balanceAmount(time, amount);
	}
	
	public int showAvailableTAxi(char pick) throws CustomException
	{
		return taxi.showAvailableTaxi(pick);
	}
}
