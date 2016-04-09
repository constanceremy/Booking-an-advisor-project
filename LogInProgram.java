package LogIn;
import java.util.*;

public class LogInProgram {

	public static void main(String[] args) {
	
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
				System.out.println("Thank you and goodbye.");
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
				LogIn();
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
	
	
	
	
	public static void LogIn() {
		
		String systemUserName = "admin";
		String systemPassword = "1234";
		
		
		
		// Used for holding input from the user
		String userName = "";
		String password = "";
		
		
		// Create a scanner that reads the user input
		Scanner input = new Scanner(System.in);
		
		
		int counterTries = 0;
		int numberOfTries = 3;
		boolean loggedIn = false;
		//do {
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
			if (userName.equalsIgnoreCase(systemUserName) && password.equalsIgnoreCase(systemPassword)) {
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
			
		}
	}
}