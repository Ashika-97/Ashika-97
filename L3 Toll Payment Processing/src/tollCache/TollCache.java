package tollCache;

import java.util.*;

import tollPojo.*;

public class TollCache {

	Map<Integer, List<TollTicket>> ticketMap = new HashMap<>();// ticket,tollname
	Map<Integer, List<VehicleTicket>> vehcileMap = new HashMap<>();// ticket,list
//	Map<String,List<TollTicket>> vehicleTypeDetail = new HashMap<>();// tollname,vehicleType
	int ticketGen = 0, tollNumber = 1800, numberOfPassing = 0, totalAmount = 0, numberPassing = 0;

	public int tollAutoGenerate() {
		return ++tollNumber;
	}

	public int ticketGenerate() {
		return ++ticketGen;
	}

	public void setKilometreDistanceAmount(String vehcileType) {
		switch (vehcileType) {
		case "car":
			System.out.println("Pay the amount rs.45");
			break;
		case "truck":
			System.out.println("pay the amount rs.135");
			break;
		case "bus":
			System.out.println("Pay the amount rs.135");
			break;
		case "minibus":
			System.out.println("Pay the amount rs.75");
			break;
		case "Jeep":
			System.out.println("Pay the amount rs.45");
			break;
		case "3-wheeler":
			System.out.println("Pay the amount rs.45");
			break;
		case "3-axlecommercial":
			System.out.println("Pay the amount rs.165");
			break;
		default:
			System.out.println("pay the amount rs.300");
			break;
		}
	}

	public void vipUser(String vehicle) {
		switch (vehicle) {
		case "car":
			System.out.println("Pay the amount rs.34");
			break;
		case "truck":
			System.out.println("pay the amount rs.100");
			break;
		case "bus":
			System.out.println("Pay the amount rs.100");
			break;
		case "minibus":
			System.out.println("Pay the amount rs.55");
			break;
		case "Jeep":
			System.out.println("Pay the amount rs.34");
			break;
		case "3-wheeler":
			System.out.println("Pay the amount rs.34");
			break;
		case "3-axlecommercial":
			System.out.println("Pay the amount rs.125");
			break;
		default:
			System.out.println("pay the amount rs.270");
			break;
		}
	}

	public void addTicketDetails(VehicleTicket customer, String vipuser) throws CustomException {
		
		Map<String, List<TollTicket>> newDet = new HashMap<>();
		List<TollTicket> list = new ArrayList<>();
		List<VehicleTicket> list1 = new ArrayList<>();

		TollTicket toll = new TollTicket();
		int ticket = ticketGenerate();
		toll.setTollNumber(customer.getTollReturn());
		toll.setTicketNumber(ticket);
		toll.setStart(customer.getStart());
		toll.setDestination(customer.getDestiantion());
		toll.setVehicleAmount(customer.getAmount());
		toll.setTollString(customer.getTollName());
		totalAmount += customer.getAmount();
		toll.setTotalAmount(totalAmount);
		if (vipuser.equals("yes")) {
			toll.setVipUser(true);
		} else {
			toll.setVipUser(false);
		}
		numberPassing += 1;
		toll.setVehicleType(customer.getVehicleType());
		toll.setVehicleNumber(customer.getVehicleNumber());
		list.add(toll);
		newDet.put(customer.getVehicleType(), list);
		customer.setTicketNumber(ticket);
		
		list1.add(customer);
		ticketMap.put(ticket, list);
		vehcileMap.put(ticket, list1);
		if (ticketMap.containsValue(customer.getVehicleNumber())) {
			numberOfPassing += 1;

		}
		toll.setNumberOfPassing(numberOfPassing);
		
		System.out.println("toll name is " + customer.getTollName() + " and your ticket number is " + ticket);
	}

	public String ticketGet(String tollNumber, int ticketNumber) throws CustomException {
		if (!vehcileMap.containsKey(ticketNumber) && vehcileMap == null) {
			throw new CustomException("details are not added in the list");
		}

		List<VehicleTicket> list = vehcileMap.get(ticketNumber);
		VehicleTicket vehicle = null;
		String res = "";
		for (int i = 0; i < list.size(); i++) {
			vehicle = list.get(i);
			res += "the toll name is " + vehicle.getTollName() + "toll return is " + vehicle.getTollReturn()
					+ " ticket number is " + vehicle.getTicketNumber() + " vehcile NUmber is "
					+ vehicle.getVehicleNumber() + " start is " + vehicle.getStart() + " destination is "
					+ vehicle.getDestiantion() + "   ";
		}

		return res;
	}

	public String returnTollticket(int ticketNumber, String tollName) throws CustomException {

		if (ticketMap == null || !ticketMap.containsKey(ticketNumber)) {
			throw new CustomException("Toll number is not presents");
		}

		
		List<TollTicket> list = ticketMap.get(ticketNumber);
		TollTicket ticket1 = null;
		String val = "";
		if (list == null) {
			throw new CustomException("Details in the list id empty");
		}
		for (int i = 0; i < list.size(); i++) {
			ticket1 = list.get(i);
		}
		if (ticket1.getTicketNumber() == ticketNumber && ticket1.isVipUser()) {
			vipUser(ticket1.getVehicleType());
			val += " your tollReturn type is " + ticket1.getTollNumber() + " pay the required amount ";

		} else {
			setKilometreDistanceAmount(ticket1.getVehicleType());
			val += " your tollReturn type is " + ticket1.getTollNumber() + " pay the required amount ";

		}
		return val;
	}

	public void setTollAmountReturn(int ticketNumber, int tollName, double amount) throws CustomException {
		if (ticketMap == null || !ticketMap.containsKey(ticketNumber)) {
			throw new CustomException("Toll number is not presents");
		}

		
		List<TollTicket> list = ticketMap.get(ticketNumber);
		TollTicket ticket2 = null;
		for (int i = 0; i < list.size(); i++) {
			ticket2 = list.get(i);
			if(ticket2.getVehicleNumber() != tollName)
			{
				throw new CustomException("details are not invalid,check the receipt ");
			}
		}
		if (ticket2 != null) {
			ticket2.setVehicleAmount(amount);
			totalAmount += amount;
			ticket2.setTotalAmount(totalAmount);

			System.out.println("Exits successfully ");
			ticketMap.remove(ticketNumber);
		}
		
		
	}

	/*
	 * public Map<Integer, Map<String, List<TollTicket>>> detailsShowing() throws
	 * CustomException { if(ticketMap == null) { throw new
	 * CustomException("Details are empty"); }
	 * 
	 * String listShowing ="";
	 * 
	 * for(int i=0;i< ticketMap.size();i++) { listShowing+= ticketMap.get(i)+ " "; }
	 * 
	 * return ticketMap; }
	 */

	/*
	 * public String detailsOfVehicles(String vehicle) throws CustomException { if
	 * (ticketMap == null) { throw new CustomException("Details are empty "); }
	 * 
	 * String val = "";
	 * 
	 * for (int i = 0; i < ticketMap.size(); i++) { val += ticketMap.get(vehicle) +
	 * " "; }
	 * 
	 * return val; }
	 */

	public  Map<Integer, List<TollTicket>> detailsOfAll() throws CustomException {
		if (ticketMap != null) {
			throw new CustomException("Details are empty");
		}
		System.out.println("thr total Amount is" + totalAmount);
		return ticketMap;
	}

	public Map<Integer, List<TollTicket>> detailsOfVehicleType() throws CustomException {
		if (ticketMap == null) {
			throw new CustomException("Details are Empty");
		}

		/*
		 * String res=""; int amountOfVehilce=0; Map<String,List<TollTicket>> map=new
		 * HashMap<>();
		 * 
		 * for(int i=0;i< ticketMap.size();i++) { map=ticketMap.get(i); List<TollTicket>
		 * list=new ArrayList<>(); for(int j=i;j<= map.size();j++) { list=map.get(j);
		 * TollTicket toll=list.get(i); res+="your tickets toll name" +
		 * toll.getTollNumber() +
		 * " your start adn destination is "+toll.getStart()+" and "
		 * +toll.getDestination()+ " amount is "+ toll.getVehicleAmount()
		 * +"number of passings are "+ toll.getNumberOfPassing();
		 * 
		 * } }
		 */
		System.out.println("The total Amount is " + totalAmount);
		return ticketMap;
	}

	public void totalNumberOfAmountPassing() {
		System.out.println("the total number of passing is " + numberPassing);
		System.out.println("The total Amount is " + totalAmount);
	}

}
