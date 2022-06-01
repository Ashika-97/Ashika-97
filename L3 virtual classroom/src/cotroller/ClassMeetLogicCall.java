package cotroller;

import java.util.List;

import exception.CustomException;
import model.AdminPojo;
import model.StudentPojo;
import model.TeacherPojo;

public class ClassMeetLogicCall {
	ClassMeetCache meet=new ClassMeetCache();
	
	
	public boolean studentSigningUp(StudentPojo student) throws CustomException
	{
		return meet.registerStudent(student);
	}
	public boolean studnetLogin(String userName,String password) throws CustomException
	{
		return meet.studentLogin(userName, password);
	}
	
	public boolean editingProfileDetails(String name,StudentPojo student) throws CustomException
	{
		return meet.editProfile(name, student);
	}
	
	public String materialDownload(String teachername,String studentName ) throws CustomException
	{
		return meet.materialsDownload(teachername, studentName);
	}
	public boolean questionAsk(String username,String question) throws CustomException
	{
		return meet.askQuestions(username, question);
	}
	
	public String getAnswerForOurQuestion(String username) throws CustomException
	{
		return meet.getAnswerforRespectiveQues(username);
	}
	
	public List<String>  seekAnswerList() throws CustomException
	{
		return meet.answerSeeking();
	}
	public String encryptionPassword(String password) throws CustomException
	{
		return meet.encryptPassword(password);
	}
	//teacher
	public boolean teacherSigningUp(TeacherPojo teacher) throws CustomException
	{
		return meet.teacherSignUp(teacher);
	}
	
	public boolean teacherLogin(String userName,String password) throws CustomException
	{
		return meet.teacherLogin(userName, password);
	}
	
	public boolean editTeacherDetails(TeacherPojo teacher) throws CustomException
	{
		return meet.editTeacherDetails(teacher);
	}
	
	public boolean materialsUpload(String userName,String material,String typeOfMaterial) throws CustomException
	{
		return meet.teacherMaterialsUploaded(userName, material, typeOfMaterial);
	}
	
	public List<String> listOfQuestionsShow() throws CustomException
	{
		return meet.questionsShowingToTeacher();
	}
	
	public String answerForAllQuestions(String ques,String answer) throws CustomException
	{
		return meet.answerToQuestions(ques, answer);
	}
	//Admin
	public boolean adminSignUp(AdminPojo admin) throws CustomException
	{
		return meet.registerAdmin(admin);
	}
	
	public boolean signInAdmin(String userName,String password) throws CustomException
	{
		return meet.adminLogin(userName, password);
	}
	
	public String listOfLoginMembersShowing() throws CustomException
	{
		return meet.listOfStudentsorTeachers();
	}
	public  boolean deleteIrrespectiveQuestions(String question) throws CustomException
	{
		return meet.deleteQuestions(question);
	}
	public boolean deleteAnswer(String answer) throws CustomException
	{
		return meet.deleteAnswer(answer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
