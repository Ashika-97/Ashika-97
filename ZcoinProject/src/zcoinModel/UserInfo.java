package zcoinModel;

public class UserInfo {

	private int  zId;
	private String userName;
	private String password;
	private String emailId;
	private long mobileNumber;
	private double RcCoin;
	private double ZcCoin;
	private int humanId;
	private String confirmation="no";
	private String transactionHistory;
	
	public int getzId() {
		return zId;
	}
	public void setzId(int zId) {
		this.zId = zId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public double getRcCoin() {
		return RcCoin;
	}
	public void setRcCoin(double rcCoin) {
		RcCoin = rcCoin;
	}
	public double getZcCoin() {
		return ZcCoin;
	}
	public void setZcCoin(double zcCoin) {
		ZcCoin = zcCoin;
	}
	public int getHumanId() {
		return humanId;
	}
	public void setHumanId(int humanId) {
		this.humanId = humanId;
	}
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	public String getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(String transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	@Override
	public String toString() {
		return "AgentInfo [zId=" + zId + ", userName=" + userName + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", RcCoin=" + RcCoin + ", ZcCoin=" + ZcCoin + ", humanId="
				+ humanId + ", confirmation=" + confirmation + ", transactionHistory=" + transactionHistory + "]";
	}
	

}
