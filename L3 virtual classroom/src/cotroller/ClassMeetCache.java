package cotroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CustomException;
import model.AdminPojo;
import model.StudentPojo;
import model.TeacherPojo;

public class ClassMeetCache {
	
	static Map<String,StudentPojo> studentMap=new HashMap<>();
	static Map<String,TeacherPojo> teacherMap=new HashMap<>();
	static Map<String,AdminPojo>  adminMap=new HashMap<>();
	static Map<String,String>  quesMap=new HashMap<>();
	static Map<String,String>  ansMap=new HashMap<>();
	
	
	//1- register
	public boolean registerStudent(StudentPojo student) throws CustomException
	{
		int size=studentMap.size();
		studentMap.put(student.getUserName(), student);
		if(size != studentMap.size())
		{
			return true;
		}
		return false;
	}
	public void nullCheckString(String value) throws CustomException
	{
		if(value== null || value.isEmpty())
		{
			throw new CustomException("values can't be empty ");
		}
	}
	public String encryptPassword(String password) throws CustomException
	{
		String res="";
		for(int i=0;i< password.length();i++)
		{
			char ch=password.charAt(i);
			int num=(int)ch+1;
			res+=(char)num;
			
		}
		return res;
	}
	//1 - login
	public boolean studentLogin(String userName,String password) throws CustomException
	{
		nullCheckString(userName);
		nullCheckString(password);
		
		if(studentMap == null || !studentMap.containsKey(userName))
		{
			throw new CustomException("details are empty ");
		}
				
		StudentPojo pojo=studentMap.get(userName);
		if(userName.equals(pojo.getUserName()) && password.equals(pojo.getPassword()))
		{
			return true;
		}
		return false;
	}
	//2 editprofile
	public boolean editProfile(String name,StudentPojo student) throws CustomException
	{
				
		studentMap.put(name, student);
		return true;
	}
	
	//3- materials
	public String  materialsDownload(String teacherName,String studentName) throws CustomException
	{
		if(teacherMap == null || studentMap == null)
		{
			throw new CustomException("No materials are uploaded ");
		}
		String res="";
		TeacherPojo teach=teacherMap.get(teacherName);
		res+="/n"+teach.getMaterials();
		StudentPojo stud=studentMap.get(studentName);
		stud.setMaterials(res);
		stud.setMaterialType(teach.getMaterialType());
		return res;
	}
		
	//4 - questions 
	public boolean askQuestions(String username,String questions) throws CustomException
	{
		int size=quesMap.size();
		nullCheckString(username);
		nullCheckString(questions);
		questions.toLowerCase();
		quesMap.put(username, questions);
		int afterSize=quesMap.size();
		
		if(size != afterSize)
		{
			return true;
		}
		return false;
	}
	//5-1 get answer for respective question
	public String getAnswerforRespectiveQues(String username) throws CustomException
	{
		String val="";
		String result=quesMap.get(username);
		val+=ansMap.get(result);
		return val;
	}
	//5-answer of all questions
	public List<String> answerSeeking() throws CustomException
	{
		if(teacherMap == null)
		{
			throw new CustomException("Answer are not uploaded ");
		}
		List<String> list=new ArrayList<>();
		for(String value:ansMap.values())
		{
		  
		  list.add(value);	
		}
		return list;
		
	}
	
	
	//1-teacherSignup
	public boolean teacherSignUp(TeacherPojo teacher) throws CustomException
	{
		int size=teacherMap.size();
		teacherMap.put(teacher.getName(), teacher);
		
		if(size != teacherMap.size())
		{
			return true;
		}
		return false;
	}
	//2- teacher login
	public boolean teacherLogin(String userName,String password) throws CustomException
	{
		nullCheckString(userName);
		nullCheckString(password);
		
		if(teacherMap == null || !teacherMap.containsKey(userName))
		{
			throw new CustomException("details are empty ");
		}
				
		TeacherPojo pojo=teacherMap.get(userName);
		if(userName.equals(pojo.getName()) && password.equals(pojo.getPassword()))
		{
			return true;
		}
		return false;
	}
	//3-editProfile
	
	public boolean editTeacherDetails(TeacherPojo teach) throws CustomException
	{
	 
	
		teacherMap.put(teach.getName(), teach);
		return true;
	}
	//4-materials uploaded
	public boolean teacherMaterialsUploaded(String username,String materials,String materialType) throws CustomException
	{
		if(!teacherMap.containsKey(username))
		{
			return false;
		}
		TeacherPojo pojo=teacherMap.get(username);
		pojo.setMaterials(materials);
		pojo.setMaterialType(materialType);
		teacherMap.put(username,pojo);
		if(username.equals(pojo.getName()))
		{
		return true;
		}
		return false;
	}
	//5- doubts sessiocleared by teacher
    public List<String> questionsShowingToTeacher() throws CustomException
    {
    	List<String> list=new ArrayList<>();
    	for(String ques:quesMap.values())
    	{
    		list.add(ques);
    	}
    	if(list == null)
    	{
    		throw new CustomException("No questions are available ");
    	}
    	return list;
    }
    //5- 1 answer to doubts 
    String list="";
    public String answerToQuestions(String ques,String answerList) throws CustomException
    {
    	
    	ansMap.put(ques,answerList);
    	list+=answerList;
    	return list;
    }
	
	
	//1-Admin signup
    public boolean registerAdmin(AdminPojo admin) throws CustomException
    {
    	//int size=adminMap.size();
      	adminMap.put(admin.getUserName(), admin);
      	
      		return true;
      
      
    }
    public boolean adminLogin(String userName,String password) throws CustomException
    {
    	if(!adminMap.containsKey(userName))
    	{
    		throw new CustomException("SignUp first");
    	}
    	AdminPojo admin=adminMap.get(userName);
    	if(userName.equals(admin.getUserName()) && password.equals(admin.getPassword()))
    	{
    		return true;
    	}
    	return false;
    }
	//2-display list of students and faculty
    public String listOfStudentsorTeachers() throws CustomException
    {
    	String res="";
    	for(String value:studentMap.keySet())
    	{
    		res+=value+"/n";
    	}
    	
    	for(String value:teacherMap.keySet())
    	{
    		res+=value + "/n";
    	}
    	return res;
    }
    
    //3-display all question and answers
    public boolean deleteQuestions(String ques) throws CustomException
    {
    	for(Map.Entry<String,String> value:quesMap.entrySet())
    	{
    		if(value.getValue().equals(ques))
    		{
    			quesMap.remove(value.getKey());
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean deleteAnswer(String answer) throws CustomException
    {
    	for(Map.Entry<String,String> value:ansMap.entrySet())
    	{
    		if(value.getValue().equals(answer))
    		{
    			ansMap.remove(value.getKey());
    			return true;
    		}
    	}
    	return false;
    }  
  }  














