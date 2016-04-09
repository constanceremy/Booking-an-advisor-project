package Project;

import java.util.Scanner;

public class Student extends User {
	
	private String studentTopic;
	private String studentID;

	// getter methods
	
	String getStudentTopic(){
		return studentTopic;
	}
	
	String getStudentID(){
		return studentID;
	}
	
	// setter methods

	void setStudentTopic(String topic){
		studentTopic = topic;
	}
	
	void setStudentID(String ID){
		studentID = ID;
	}


}
