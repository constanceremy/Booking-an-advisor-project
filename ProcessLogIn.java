package Project;

import java.util.*;
import java.io.*;

public class ProcessLogIn {
	
	private static ArrayList<String[]> users = new ArrayList<String[]>();
	static String studentUsername = "";
	
	static Advisor advisor1 = new Advisor();
	static Advisor advisor2 = new Advisor();
	static Advisor advisor3 = new Advisor();
	static Advisor advisor4 = new Advisor();
	static Advisor advisor5 = new Advisor();
	static Advisor advisor6 = new Advisor();
	static Advisor advisor7 = new Advisor();
	static Advisor advisor8 = new Advisor();
	static Advisor advisor9 = new Advisor();
	
	static boolean logInAsStudent = false;
	static boolean logInAsAdvisor = false;
	
	
	public static void main (String[] args) {
	
		
		//creates the 9 advisor objects		
		advisor1.setAdvisorID("111");
		advisor1.setExpertise("Economics");
		advisor1.setFirstName("Zaedo");
		advisor1.setLastName("Musa");
		advisor1.setPassword("ZaedoMusa");
		
		advisor2.setAdvisorID("222");
		advisor2.setExpertise("Economics");
		advisor2.setFirstName("Constance");
		advisor2.setLastName("Remy");
		advisor2.setPassword("ConstanceRemy");
		
		advisor3.setAdvisorID("333");
		advisor3.setExpertise("Finance");
		advisor3.setFirstName("Sean");
		advisor3.setLastName("Kristensen");
		advisor3.setPassword("SeanKristensen");
		
		advisor4.setAdvisorID("444");
		advisor4.setExpertise("Finance");
		advisor4.setFirstName("Victoria");
		advisor4.setLastName("Terabyte");
		advisor4.setPassword("VictoriaTerabyte");
		
		advisor5.setAdvisorID("555");
		advisor5.setExpertise("Accounting");
		advisor5.setFirstName("Janna");
		advisor5.setLastName("Philipp");
		advisor5.setPassword("JannaPhilipp");
		
		advisor6.setAdvisorID("666");
		advisor6.setExpertise("Accounting");
		advisor6.setFirstName("Peter");
		advisor6.setLastName("Jensen");
		advisor6.setPassword("PeterJensen");
		
		advisor7.setAdvisorID("777");
		advisor7.setExpertise("Marketing");
		advisor7.setFirstName("Julie");
		advisor7.setLastName("Lo");
		advisor7.setPassword("JulieLo");
		
		advisor8.setAdvisorID("888");
		advisor8.setExpertise("Marketing");
		advisor8.setFirstName("Casper");
		advisor8.setLastName("Ghost");
		advisor8.setPassword("CasperGhost");
		
		advisor9.setAdvisorID("999");
		advisor9.setExpertise("Information Technology");
		advisor9.setFirstName("Donald");
		advisor9.setLastName("Trump");
		advisor9.setPassword("DonaldTrump");

		logInAndRegisterMethod();
		

	
	
} // END OF MAIN
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	public static void logInAndRegisterMethod() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Welcome to the EazyBook system - we'll help you find an advisor!");
		System.out.println("----------------------------------------------------------------");
		System.out.println("\nWhat would you like to do?\n1. Log-in \n2. Register (Students)");
		String menuOptionLogIn = "1"; // Choice is to log in
		String menuOptionRegister = "2"; // Choice is to register as student
		String menuNoInput = ""; // Choice is if user doesn't input any data and presses enter
		
		String userChoiceOne = ""; // Declaring variable 'choice' as early as possible
		
		Scanner input = new Scanner(System.in);
		userChoiceOne = input.nextLine();
		
		boolean userDecisionOne = false;
		
		while (!userDecisionOne) {
			if (userChoiceOne.equals(menuOptionLogIn)) { // This choice presents the user with the log-in menu
				logInMenu();
				userDecisionOne = true;
			}
		
			else if (userChoiceOne.equals(menuOptionRegister)) { // This choice presents the user with the registration menu
				createStudentAccount();
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
		
		} // closes while loop
	}	// closes logInAndRegisterMethod
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void createStudentAccount() {
			
			// Create a file instance
			File file = new File("C://Users//Zhagzi//users.txt");
			Scanner input = new Scanner(System.in);
			
			
			// Create a object of type PrintWriter  and FileOutputStream makes the text append previous text
			try (PrintWriter output = new PrintWriter(new FileOutputStream(file, true)); ){
				
			
		   System.out.println("Please enter your first name:");
		   String firstName = input.next();
		   
		   System.out.println("Please enter your last name:");
		   String lastName = input.next();
		   
		   System.out.println("Please enter your StudentID:");
		   String studentID = input.next();
		   
		   System.out.println("Please enter a password:");
		   String password = input.next();
		   		  
		   // Writes all input into a .txt file on the harddrive in special order	
		   output.println(studentID + " " + password + " " + firstName + " " + lastName) ;
		      
		      System.out.println("Congratulations - your account has been created ");
		      output.close();
		      boolean canLogIn = true;
		      if (canLogIn = true) {
		    	  logInMenu();
		      }
			} // Closes try
			
			catch (FileNotFoundException ex) {
				System.out.println("There has been no registration yet - to proceed please register an account.");
				logInAndRegisterMethod();
			}
			
	} // Closes createStudentAccount
	
	
	
	
	
	
	
	
	
	// A log-in method that is called when user wishes to log in rather than register. 
	public static void logInMenu() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nChoose either 1 or 2 to proceed. \n1. Log in as advisor \n2. Log in as student \n3. Go Back ");
		String userChoiceTwo; // Declaring user's choice as early on as possible
		boolean userDecisionTwo = false;
		
		
		String logInMenuAdvisor = "1"; //  Choose option 1 to log in as advisor
		String logInMenuStudent = "2"; // Choose option 2 to log in as student
		String logInMenuGoBack = "3"; // Option for user to go back to Log in or Register menu
		String logInMenuNoInput = ""; // This option is if the user doesn't input anything
		
		userChoiceTwo = input.nextLine();
		
		while (!userDecisionTwo) { // While loop for userChoiceTwo makes the menu appear until choice is valid
			if (userChoiceTwo.equals(logInMenuAdvisor)) {
				logInAsAdvisor();
				userDecisionTwo = true;
			}
			
			else if (userChoiceTwo.equals(logInMenuStudent)) {
				
				try {
				File file= new File("C://Users//Zhagzi//users.txt");
				Scanner readData = new Scanner(file);
				logInAsStudent();
				userDecisionTwo = true;
				}
				
				catch (FileNotFoundException ex) {
					System.out.println("There has been no registration yet - to proceed please register an account.\n");
					logInAndRegisterMethod();
				}
				
				}
			
			else if (userChoiceTwo.equals(logInMenuGoBack)) {
				logInAndRegisterMethod();
			}
			
			else if (userChoiceTwo.equals(logInMenuNoInput)) { 
				System.out.println("No input recognized. Please try again.\n1. Log in as advisor \n2. Log in as student \n3. Go Back "); 
				userChoiceTwo = input.nextLine();
			}
			
			else {
				System.out.println("Incorrect input. Please try again.\n1. Log in as advisor \n2. Log in as student \n3. Go Back ");
				userChoiceTwo = input.nextLine();
			}
			
		} // closes while loop
		
	} // closes logInMenu
	
	
	
	
	
	
	// the actual log in system method for the advisor
	public static void logInAsAdvisor() {
		String userName = "";
		String password = "";
		int counterTries = 0;
		int numberOfTries = 3;
		boolean loggedIn = false;
		
		Scanner input = new Scanner(System.in);
		
			while (!loggedIn) {	
			
				System.out.println("To log in as an advisor, please enter your username: ");
				userName = input.nextLine();
			
				System.out.println("Now enter your password: ");
				password = input.nextLine();
	
				if (advisor1.getAdvisorID().equals(userName) && advisor1.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor2.getAdvisorID().equals(userName) && advisor2.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor3.getAdvisorID().equals(userName) && advisor3.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor4.getAdvisorID().equals(userName) && advisor4.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor5.getAdvisorID().equals(userName) && advisor5.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor6.getAdvisorID().equals(userName) && advisor6.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor7.getAdvisorID().equals(userName) && advisor7.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor8.getAdvisorID().equals(userName) && advisor8.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else if (advisor9.getAdvisorID().equals(userName) && advisor9.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
				} else {
				// This is the false block, if either password or username doesn't fit
				System.out.println("You entered a wrong username or password. ");
					//if (counterTries == 1) {
						//System.out.print("OBS! You have 2 tries left\n");
				}
				
				
		} // Closes the while loop for countOfTries
	} // end of logInAsAdvisor Method

	
	
	
	
	
	
public static void whileLogInAsAdvisor() {
		
		while (logInAsAdvisor)	{
			int menuChoiceAdvisor1 = firstMenuChoiceAdvisor();

			// Show if there are any outstanding booking (aka bookings that have not been answered yet)
			// If yes, go through process. if not, say "You do not currently have any outstanding bookings. Thank you for checking!" + offer log out.
			// aka log out method
			if (menuChoiceAdvisor1 == 1) {
				System.out.println("Your booking is confirmed.");
				System.out.print("\n");
				// here need to keep booking in the file and say that is had been confirmed
				// ask if they want to log out?
			} else if (menuChoiceAdvisor1 == 2) {
				// here need to cancel the booking with which advisor logged in and which student booked (aka which time slot)
				cancel(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuChoiceAdvisor1);
				// does not do anything in file
			} else if (menuChoiceAdvisor1 == 3) {
				// log out method
					System.out.println("You are now logged out from the Advisor area. Thank you for using our program!"); 
			        logInAsAdvisor = false;
			}

		} // End of while-loop
	}// End of whileLogInAsAdvisor method
	
	
	

	
	

	// The actual log in system method - it is called when the user wishes to log in as student	
	public static void logInAsStudent() {
		String studentChooseToRegister = "2";
	
		LogInManager loginManager = new LogInManager();
		 
		 
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("-------------------------------------------");
		 System.out.println("OBS! If you haven't registered yet, press 2" );
		 System.out.println("-------------------------------------------\n");
		 System.out.println("Please insert your StudentID: ");
		 String insertStudentID = input.nextLine();
		 
		 if (insertStudentID.equals(studentChooseToRegister)) { // Gives the user a chance to create an account if none exists
			logInAndRegisterMethod();
		 }
		 
		 System.out.println("Please insert your password: ");
		 String insertPassword = input.nextLine();
		 
		 
		 if (loginManager.authorize(insertStudentID, insertPassword)) {
			 
			 System.out.println("You've succesfully logged in\n");
			 studentUsername = insertStudentID;
			 studentLoggedInMenuOne();
	     }
		 
		 else {
			 System.out.println("Wrong username or password input, please try again.");
			 logInAsStudent();
		 }
	
	
	}// closes logInAsStudent Method

	
	
	
	
	public static void whileLogInAsStudent() {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("\nThis is the list of available advisors to you: ");
		System.out.println("-----------------------------------------------");
		System.out.println("Current logged in StudentID is: " + studentUsername);
		System.out.println("-----------------------------------------------");

		
	 // print advisor choices based on student's topic
		// or when student logs in, create array with data from student. that way we can now his thesis topic.
		// will be something like getStudentTopic etc.
				
					System.out.println("1. " + advisor1.getFirstName() + " " + advisor1.getLastName() + " is researching in: " + advisor1.getExpertise());
					System.out.println("2. " + advisor2.getFirstName() + " " + advisor2.getLastName() + " is researching in: " + advisor2.getExpertise());
					System.out.println("\n");
					System.out.println("3. " + advisor3.getFirstName() + " " + advisor3.getLastName() + " is researching in: " + advisor3.getExpertise());
					System.out.println("4. " + advisor4.getFirstName() + " " + advisor4.getLastName() + " is researching in: " + advisor4.getExpertise());
					System.out.println("\n");
					System.out.println("5. " + advisor5.getFirstName() + " " + advisor5.getLastName() + " is researching in: " + advisor5.getExpertise());
					System.out.println("6. " + advisor6.getFirstName() + " " + advisor6.getLastName() + " is researching in: " + advisor6.getExpertise());
					System.out.println("\n");
					System.out.println("7. " + advisor7.getFirstName() + " " + advisor7.getLastName() + " is researching in: " + advisor7.getExpertise());
					System.out.println("8. " + advisor8.getFirstName() + " " + advisor8.getLastName() + " is researching in: " + advisor8.getExpertise());
					System.out.println("\n");
					System.out.println("9. " + advisor9.getFirstName() + " " + advisor9.getLastName() + " is researching in: " + advisor9.getExpertise());
	
	
	System.out.println("---------------------------------------");
	System.out.println("\nWhich advisor would you like to book?");
	String menuStudentChoiceOfAdvisor = input.nextLine();
		
		
		while (logInAsStudent)		{	
			// if student has booking already, show it here. GET DATA IN ARRAYLIST
			// should not be able to book another advisor if already has booking/has booking pending
			
								
				
				
				
				if (menuStudentChoiceOfAdvisor.equals("1")) {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("2"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("3"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					}
				
				else if (menuStudentChoiceOfAdvisor.equals("4"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("5"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					}
				
				else if (menuStudentChoiceOfAdvisor.equals("6"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("7"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					}

				else if (menuStudentChoiceOfAdvisor.equals("8"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("9"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					break;
					}
				
				else {
					System.out.println("Invalid input. Please try again \n");
					System.out.println("\n---------------------------------------");
					System.out.println("1. " + advisor1.getFirstName() + " " + advisor1.getLastName() + " is researching in: " + advisor1.getExpertise());
					System.out.println("2. " + advisor2.getFirstName() + " " + advisor2.getLastName() + " is researching in: " + advisor2.getExpertise());
					System.out.println("\n");
					System.out.println("3. " + advisor3.getFirstName() + " " + advisor3.getLastName() + " is researching in: " + advisor3.getExpertise());
					System.out.println("4. " + advisor4.getFirstName() + " " + advisor4.getLastName() + " is researching in: " + advisor4.getExpertise());
					System.out.println("\n");
					System.out.println("5. " + advisor5.getFirstName() + " " + advisor5.getLastName() + " is researching in: " + advisor5.getExpertise());
					System.out.println("6. " + advisor6.getFirstName() + " " + advisor6.getLastName() + " is researching in: " + advisor6.getExpertise());
					System.out.println("\n");
					System.out.println("7. " + advisor7.getFirstName() + " " + advisor7.getLastName() + " is researching in: " + advisor7.getExpertise());
					System.out.println("8. " + advisor8.getFirstName() + " " + advisor8.getLastName() + " is researching in: " + advisor8.getExpertise());
					System.out.println("\n");
					System.out.println("9. " + advisor9.getFirstName() + " " + advisor9.getLastName() + " is researching in: " + advisor9.getExpertise());
	
	
					System.out.println("\n---------------------------------------");
					System.out.println("\nWhich advisor would you like to book?");
					menuStudentChoiceOfAdvisor = input.nextLine();
				}
				
//				else if (menuChoiceStudent1 == 2) {
//				// add all advisors
//				cancel(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuChoiceStudent1);
//					} 
//				
//				else if (menuChoiceStudent1 == 3) {
//				System.out.println("You are now logged out from the Student area. Thank you for using our program!");
//		        boolean logInAsStudent = false;
//					}
			
		}// End of while-loop
	}// End of whileLogInAsStudent method
	
	
	
	


	
	public static void studentLoggedInMenuOne() {
		
		boolean correctInput = false;
		Scanner input = new Scanner(System.in);
		String menuOptionBooking = "1";
		String menuOptionCancel = "2";
		String menuOptionLogOut = "3";
		
		System.out.println("-------------------------------");
		System.out.println("Welcome to EazyBook");
		System.out.println("-------------------------------");
		
		System.out.println("Please select an option. Type 1, 2 or 3 \n1. Make a new booking with an advisor \n2. Cancel a booking \n3. Log out");	
		String menuChoiceStudent1 = input.nextLine();
		
		while (!correctInput) {
			
			if (menuChoiceStudent1.equals("1")) {
				logInAsStudent = true;
				whileLogInAsStudent();
				correctInput = true;
				
			}
			
			else if (menuChoiceStudent1.equals("2")) {
				System.out.println("Function not ready yet");
				menuChoiceStudent1 = input.nextLine();
			}
			
			else if (menuChoiceStudent1.equals("3")) {
				logInAndRegisterMethod();
				correctInput = true;
			}
			
			else {
				System.out.println("Invalid input. Please try again \n1. Make a new booking with an advisor \n2. Cancel a booking \n3. Log out");
				menuChoiceStudent1 = input.nextLine();
			}
			
		}// While
	}// logInAsStudent
		
	
	
	
	
	
	
	
	
	
	

//	
				
				

	
	
	
	
	
	
	
	
	// Menu once the advisor has logged in
	public static int firstMenuChoiceAdvisor() {
				System.out.println("Please select an option. Type 1, 2 or 3");
				System.out.println("1: Accept booking by student");				
				System.out.println("2: Reject booking by student");
				System.out.println("3: Log out");
				Scanner input = new Scanner(System.in);
				int menuChoiceAdvisor1 = input.nextInt();
				return menuChoiceAdvisor1;
	} // method firstMenuChoiceAdvisor
	
	
	
	
	
	
	
	public static void booking(Advisor advisor1, Advisor advisor2, Advisor advisor3, Advisor advisor4, Advisor advisor5, 
			Advisor advisor6, Advisor advisor7, Advisor advisor8, Advisor advisor9, String advisorChoice){
		/*This void method books the room slot by calling method from the Room class called "makeBooking() on the three objects. Three reference variable of Room e.g room1, room2 and room3 is sent 
		  to this method and one integer variable which is the type of room e.g 1 is for Extreme programming	*/	
			switch (advisorChoice){
				case "1" :advisor1.makeBooking(); break;
			    case "2" :advisor2.makeBooking(); break;
			    case "3" :advisor3.makeBooking(); break;
			    case "4" :advisor4.makeBooking(); break;
			    case "5" :advisor5.makeBooking(); break;
			    case "6" :advisor6.makeBooking(); break;
			    case "7" :advisor7.makeBooking(); break;
			    case "8" :advisor8.makeBooking(); break;
			    case "9" :advisor9.makeBooking(); break;
			}//switch
	}//end of makeBooking
	
	
	
	
	
	public static void cancel(Advisor advisor1, Advisor advisor2, Advisor advisor3, Advisor advisor4, Advisor advisor5, 
			Advisor advisor6, Advisor advisor7, Advisor advisor8, Advisor advisor9, int advisorChoice){
		/*This method cancels the room slot by calling method from the Room class called "canceBooking() on the three objects. Three reference variable of Room e.g room1, room2 and room3 is sent 
		 to this method and one integer variable which is the type of room e.g 1 is for Extreme programming	*/
			switch (advisorChoice){
			case 1 : advisor1.cancelBooking(); break;
		    case 2  :advisor2.cancelBooking(); break;
		    case 3  :advisor3.cancelBooking(); break;
		    case 4  :advisor4.cancelBooking(); break;
		    case 5  :advisor5.cancelBooking(); break;
		    case 6  :advisor6.cancelBooking(); break;
		    case 7  :advisor7.cancelBooking(); break;
		    case 8  :advisor8.cancelBooking(); break;
		    case 9  :advisor9.cancelBooking(); break;
			}//switch	
		}//end of cancelBooking

} // end of Process
