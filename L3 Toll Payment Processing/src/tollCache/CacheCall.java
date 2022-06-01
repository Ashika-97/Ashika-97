package tollCache;

import java.util.List;
import java.util.Map;

import tollPojo.CustomException;
import tollPojo.TollTicket;
import tollPojo.VehicleTicket;

public class CacheCall {
	
	static TollCache toll=new TollCache();
	
	public void getVehcielTypeUser(String user) throws CustomException
	{
		toll.setKilometreDistanceAmount(user);
	}
	public void getVipUser(String user) throws CustomException
	{
		toll.vipUser(user);
	}
	
	public void addTollTicket(VehicleTicket vehicle,String vipUser) throws CustomException
	{
		toll.addTicketDetails(vehicle,vipUser);
	}
	
	public String getTollTicket(int ticketNumber,String tollNumber) throws CustomException
	{
	   return toll.ticketGet(tollNumber, ticketNumber);
	}
	
	public String returnTicket(int ticketNumber,String tollName) throws CustomException
	{
		return toll.returnTollticket(ticketNumber, tollName);
	}
	
    public void totalAmount(int ticketNumber,int tollName,double amount) throws CustomException
    {
    	toll.setTollAmountReturn(ticketNumber, tollName, amount);
    }

	/*
	 * public Map<Integer, Map<String, List<TollTicket>>> allVehicleDetailsShow()
	 * throws CustomException { return toll.detailsShowing(); }
	 */
	/*
	 * public String detailsOfCustomVehicle(String vehcile) throws CustomException {
	 * 
	 * return toll.detailsOfVehicles(vehcile); }
	 */
    
    public Map<Integer,List<TollTicket>> allDetails()throws CustomException
    {
    	return toll.detailsOfAll();
    }
    
    public Map<Integer, List<TollTicket>> returnAllPassing() throws CustomException
    {
    	return toll.detailsOfVehicleType();
    }
    
    public void totalAmountDetails() throws CustomException
    {
    	 toll.totalNumberOfAmountPassing();
    }    
    
    
}
