package zcoinModel;

public class AgentInfo {
	
	private String userName;
	private String password;
	private int agentId;
	private String emailId;
	private long MobileNumber;
	
	
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
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "AgentInfo [userName=" + userName + ", password=" + password + ", agentId=" + agentId + ", emailId="
				+ emailId + ", MobileNumber=" + MobileNumber + "]";
	}
	

	
	
	
	
	
	
	

}
