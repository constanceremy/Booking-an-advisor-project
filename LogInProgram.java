package LogIn;
import java.util.*;
import java.io.*;

public class LogInProgram {

	public static void main(String[] args) throws IOException {
	
		System.out.print("What would you like to do?\n1. Log-in \n2. Register (Students) ");
		String menuOptionLogIn = "1"; // Choice is to log in
		String menuOptionRegister = "2"; // Choice is to register as student
		String menuNoInput = ""; // Choice is if user doesn't input any data and presses enter
		
		String userChoiceOne = ""; // Declaring variable 'choice' as early as possible
		
		Scanner input = new Scanner(System.in);
		userChoiceOne = input.nextLine();
		boolean userDecisionOne = false;
		
		while (!userDecisionOne) {
			if (userChoiceOne.equals(menuOptionLogIn)) { // This choice presents the user with the log-in menu
				LogInMenu();
				userDecisionOne = true;
			}
		
			else if (userChoiceOne.equals(menuOptionRegister)) { // This choice presents the user with the registration menu
				createUserMenu();
				userDecisionOne = true;
			}
			
			else if (userChoiceOne.equals(menuNoInput)) { // Prompts this conditional if there's no input at all
				System.out.println("No input recognized. Please try again.\n1. Log-in \n2. Register (Students) ");
				userChoiceOne = input.nextLine();
			}
		
			else { // This message is prompted if the input is not valid e.g letters or anything but 1 or 2 
				System.out.println("Incorrect input. Please try again.\n1. Log-in \n2. Register (Students) ");
				userChoiceOne = input.nextLine();
			}
		
		}
	}
	
	
	
	public static void createUserMenu() throws IOException {
		
		// Create a file instance
		java.io.File file = new java.io.File("C:\\Users\\Zhagzi\\Documents\\userdatabase.txt");
		Scanner input = new Scanner(System.in);
		//String lineSeparator = System.getProperty("line.separator");
		
		// Create a file
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
	   System.out.println("Please enter your first name: " + System.getProperty("line.separator"));
	   String firstName = input.next();
	   output.println(firstName);
	   
	   
	   System.out.print("Please enter your last name: ");
	   String lastName = input.next();
	   output.println(lastName);
	   
	   System.out.println("Please enter your StudentID: ");
	   String StudentID = input.next();
	   output.println(StudentID);
	   
	   System.out.println("Please enter a password: ");
	   String password = input.next();
	   output.println(password);
	   
	   System.out.println("Please enter your email: ");

	   boolean emailValid = false; 
	   String email; 
	   
	   //Here the system will check if a valid email was entered (an "@" is required)
	   
	   do {email = input.next();
	      for (int i = 0; i<email.length(); i++) {
	    	  if (email.charAt(i)=='@') {
	    		  emailValid = true;
	    		  output.print(email);
	    	  }
	    		
	      }
	      if(!emailValid) {
	    	      System.out.println("Invalid Email - please type in a correct one containing '@': ");	      
	      }
	   } while (!emailValid);
	   
	   
	  	  boolean isAdministrator = false;
	      createUserAccount(firstName, lastName, StudentID, password, email, isAdministrator);
	      
	      //while(!emailValid);
	      System.out.println("Congratulations - your account has been created ");
	      output.close();
	}

	
	// Method called createUserAccount
	private static void createUserAccount(String firstName, String lastName, String StudentID, String password, String email,
			boolean isAdministrator) {
		
	} 
	
	
	
	// A log-in method that is called when user wishes to log in rather than register. 
	public static void LogInMenu() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nChoose either 1 or 2 to proceed. \n1. Log in as advisor \n2. Log in as student ");
		String userChoiceTwo; // Declaring user's choice as early on as possible
		boolean userDecisionTwo = false;
		
		
		String logInMenuAdvisor = "1"; //  Choose option 1 to log in as advisor
		String logInMenuStudent = "2"; // Choose option 2 to log in as student
		String logInMenuNoInput = ""; // This option is if the user doesn't input anything
		
		userChoiceTwo = input.nextLine();
		
		while (!userDecisionTwo) { // While loop for userChoiceTwo makes the menu appear until choice is valid
			if (userChoiceTwo.equals(logInMenuAdvisor)) {
				userDecisionTwo = true;
			}
			
			else if (userChoiceTwo.equals(logInMenuStudent)) {
				LogInAsStudent();
				userDecisionTwo = true;
			}
			
			else if (userChoiceTwo.equals(logInMenuNoInput)) { 
				System.out.println("No input recognized. Please try again.\n1. Log-in \n2. Register (Students) "); 
				userChoiceTwo = input.nextLine();
			}
			
			else {
				System.out.println("Incorrect input. Please try again.\n1. Log in as advisor \n2. Log in as student ");
				userChoiceTwo = input.nextLine();
			}
			
		}
		
	}
	
	
	// The actual log in system method - it is called when the user wishes to log in as student
	public static void LogInAsStudent() {
		
			// Create a File instance
			java.io.File file = new java.io.File("C:\\Users\\Zhagzi\\Documents\\userdatabase.txt");
					
			try {
			// Create a Scanner to read data
			Scanner readData = new Scanner(file);
					
						
			String storeFirstName = readData.nextLine();
			String storedLastName = readData.next();
			String storedStudentID = readData.next();
			String storedPassword = readData.next();
			String storeEmail = readData.next();
		
		
		// Used for holding input from the user
		String userName = "";
		String password = "";
		
		
		// Create a scanner that reads the user input
		Scanner input = new Scanner(System.in);
		
		
		int counterTries = 0;
		int numberOfTries = 3;
		boolean loggedIn = false;
		
		
		while ((counterTries < numberOfTries) && !loggedIn) {	
			
			
			// Telling the user how many tries it has left to enter valid username or password
			if (counterTries == 1) {
				System.out.println("OBS! You have 2 attempts left. ");
			}
			
			else if (counterTries == 2) {
				System.out.println("OBS! You have 1 attempt left. ");
			}
			
		
			counterTries++; // Counts the user tries to log-in, up till 3 attempts total
			// Prompts user to enter log-in credentials
			System.out.println("To log in as student, please enter your username: ");
			userName = input.nextLine();
		
			
			System.out.println("Now enter your password: ");
			password = input.nextLine();
		
			
			// Check if the password and username are correct (.length() or .equalsIgnoreCase() are both methods made for the String object. Chapter 4!
			if (userName.equalsIgnoreCase(storedStudentID) && password.equalsIgnoreCase(storedPassword)) {
			// This is the true block
			System.out.println("You have succesfully logged in...");
			loggedIn = true;
			}
			
			else {
			// This is the false block, if either password or username doesn't fit
			System.out.println("You entered a wrong username or password. ");
				//if (counterTries == 1) {
					//System.out.print("OBS! You have 2 tries left\n");
				}
			
			if (counterTries == 3) {
				System.out.println("You've unsuccesfully logged in for 3 attempts, the program is closed now. ");
			}
			
		} // Closes the while loop for countOfTries
				
		
		
	} // Closes the try function
	
	catch (FileNotFoundException ex) {
		System.out.println("File not found.");
	}
}
}