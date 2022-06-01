package zcoinControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import zcoinModel.AgentInfo;
import zcoinModel.CustomException;
import zcoinModel.UserInfo;

public class ZcoinCache {
	Map<String,UserInfo>   userMap=new HashMap<>();
	Map<String,AgentInfo>  agentMap=new HashMap<>();
	Map<Integer,String>    transactionMap=new HashMap<>();
	int[] agentroll= {101,201,301,401,501};
	int zid=1001;
	
	public int zidAutoGenerate()
	{
		return ++zid;
	}
	
	
	public boolean emailIdCheck(String emailId) throws CustomException
	{
		Pattern pat=Pattern.compile("^[a-z0-9_+&*-]+(?:\\."+
                "[a-z0-9_+&*-]+)*@" +
                "(?:[a-z0-9-]+\\.)+[a-z]{2,7}$");
	//	Pattern pattern=Pattern.compile("([A-Z]+[a-zA-Z_]+@\b([a-zA-Z]+.){2}\b?.[a-zA-Z]+;)");
		Matcher match=pat.matcher(emailId);
		boolean result=match.find();
		return result;
		
	}
	public boolean addCustomerInZcoin(UserInfo user) throws CustomException
	{
		boolean ret=emailIdCheck(user.getEmailId());
		if(ret)
		{
		userMap.put(user.getEmailId(), user);
		return true;
		}
		return false;
	}
	
	public boolean zeSignUp(AgentInfo agent) throws CustomException
	{
		agentMap.put(agent.getEmailId(), agent);
		return true;
	}
	public boolean zeLogin(String emailId,String password,int agentId) throws CustomException
	{
		if(!agentMap.containsKey(emailId))
		{
			throw new CustomException("userName not presents,pleae enter correct username. ");
		}
		boolean flag=true;
//		for(int i=0;i < agentroll.length;i++)
//		{
//			if(agentId == agentroll[i])
//			{
//				flag=true				return;
//			}
//		}
//		
		AgentInfo agent=agentMap.get(emailId);
		if(agent.getEmailId().equals(emailId) && agent.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
	
	public String passwordEncryption(String password) throws CustomException
	{
		nullCheck(password);
		String result="";
		for(int i=0;i< password.length();i++)
		{
			char ch=password.charAt(i);
			int val=(int)ch+1;
			char ch1=(char) val;
			result+=ch1;
		}
		return result;
	}
	
	public void nullCheck(String user) throws CustomException
	{
		if(user==null || user.isEmpty())
		{
			throw new CustomException(" Details cant be empty ");
		}
	}
	
	public boolean passwordLengthCheck(String password) throws CustomException
	{
		nullCheck(password);
		if(password.length() >=8)
		{
			for(int i=0;i<password.length();i++)
			{
				char ch=password.charAt(i);
				//"^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$"

				if( ch >= 'A' && ch <='Z' || ch >='a' && ch <='z' || ch <= '0' && ch >= '9')
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean userLogin(String emailId,String password) throws CustomException
	{
		if(!userMap.containsKey(emailId))
		{
			throw new CustomException("userName not presents ,try later ");
		}
		
		UserInfo user=userMap.get(emailId);
		if(user.getzId()==0)
		{
			return false;
		}
		if(user.getEmailId().equals(emailId) && user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
	public List<UserInfo> getApprovalByZe() throws CustomException
	{
		List<UserInfo> list=new ArrayList<>();
		for(UserInfo userValue:userMap.values())
		{
			list.add(userValue);
		}
		return list;	
		
	}
	
	
	public boolean makeIdByZeApproval(UserInfo user) throws CustomException
	{
		int zid=zidAutoGenerate();
		user.setzId(zid);
		userMap.put(user.getEmailId(), user);
		return true;
	}
	
	
	public boolean checkUserGetZid(String email,String password) throws CustomException
	{
		if(!userMap.containsKey(email))
		{
			throw new CustomException("Details are Invalid");
		}
		
		UserInfo user=userMap.get(email);
		if(user.getzId() == 0)
		{
			return false;
		}
		else {
			return true;
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
