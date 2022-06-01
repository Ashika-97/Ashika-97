package tollPojo;

public class TollTicket {

	private String tollreturn;
	private int ticketNumber;
	private String vehicleType;
	private int vehicleNumber;
	private String start;
	private String destination;
	private double vehicleAmount;
	private double totalAmount;
	private int numberOfPassing;
	private boolean vipUser;
	private String tollString;
	
	
	
	public String getTollNumber() {
		return tollreturn;
	}
	public void setTollNumber(String tollNumber) {
		this.tollreturn = tollNumber;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
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
	
	public String getTollString() {
		return tollString;
	}
	public void setTollString(String tollString) {
		this.tollString = tollString;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getVehicleAmount() {
		return vehicleAmount;
	}
	public void setVehicleAmount(double vehicleAmount) {
		this.vehicleAmount = vehicleAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getNumberOfPassing() {
		return numberOfPassing;
	}
	public void setNumberOfPassing(int numberOfPassing) {
		this.numberOfPassing = numberOfPassing;
	}
	public boolean isVipUser() {
		return vipUser;
	}
	public void setVipUser(boolean vipUser) {
		this.vipUser = vipUser;
	}
	@Override
	public String toString() {
		return "TollTicket [tollreturn=" + tollreturn + ", ticketNumber=" + ticketNumber + ", vehicleType="
				+ vehicleType + ", vehicleNumber=" + vehicleNumber + ", start=" + start + ", destination=" + destination
				+ ", vehicleAmount=" + vehicleAmount + ", totalAmount=" + totalAmount + ", numberOfPassing="
				+ numberOfPassing + ", vipUser=" + vipUser + ", tollString=" + tollString + "]";
	}
	

	
	
	
	
}
