package taxiPojo;

public class CustomerPojo {
	   private int customerId;
	   private char pickup;
	   private char drop;
	   private int time;
	   private long amount;
	   private int taxiNumber;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public char getPickup() {
		return pickup;
	}
	public void setPickup(char pickup) {
		this.pickup = pickup;
	}
	public char getDrop() {
		return drop;
	}
	public void setDrop(char drop) {
		this.drop = drop;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getTaxiNumber() {
		return taxiNumber;
	}
	public void setTaxiNumber(int taxiNumber) {
		this.taxiNumber = taxiNumber;
	}
	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", pickup=" + pickup + ", drop=" + drop + ", time=" + time
				+ ", amount=" + amount + ", taxiNumber=" + taxiNumber + "]";
	}
	   
}