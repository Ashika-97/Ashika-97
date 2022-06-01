package zcoinView;

import java.util.List;
import java.util.Scanner;

import zcoinControl.ZcoinCallCache;
import zcoinModel.AgentInfo;
import zcoinModel.CustomException;
import zcoinModel.UserInfo;

public class ZcoinRun {
	
	
	ZcoinCallCache call=new ZcoinCallCache();
	static Scanner scan=new Scanner(System.in);
	static ZcoinRun run=new ZcoinRun();
	public void addDummyUser()
	{
		UserInfo user=new UserInfo();
		user.setUserName("priya");
		user.setMobileNumber(90368362);
		user.setEmailId("priya@gmail.com");
		user.setRcCoin(90);
		user.setZcCoin(180);
		user.setHumanId(111);
		try {
			String pass=call.passwordEncryption("priya@01290");
			user.setPassword(pass);
			System.out.println(call.userSignUp(user));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		
		
		UserInfo user1=new UserInfo();
		user1.setUserName("Annie");
		user1.setMobileNumber(94276112);
		user1.setEmailId("annie25@gmail.com");
		user1.setRcCoin(40);
		user1.setZcCoin(80);
		user1.setHumanId(909);
		try {
			String pass=call.passwordEncryption("annie901$");
			user1.setPassword(pass);
			System.out.println(call.userSignUp(user1));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		
		
		
		UserInfo user2=new UserInfo();
		user2.setUserName("judith");
		user2.setMobileNumber(93728472);
		user2.setEmailId("judith05@gmail.com");
		user2.setRcCoin(45);
		user2.setZcCoin(90);
		user.setHumanId(799);
		try {
			String pass=call.passwordEncryption("judith05@01290");
			user2.setPassword(pass);
			System.out.println(call.userSignUp(user2));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}

	public void addAgentDummy()
	{
		AgentInfo agent=new AgentInfo();
		agent.setEmailId("agent1@gmail.com");
		agent.setUserName("Akhilan");
		agent.setAgentId(101);
		try {
			String pass=call.passwordEncryption("agentPass1#");
			agent.setPassword(pass);
			System.out.println(call.agentSignUp(agent));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	
	public void userSignUp()
	{
		UserInfo user=new UserInfo();
		System.out.println("Enter the username");
		String userName=scan.nextLine();
		user.setUserName(userName);
		System.out.println("Enter the password");
		String password=scan.nextLine();
		System.out.println("Enter the emailId ");
		String emailId=scan.nextLine();
		user.setEmailId(emailId);
		System.out.println("Enter the mobile number");
		long mobienumber=scan.nextLong();
		user.setMobileNumber(mobienumber);
		System.out.println("enter the human Id");
		int humanId=scan.nextInt();
		user.setHumanId(humanId);
		System.out.println("Enter the Rc coin initial deposit ");
		double RcCoin=scan.nextDouble();
		user.setRcCoin(RcCoin);
		System.out.println("Enter the ZE coin ");
		double zcCoin=scan.nextDouble();
		user.setZcCoin(zcCoin);
	   try {
		   String encryptPass=call.passwordEncryption(password);
		   user.setPassword(encryptPass);
		   System.out.println(call.userSignUp(user));
	   }
	   catch(CustomException custom)
	   {
		   System.out.println(custom.getMessage());
	   }
		
		
	}
	
	
	public void agentSignUpIn()
	{
		AgentInfo agent=new AgentInfo();
		System.out.println("Enter the username ");
		String userName=scan.nextLine();
		agent.setUserName(userName);
		System.out.println("Enter the email id");
		String mailId=scan.nextLine();
		agent.setEmailId(mailId);
		System.out.println("Enter the password");
		String password=scan.nextLine();
		System.out.println("Enter the mobile number");
		long mobileNumber=scan.nextLong();
		agent.setMobileNumber(mobileNumber);
		System.out.println("Enter the agentId ");
		int id=scan.nextInt();
		agent.setAgentId(id);
		scan.nextLine();
		try {
			boolean emailCheck=call.emailIdCheck(mailId);
			if(emailCheck) {
			String encrypt=call.passwordEncryption(password);
			boolean res=call.passwordLengthCheck(encrypt);
			if(res) {
				System.out.println("Pass : "+res);
			agent.setPassword(encrypt);
			System.out.println(call.agentSignUp(agent));
			}
			}
			else {
				System.out.println("Kindly enter the email id in correct format ");
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void agentSite()
	{
		System.out.println("1- makeApproval To Login");
	}
	public void agentLogin()
	{
		System.out.println("Enter the emailId");
		String emailId=scan.nextLine();
		System.out.println("Enter the password");
		String password=scan.nextLine();
		System.out.println("Enter the agentId ");
		int id =scan.nextInt();
		scan.nextLine();
		String encryptPass="";
		try {
			
			encryptPass=call.passwordEncryption(password);
			boolean res=call.passwordLengthCheck(encryptPass);
			if(res)
			{
			boolean flag=call.agentLogin(emailId, encryptPass, id);
			System.out.println(flag);
			while(flag)
			{
				agentSite();
				System.out.println("Enter the number to move to the options ");
				int opt=scan.nextInt();
				switch(opt)
				{
				case 1:run.makeApprovalStatus();
				break;
				case 2:
				}
			}
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void userlogin()
	{
		System.out.println("Enter the email id");
		String mailId=scan.nextLine();
		System.out.println("Enter the password");
		String password=scan.nextLine();
		//System.out.println("Enter the Zid ");
		//int zid=scan.nextInt();
		try {
			String encryptPass=call.passwordEncryption(password);
			boolean res=call.passwordLengthCheck(encryptPass);
			boolean result=call.checkZidValidornot(mailId, encryptPass);
			if(result && res) {
			boolean check=call.userLogin(mailId, encryptPass);
			System.out.println(check);
//			while(check)
//			{
//				System.out.println("Enter the number to move to the user options ");
//				int opt=scan.nextInt();
//				switch(opt)
//				{
//				case 1:run.
//				}
//				
//			}
		     }
			else {
				System.out.println("Your ZID is not given so please wait and try later");
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	
	public void makeApprovalStatus()
	{
		System.out.println("see the list of user sign up");
		try {
			List<UserInfo> list1=call.approveByZe();
			for(int i=0;i< list1.size();i++)
			{
				UserInfo user=list1.get(i);
				System.out.println(user);
				System.out.println("Do you want to approve this ");
				String confirm=scan.nextLine();
				if(confirm.equals("yes"))
				{
					System.out.println(call.idApprovalAndGivenThemId(user));
				}
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
						
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	public static void main(String[] args)
//	{
//		ZcoinRun run=new ZcoinRun();
//		boolean flag=true;
//		while(flag)
//		{
//			System.out.println("Enter the number to proceed the process ");
//			int n=scan.nextInt();
//			scan.nextLine();
//			
//			switch(n)
//			{
//			case 1:
//				
//			case 2:
//			}
//		}
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
