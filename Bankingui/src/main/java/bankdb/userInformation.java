package bankdb;

public class userInformation {
   private  String userName;

private  int userId;
   private  String password;
   private  int roleId;
   private  int customerId;
   
   
public  String getUserName() {
	return userName;
}
public  void setUserName(String userName) {
	this.userName = userName;
}
public  int getUserId() {
	return userId;
}
public  void setUserId(int userId) {
	this.userId = userId;
}
public  String getPassword() {
	return password;
}
public  void setPassword(String password) {
	this.password = password;
}
public  int getRoleId() {
	return roleId;
}
public  void setRoleId(int roleId) {
	this.roleId = roleId;
}
public  int getCustomerId() {
	return customerId;
}
public  void setCustomerId(int customerId) {
	this.customerId = customerId;
}


@Override
public String toString() {
	return "userInformation [userName"+userName+"password"+password+"roleId"+roleId+"customerId"+customerId+"]";
}



	
	
	
	
}
