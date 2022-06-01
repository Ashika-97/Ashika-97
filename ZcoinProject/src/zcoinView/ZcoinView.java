package zcoinView;

import java.util.Scanner;

public class ZcoinView {
	static ZcoinRun run=new ZcoinRun();
	public void optionSite()
	{
		System.out.println("1- Agnet SignUp ");
		System.out.println();
		System.out.println("2- Agent Login ");
		System.out.println();
		System.out.println("3- User Sign Up");
		System.out.println();
		System.out.println("4- User Login ");
	}
	
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		run.addDummyUser();
		run.addAgentDummy();
		ZcoinView view=new ZcoinView();
		while(flag)
		{
		view.optionSite();
		
		System.out.println("Enter the number to proceed the process");
		int n=scan.nextInt();
		switch(n)
		{
		case 1:run.agentSignUpIn();
		break;
		case 2:run.agentLogin();
		break;
		case 3:run.userSignUp();
		break;
		case 4:run.userlogin();
		break;
		case 5:flag=false;
		break;
		}
		
	   }
		scan.close();
	}

}
