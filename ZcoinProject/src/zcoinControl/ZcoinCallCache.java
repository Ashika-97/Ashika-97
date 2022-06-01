package zcoinControl;

import java.util.List;

import zcoinModel.AgentInfo;
import zcoinModel.CustomException;
import zcoinModel.UserInfo;

public class ZcoinCallCache {
	
	ZcoinCache cache=new ZcoinCache();
	
	
	
	public boolean userSignUp(UserInfo user) throws CustomException
	{
		return cache.addCustomerInZcoin(user);
	}
	public boolean emailIdCheck(String mailId) throws CustomException
	{
		return cache.emailIdCheck(mailId);
	}
	public boolean agentSignUp(AgentInfo agent) throws CustomException
	{
		return cache.zeSignUp(agent);
	}
	
	public boolean agentLogin(String emailId,String password,int agentId) throws CustomException
	{
		return cache.zeLogin(emailId, password, agentId);
	}
	public boolean passwordLengthCheck(String password) throws CustomException
	{
		return cache.passwordLengthCheck(password);
	}
	public String passwordEncryption(String password) throws CustomException
	{
		return cache.passwordEncryption(password);
	}
	public boolean userLogin(String emailId,String password) throws CustomException
	{
		return cache.userLogin(emailId, password);
	}
	
	public List<UserInfo>  approveByZe() throws CustomException
	{
		return cache.getApprovalByZe();
	}
	
	public boolean idApprovalAndGivenThemId(UserInfo user) throws CustomException
	{
		return cache.makeIdByZeApproval(user);
	}
	
	public boolean checkZidValidornot(String email,String password) throws CustomException
	{
		return cache.checkUserGetZid(email, password);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
