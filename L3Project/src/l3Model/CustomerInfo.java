package l3Model;

public class CustomerInfo implements java.io.Serializable{
	private String username;
	private String password;
	private String emailId;
	private long mobileNumber;
	private String purchasedItem;
	private double amount;
	private long invoiceNumber;
	private int purchasedCount;
	private String coupenCode;
	private String addtoCart;
	private double totalAmount;
	private String date;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddtoCart() {
		return addtoCart;
	}
	public void setAddtoCart(String addtoCart) {
		this.addtoCart = addtoCart;
	}
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPurchasedItem() {
		return purchasedItem;
	}
	public void setPurchasedItem(String purchasedItem) {
		this.purchasedItem = purchasedItem;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getPurchasedCount() {
		return purchasedCount;
	}
	public void setPurchasedCount(int purchasedCount) {
		this.purchasedCount = purchasedCount;
	}
	public String getCoupenCode() {
		return coupenCode;
	}
	public void setCoupenCode(String coupenCode) {
		this.coupenCode = coupenCode;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CustomerInfo [username=" + username + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", purchasedItem=" + purchasedItem + ", amount=" + amount
				+ ", invoiceNumber=" + invoiceNumber + ", purchasedCount=" + purchasedCount + ", coupenCode="
				+ coupenCode + ", addtoCart=" + addtoCart + ", totalAmount=" + totalAmount + ", date=" + date + "]";
	}
	
		

}
