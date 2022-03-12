package bankdb;

public class AccountInformation {

	  private int AccountId;
	   private double balance;
	   private String branch;
	   private boolean status=true;
	   private int CustomerId;
	   
	   
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double d) {
		this.balance = d;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String toString() {
		return "AccountInformation [AccountId=" + AccountId + ", balance=" + balance + ", branch=" + branch
				+ ", status=" + status + ", CustomerId=" + CustomerId + "]";
	}
  
	
	
	

}

	
	
