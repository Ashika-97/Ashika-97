package taxiPojo;

public class TaxiPojo {
	private int taxiNum;
	private char pickup;
	private char drop;
	private  long amount;
	private double totalAmount;
	private int customerId;
	private int time;
	public int getTaxiNum() {
		return taxiNum;
	}
	public void setTaxiNum(int taxiNum) {
		this.taxiNum = taxiNum;
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TaxiPojo [taxiNum=" + taxiNum + ", pickup=" + pickup + ", drop=" + drop + ", amount=" + amount
				+ ", totalAmount=" + totalAmount + ", customerId=" + customerId + ", time=" + time + "]";
	}
	
	
}
	
	
	
	
	
	