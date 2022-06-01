package l3Model;

public class AdminInfo implements java.io.Serializable{
	
	
	private String userName;
	private String password;
	private boolean replaceOrder;
	private int adminId;
	private int coupenCode;
	
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
	public boolean isReplaceOrder() {
		return replaceOrder;
	}
	public void setReplaceOrder(boolean replaceOrder) {
		this.replaceOrder = replaceOrder;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public int getCoupenCode() {
		return coupenCode;
	}
	public void setCoupenCode(int coupenCode) {
		this.coupenCode = coupenCode;
	}
	@Override
	public String toString() {
		return "AdminInfo [userName=" + userName + ", password=" + password + ", replaceOrder=" + replaceOrder
				+ ", adminId=" + adminId + ", coupenCode=" + coupenCode + "]";
	}
	
	
	

}
