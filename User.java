package Project;

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

	} // end of class
