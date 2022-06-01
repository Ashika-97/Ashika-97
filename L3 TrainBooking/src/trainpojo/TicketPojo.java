package trainpojo;



public class TicketPojo {

	private int ticketNumber;
	private int trainNumber;
	private String trainName;
	private int seatNumber;
	private String seatType;
	private String amountPaid;
	private boolean ticketConfirmation;
	private String dateOfJourney;
	private double timeofTrain;
	private String passengerName;
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	public boolean isTicketConfirmation() {
		return ticketConfirmation;
	}
	public void setTicketConfirmation(boolean ticketConfirmation) {
		this.ticketConfirmation = ticketConfirmation;
	}
	public String getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public double getTimeofTrain() {
		return timeofTrain;
	}
	public void setTimeofTrain(double d) {
		this.timeofTrain = d;
	}
	
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	@Override
	public String toString() {
		return "TicketPojo [ticketNumber=" + ticketNumber + ", trainNumber=" + trainNumber + ", trainName=" + trainName
				+ ", seatNumber=" + seatNumber + ", seatType=" + seatType + ", amountPaid=" + amountPaid
				+ ", ticketConfirmation=" + ticketConfirmation + ", dateOfJourney=" + dateOfJourney + ", timeofTrain="
				+ timeofTrain + ", passengerName=" + passengerName + "]";
	}
	
}