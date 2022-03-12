package bankdb;

import java.sql.SQLException;
import java.util.Map;

public class LogicalNextLayer {

	UserDb user=new UserDb();
	Roledb role=new Roledb();
	
	public void creationUser()
	{
		user.creationCustomer();
	}
	
	public void insertUser(userInformation user1) throws Exception
	{
		user.insertionCustomer(user1);
	}
	
	public void selectUser(userInformation user1) throws Exception
	{
		user.selectionCustomer(user1);
	}
	public void upadteUser(userInformation user1) throws Exception
	{
		user.updateCustomer(user1);
	}
	public userInformation validate(String username,String pass) throws SQLException
	{
		userInformation bool=user.userValidate(username, pass);
		return bool;
	}
	
	public void creationAdmin() {
		
		role.creationAccount();
		
	}
	
	public void insertAdmin(RoleInformation role1) throws Exception
	{
	  role.insertionAccount(role1);
	}
	
	public Map<String,Map<String,RoleInformation >> selectAdmin(RoleInformation role1) throws Exception
	{
		Map<String,Map<String,RoleInformation >> map=role.selectionParticularly(role1);
		
		return map;
	}
	
	public Map<Integer,Map<Integer,RoleInformation>> selectAll() throws Exception
	{
		Map<Integer,Map<Integer,RoleInformation>> map=role.allAccounts();
		return map;
	}
	
	public RoleInformation validateAdmin(String userName,int id) throws Exception
	{
		RoleInformation bool=role.adminvalidate(userName,id);
		return bool;
	}
	
	public void upadateAdmin(RoleInformation role1) throws Exception
	{
		role.updateAccount(role1);
	}
	
	public void deleteAdmin(RoleInformation role1) throws Exception
	{
		role.deletionAccount(role1);
	}
	public void dropAdmin() throws Exception
	{
		role.dropAccountTable();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
