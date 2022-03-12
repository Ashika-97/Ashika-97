package bankdb;

public class CustomerInformation {

	 
    private String customerName;
    private long mobileNumber;
	private String address;
   	private int customerId;
   	private String Email;
   	private boolean status=true;
   	
   	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long d) {
		this.mobileNumber = d;
	}
	
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "CustomerId [customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", address="
				+ address +  "]";
	}
   	  
}
