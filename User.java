package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {

	private String firstName;
	private String lastName;
	private String password;
	
	// getter methods
	String getFirstName(){
		return firstName;
	}
	
	String getLastName(){
		return lastName;
	}

	String getPassword(){
		return password;
	}
	
	// setter methods
	void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	void setPassword(String password){
		this.password = password;
	}
	
	public String toString() {
		return "Student name: " + ProcessLogIn.studentFullName;
		
	}
	

} // user class
















	












