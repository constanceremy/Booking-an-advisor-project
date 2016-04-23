package Project;

import java.util.Scanner;

public class Student extends User {
	
	private String studentID;
	
	// getter methods
	
	String getStudentID(){
		return studentID;
	}
	

	
	// setter methods
	
	void setStudentID(String ID){
		studentID = ID;
	}
	
	public String toString() {
		return super.toString() + " and studentID is: " + ProcessLogIn.studentUsername;
	}
	
	
	
} // student class