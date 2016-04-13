package Project;

import java.util.Scanner;

public class Student extends User {
	
	private String studentTopic;
	private String studentID;
	private String studentEmail;

	// getter methods
	
	String getStudentTopic(){
		return studentTopic;
	}
	
	String getStudentID(){
		return studentID;
	}
	
	String getStudentEmail(){
		return studentEmail;
	}
	
	// setter methods

	void setStudentTopic(String topic){
		studentTopic = topic;
	}
	
	void setStudentID(String ID){
		studentID = ID;
	}
	
	void setStudentEmail(String email){
		studentEmail = email;
	}


}
