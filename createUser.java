import java.util.Scanner;
public class createUser {

	public static void main(String[] args) {

	   Scanner input = new Scanner(System.in);
	   
	   System.out.println("Please enter your first name: ");
	   String firstname = input.next();
	   
	   System.out.println("Please enter your last name: ");
	   String lastname = input.next();
	   
	   System.out.println("Please enter your StudentID: ");
	   String StudentID = input.next();
	   
	   System.out.println("Please enter a password ");
	   String password = input.next();
	   
	   System.out.println("Please enter your email: ");

	   boolean valid = false; 
	   String email; 
	   
	   //Here the system will check if a valid email was entered (an "@" is required)
	   
	   do {email = input.next();
	      for (int i = 0; i<email.length(); i++) {
	    	  if (email.charAt(i)=='@') {
	    		  valid = true;
	    	  }
	    		
	      }
	      if(valid==false) {
	    	      System.out.println("Invalid Email - please type in a correct one containing '@': ");	      
	      }
	   } while (valid == false);
	  	  boolean isAdministrator = false;
	      createUser(firstname, lastname, StudentID, password, email, isAdministrator);
	      
	      while(valid == false);
	      System.out.println("Congratulations - your account has been created ");
	}

	private static void createUser(String firstname, String lastname, String StudentID, String password, String email,
			boolean isAdministrator) {
		
	}
	   }
	   
	   
	   