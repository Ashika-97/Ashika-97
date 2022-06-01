package internetBanking;

public class AccountPojo {
   
	private int accountId;
	private int customerId;
	private long balance;
	private String branch;
	private boolean status;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
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
	@Override
	public String toString() {
		return "AccountPojo [accountId=" + accountId + ", customerId=" + customerId + ", balance=" + balance
				+ ", branch=" + branch + ", status=" + status + "]";
	}
	
	
	
	
	
}
