package internetBanking;

public class CustomerPojo {
     
	private int userName;
	private String password;
	private int customerId;
	private String customerName;
	private long balance;
	private String address;
	private long mobileNumber;
	private String branch;
	
	
	
	
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "CustomerPojo [userName=" + userName + ", password=" + password + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", balance=" + balance + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", branch=" + branch + "]";
	}
	
	
	
}
