package view;

import java.util.Scanner;

public class ClassMeetView 
       {
	    static ClassMeetRun run=new ClassMeetRun();
	
	public void methodShowing()
	{
		System.out.println("1- Student site form ");
		System.out.println();
		System.out.println("2- Teacher site form ");
		System.out.println();
		System.out.println("3- Admin site form");
		System.out.println();
	}
	public void studentShowing()
	{
		System.out.println("1- Student sign up");
		System.out.println();
		System.out.println("2- Student login");
		System.out.println();
	}
	public void teacherShowing()
	{
		System.out.println("1- Teacher sign up");
		System.out.println();
		System.out.println("2- Teacher login ");
		System.out.println();
	}
	public void AdminShowing()
	{
	 System.out.println("1- Admin sign up ");
	 System.out.println();
	 System.out.println("2- Admin login ");
	 System.out.println();
	 //System.out.println("3- Exit the process ");
	}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		ClassMeetView view=new ClassMeetView();
		boolean flag=true;
		run.addDummyStudents();
		
		while(flag)
		{
			view.methodShowing();
			System.out.println("Enter the number to proceed the process ");
			int n=scan.nextInt();
			scan.nextLine();
			
			switch(n)
			{
			case 1:
		       {
			    view.studentShowing();
			    System.out.println("Enter the number to proceed the process ");
		        int num=scan.nextInt();
		        scan.nextLine();
		        switch(num)
		        {
		        case 1:run.signUpStudent();
		               break;
		        case 2:run.studentLogin();
		               break;
		        }
			   
		     }
		     break;
			   
			  case 2:
			      {
				    view.teacherShowing();
					System.out.println("Enter the number to proceed the process ");
			        int num1=scan.nextInt();
			        scan.nextLine();
					switch(num1)
					{
					case 1:run.teacherSignUp();
					break;
					case 2:run.teacherLoginForm();
					break;
					}
			    }
			      break;
		    
	
				case 3:
				      {
						view.AdminShowing();
						System.out.println("Enter the number to proceed the process ");
				        int num=scan.nextInt();
				        scan.nextLine();
						
						switch(num)
						{
						case 1:run.adminSignUp();
						break;
						case 2:run.adminLogin();
						break;
										
						}
				     }
				break;
				   
			
			
			}
			
			
		}
		scan.close();
		
	}

}
