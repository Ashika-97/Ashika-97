package trainpojo;

import java.time.LocalDate;

public class PassengerPojo {

	private String passengerName;
	private int age;
	private String gender;
	private String seatTypes;
	private int seatNumber;
	private String fromPlace;
	private String toPlace;
	private long amount;
	private LocalDate date;
	private String trainName;
	private int trainNumber;
	
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSeatTypes() {
		return seatTypes;
	}
	public void setSeatTypes(String seatTypes) {
		this.seatTypes = seatTypes;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	@Override
	public String toString() {
		return "PassengerPojo [passengerName=" + passengerName + ", age=" + age + ", gender=" + gender + ", seatTypes="
				+ seatTypes + ", seatNumber=" + seatNumber + ", fromPlace="
				+ fromPlace + ", toPlace=" + toPlace + ", amount=" + amount + ", date=" + date + ", trainName="
				+ trainName + ", trainNumber=" + trainNumber + "]";
	}
	
	
	
}