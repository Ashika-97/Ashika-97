package view;

import java.util.List;
import java.util.Scanner;

import cotroller.ClassMeetLogicCall;
import exception.CustomException;
import model.AdminPojo;
import model.StudentPojo;
import model.TeacherPojo;

public class ClassMeetRun {
	
	ClassMeetLogicCall logic=new ClassMeetLogicCall();
	static Scanner scan=new Scanner(System.in); 
	static ClassMeetRun run=new ClassMeetRun();
	
	public void addDummyStudents()
	{
		String material="A summary is a short retelling of a longer written passage, containing the author’s\n"
				+ "most important ideas. Summarizing helps improve both your reading and writing\n"
				+ "skills. To summarize, you must read a passage closely, finding the main ideas and\n"
				+ "supporting ideas. Then you must briefly write down those ideas in a few sentences\n"
				+ "or a paragraph.\n"
				+ "It is important to understand the difference between a summary and a paraphrase.\n"
				+ "A paraphrase is simply a rewriting of a passage in your own words. A summary, on\n"
				+ "the other hand, contains only the main idea and the supporting ideas of a passage.\n"
				+ "A summary will be much shorter than a paraphrase.";
		StudentPojo pojo=new StudentPojo();
		pojo.setUserName("Adhi");
		pojo.setAge("17");
		String pass="";
		pojo.setStandard(12);
		pojo.setMaterialType("ppt");
		pojo.setMaterials(material);
		
		try {
			pass = logic.encryptionPassword("weDe1@");
			pojo.setPassword(pass);
			System.out.println(logic.studentSigningUp(pojo));
		} catch (CustomException e) {
		
			e.printStackTrace();
		}
		
		StudentPojo pojo1=new StudentPojo();
		pojo1.setUserName("Akil");
		pojo1.setAge("17");
		String pass1="";
		pojo1.setPassword(pass);
		pojo1.setStandard(12);
		pojo1.setMaterialType("mp4");
		pojo1.setMaterials(null);
		try {
			pass1 = logic.encryptionPassword("nhkUI9");
			pojo1.setPassword(pass1);
			System.out.println(logic.studentSigningUp(pojo1));
		} catch (CustomException e) {
		
			e.printStackTrace();
		}
		
		StudentPojo pojo2=new StudentPojo();
		pojo2.setUserName("iikit");
		pojo2.setAge("17");
		String pass2="";
		pojo2.setPassword(pass);
		pojo2.setStandard(12);
		pojo2.setMaterialType("ppt");
		pojo2.setMaterials(null);
		try {
			pass2 = logic.encryptionPassword("nhvaT");
			pojo2.setPassword(pass2);
			System.out.println(logic.studentSigningUp(pojo2));
		} catch (CustomException e) {
		
			e.printStackTrace();
		}
		
		
		
		TeacherPojo teach=new TeacherPojo();
		teach.setName("Elizabeth");
		teach.setStandard(12);
		teach.setMobilenumber(90781893);
		teach.setMaterialType("ppt");
		teach.setMaterials(material);
		try {
		   String passencrypt=logic.encryptionPassword("t4Ecg1");	
		   teach.setPassword(passencrypt);
		   System.out.println(logic.teacherSigningUp(teach));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		TeacherPojo teach1=new TeacherPojo();
		teach1.setName("Merlin");
		teach1.setStandard(12);
		teach1.setMobilenumber(90781893);
		teach1.setMaterialType("ppt");
		teach1.setMaterials(material);
		try {
		   String passencrypt=logic.encryptionPassword("pmoTcg1");	
		   teach1.setPassword(passencrypt);
		   System.out.println(logic.teacherSigningUp(teach1));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		TeacherPojo teach2=new TeacherPojo();
		teach2.setName("veni");
		teach2.setStandard(11);
		teach2.setMobilenumber(90781893);
		teach2.setMaterialType("mp4");
		teach2.setMaterials(material);
		try {
		   String passencrypt=logic.encryptionPassword("lsdW9jo");	
		   teach2.setPassword(passencrypt);
		   System.out.println(logic.teacherSigningUp(teach2));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		
		
		AdminPojo admin=new AdminPojo();
		admin.setUserName("Akash");
		admin.setAge(37);
		
		try {
			String encrypt=logic.encryptionPassword("3inEcns");
	     	admin.setPassword(encrypt);
	     	admin.setAdminId(510);
		    System.out.println(logic.adminSignUp(admin));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		
		AdminPojo admin1=new AdminPojo();
		admin1.setUserName("vikranth");
		admin1.setAge(37);
		
		try {
			String encrypt=logic.encryptionPassword("asjHns");
			admin1.setPassword(encrypt);
			admin1.setAdminId(511);
		    System.out.println(logic.adminSignUp(admin1));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		AdminPojo admin2=new AdminPojo();
		admin2.setUserName("vickram");
		admin2.setAge(37);
		
		try {
			String encrypt=logic.encryptionPassword("gjfnMsj");
			admin2.setPassword(encrypt);
			admin2.setAdminId(512);
		    System.out.println(logic.adminSignUp(admin2));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
				
	}
	public void signUpStudent()
	{
		StudentPojo pojo=new StudentPojo();
		System.out.println("Enter the userName");
		String user=scan.nextLine();
		pojo.setUserName(user);
		System.out.println("Enter the password");
		String password=scan.nextLine();
		String val="";
		try {
			val=logic.encryptionPassword(password);
		} catch (CustomException e) {
			 System.out.println(e.getMessage());
		}
		pojo.setPassword(val);
		System.out.println("Enter the standard ");
		int standard=scan.nextInt();
		
		pojo.setStandard(standard);
		System.out.println("Enter the mobile number");
		long mobileNumber=scan.nextLong();
		pojo.setMobileNumber(mobileNumber);
		scan.nextLine();
		try {
			System.out.println(logic.studentSigningUp(pojo));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void studentSite()
	{
		System.out.println("1-Edit profile");
		System.out.println();
		System.out.println("2-Ask questions");
		System.out.println();
		System.out.println("3-Get answer for your questions");
		System.out.println();
		System.out.println("4-Seek all answers ");
	}
	public void studentLogin()
	{
		System.out.println("Enter the userName");
		String userName=scan.nextLine();
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		String encryptPass="";
		try {
			encryptPass=logic.encryptionPassword(password);
			boolean flag=logic.studnetLogin(userName, encryptPass);
			System.out.println(flag);
			while(flag)
			{
				//run.studentSite();
				System.out.println("Enter the choice to change or update details");
				studentSite();
				int number=scan.nextInt();
				scan.nextLine();
				switch(number)
				{
				case 1:run.editingDetails();
				break;
				case 2:run.askQuestions(userName);
				break;
				case 3:run.getAnswerForOurQuestions(userName);
				break;
				case 4:run.seekAllAnswer();
				break;
				case 5:flag=false;
				break;
				}
			}
			
			
		} catch (CustomException e) {
		     
			System.out.println(e.getMessage());
		}
	}
	
	
	public void editingDetails()
	{
		StudentPojo pojo=new StudentPojo();
		System.out.println("Enter the userName");
		String user=scan.nextLine();
		pojo.setUserName(user);
		System.out.println("Enter the password");
		String password=scan.nextLine();
		String val="";
		try {
			val=logic.encryptionPassword(password);
		} catch (CustomException e) {
			 System.out.println(e.getMessage());
		}
		pojo.setPassword(val);
		System.out.println("Enter the standard ");
		int standard=scan.nextInt();
		
		pojo.setStandard(standard);
		System.out.println("Enter the mobile number");
		long mobileNumber=scan.nextLong();
		pojo.setMobileNumber(mobileNumber);
		scan.nextLine();
		try {
			boolean value=logic.editingProfileDetails(user, pojo);
			if(value)
			{
				System.out.println("Details are edited successfully ");
			}
			else {
				System.out.println("Details are not updated, try later.");
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	
	public void askQuestions(String userName)
	{
		System.out.println("Enter the questions ");
		String questions=scan.nextLine();
		try {
			boolean ask=logic.questionAsk(userName, questions);
			if(ask)
			{
				System.out.println(ask);
			}
			else {
				System.out.println("Again ask the question");
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void getAnswerForOurQuestions(String userName)
	{
		try {
			System.out.println(logic.getAnswerForOurQuestion(userName));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void seekAllAnswer()
	{
		try {
			System.out.println(logic.seekAnswerList());
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	//Teacher
	public void teacherSignUp()
	{
		TeacherPojo teach=new TeacherPojo();
		System.out.println("Enter the name ");
		String name=scan.nextLine();
		teach.setName(name);
		System.out.println("Enter the password");
		String password=scan.nextLine();
		String encryptedPassword="";
		System.out.println("Enter the mobile number");
		long mobileNumber=scan.nextLong();
		teach.setMobilenumber(mobileNumber);
		System.out.println("Enter the standard you are taking. ");
		int standard=scan.nextInt();
		teach.setStandard(standard);
		scan.nextLine();
		
		try {
			 encryptedPassword=logic.encryptionPassword(password);
			 teach.setPassword(encryptedPassword);
			 boolean result=logic.teacherSigningUp(teach);
			 if(result)
			 {
				 System.out.println("Teacher signed up successfully ");
			 }
			 else {
				 System.out.println("Try again later ");
			 }
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void teacherLoginForm()
	{
		System.out.println("Enter the user name");
		String username=scan.nextLine();
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		String encryptPassword="";
		try {
			encryptPassword=logic.encryptionPassword(password);
			boolean flag=logic.teacherLogin(username, encryptPassword);
			while(flag)
			{
				run.teacherSite();
				System.out.println("Enter the number to proceed the process ");
				int n=scan.nextInt();
				scan.nextLine();
				switch(n)
				{
				case 1:run.editTeacherDetails();
					break;
				case 2:run.materialsUploaded(username);
					break;
				case 3:run.questionsSeeking();
				    break;
				case 4:run.answerToAllQuestions();
				    break;
				case 5:flag=false;
				    break;
				}
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void teacherSite()
	{
		System.out.println("1- Edit teacher details ");
		System.out.println();
		System.out.println("2-Materials upload Site");
		System.out.println();
		System.out.println("3-Question seeking ");
		System.out.println();
		System.out.println("4- Answer seeking ");
		System.out.println();
		System.out.println("5- Exit the process ");
	}
	
	
	public void editTeacherDetails()
	{
		TeacherPojo teacher=new TeacherPojo();
		System.out.println("Enter the user name ");
		String userName1=scan.nextLine();
		teacher.setName(userName1);
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		
		System.out.println("Enter the mobile number ");
		long mobileNumber=scan.nextLong();
		teacher.setMobilenumber(mobileNumber);
		System.out.println("Enter the standard you're taking ");
		int standard=scan.nextInt();
		teacher.setStandard(standard);
		scan.nextLine();
		try {
			String encryptPassword=logic.encryptionPassword(password);
			teacher.setPassword(encryptPassword);
			boolean flag=logic.editTeacherDetails(teacher);
			if(flag)
			{
			System.out.println("Details are changed successfully");
		    }
			else {
				System.out.println("Edit the details later ");
			}
	       }
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void   materialsUploaded(String userName)
	{
		System.out.println("Enter the type of materials uploaded ");
		String typeOfMaterial=scan.nextLine();
		System.out.println("Upload the material");
		String material=scan.nextLine();
		try {
			boolean flag=logic.materialsUpload(userName, material, typeOfMaterial);
			if(flag)
			{
				System.out.println("Materials uploaded successfully ");
			}
			else {
				System.out.println("Material are not uploaded ");
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void questionsSeeking()
	{
		try {
			List<String> list=logic.listOfQuestionsShow();
			for(int i=0;i< list.size();i++)
			{
				System.out.println(list.get(i));
			}
			
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void answerToAllQuestions()
	{
		String result="";String answer="";String value="";
		try {
			List<String> list=logic.listOfQuestionsShow();
			for(int i=0;i< list.size();i++)
			{
			  result=""+list.get(i);
			  System.out.println(result);
			  System.out.println("Enter the answer ");
			  answer=scan.nextLine();
			  value+=""+logic.answerForAllQuestions(result, answer);
			  
			}
			System.out.println(value);
			
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
	}
	//admin sign up
	public void adminSignUp()
	{
		AdminPojo admin=new AdminPojo();
		System.out.println("Enter the userName ");
		String userName=scan.nextLine();
		admin.setUserName(userName);
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		System.out.println("Enter the age ");
		int age=scan.nextInt();
		admin.setAge(age);
		System.out.println("Enter the AdminId ");
		int adminId=scan.nextInt();
		admin.setAdminId(adminId);
		scan.nextLine();
		String encryptPassword="";
		try {
			encryptPassword=logic.encryptionPassword(password);
			admin.setPassword(encryptPassword);
			boolean flag=logic.adminSignUp(admin);
			if(flag)
			{
				System.out.println("Admin signedUp successfully ");
			}
			else {
				System.out.println("Try later ");
			}
			
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void adminSite()
	{
		System.out.println("1-Showing pending list of members");
		System.out.println();
		System.out.println("2-Delete the questions ");
		System.out.println();
		System.out.println("3-Delete the answer ");
		System.out.println();
	}
	
	
	public void adminLogin()
	{
		System.out.println("Enter the user name ");
		String username=scan.nextLine();
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		String encryptPassword="";
		try {
			encryptPassword=logic.encryptionPassword(password);
			boolean result=logic.signInAdmin(username, encryptPassword);
			while(result)
			{
				run.adminSite();
				System.out.println("Enter the number to proceed the process ");
				int n=scan.nextInt();
				scan.nextLine();
				switch(n)
				{
				case 1:run.loginMemebersPendingShowing();
				break;
				case 2:run.deleteQuestion();
				break;
				case 3:run.deleteAnswer();
				break;
				case 4:result=false;
				break;
				}
		      
			}
			if(!result)
			{
				run.adminLogin();
			}
			
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void loginMemebersPendingShowing()
	{
		try {
			String result=logic.listOfLoginMembersShowing();
			for(String res:result.split(" "))
			{
				System.out.println(res);
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public  void deleteQuestion()
	{
		try {
		    List<String> listQues=logic.listOfQuestionsShow();
		    for(int i=0;i< listQues.size();i++)
		    {
		    	String val=listQues.get(i);
		    	System.out.println(val);
		    	System.out.println("Do you want to delete this question");
		    	String ans=scan.nextLine();
		    	if(ans.equals("yes"))
		    	{
		    		boolean virtual=logic.deleteIrrespectiveQuestions(val);
		    		if(virtual)
		    		{
		    			System.out.println("Question deleted successfully ");
		    		}
		    		else {
		    			System.out.println("Could'nt delete this question ");
		    		}
		    	}
		    }
	      }
	   catch(CustomException exception)
		{
		   System.out.println(exception.getMessage());
		}
	}
	
	public void deleteAnswer()
	{
		try {
			List<String> val=logic.seekAnswerList();
			for(int i=0;i< val.size();i++)
			{
				String input=val.get(i);
				System.out.println(input);
				System.out.println("Do you want to delete this question ");
				String confirm=scan.nextLine();
				if(confirm.equals("yes"))
				{
					boolean result=logic.deleteAnswer(input);
					if(result)
					{
						System.out.println("Answer deleted successfully");
					}
					else {
						System.out.println("Could'nt delete the answer");
					}
				}
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
