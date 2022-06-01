package tollPojo;

public class VehicleTicket {
	
	private int ticketNumber;
	private String tollReturn;
	private String vehicleType;
	private int vehicleNumber;
	private double amount;
	private String start;
	private String destiantion;
	private String tollName;
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTollReturn() {
		return tollReturn;
	}
	public void setTollReturn(String tollNumber) {
		this.tollReturn = tollNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	public String getTollName() {
		return tollName;
	}
	public void setTollName(String tollName) {
		this.tollName = tollName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestiantion() {
		return destiantion;
	}
	public void setDestiantion(String destiantion) {
		this.destiantion = destiantion;
	}
	@Override
	public String toString() {
		return "VehicleTicket [ticketNumber=" + ticketNumber + ", tollReturn=" + tollReturn + ", vehicleType="
				+ vehicleType + ", vehicleNumber=" + vehicleNumber + ", amount=" + amount + ", start=" + start
				+ ", destiantion=" + destiantion + ", tollName=" + tollName + "]";
	}

	
	
	

}
