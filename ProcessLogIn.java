package Project;

import java.util.*;
import java.io.*;

public class ProcessLogIn {
	
	private static ArrayList<String[]> users = new ArrayList<String[]>();
	public static ArrayList<String[]> bookingList = new ArrayList<String[]>();
	
	static String studentUsername;
//	static String studentFirstName;
//	static String studentLastName;
	static String advisorID = "";
	static String currentAdvisorID = "";
	static String currentAdvisorFirstName = "";
	static String currentAdvisorLastName = "";

	
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
		advisor1.setAdvisorID("111"); advisor1.setExpertise("Economics"); advisor1.setFirstName("Zaedo");
		advisor1.setLastName("Musa"); advisor1.setPassword("ZaedoMusa");
		
		advisor2.setAdvisorID("222"); advisor2.setExpertise("Economics"); advisor2.setFirstName("Constance");
		advisor2.setLastName("Remy"); advisor2.setPassword("ConstanceRemy");
		
		advisor3.setAdvisorID("333"); advisor3.setExpertise("Finance"); advisor3.setFirstName("Sean");
		advisor3.setLastName("Kristensen"); advisor3.setPassword("SeanKristensen");
		
		advisor4.setAdvisorID("444"); advisor4.setExpertise("Finance"); advisor4.setFirstName("Victoria");
		advisor4.setLastName("Terabyte"); advisor4.setPassword("VictoriaTerabyte");
		
		advisor5.setAdvisorID("555"); advisor5.setExpertise("Accounting"); advisor5.setFirstName("Janna");
		advisor5.setLastName("Philipp"); advisor5.setPassword("JannaPhilipp");
		
		advisor6.setAdvisorID("666"); advisor6.setExpertise("Accounting"); advisor6.setFirstName("Peter"); 
		advisor6.setLastName("Jensen"); advisor6.setPassword("PeterJensen");
		
		advisor7.setAdvisorID("777"); advisor7.setExpertise("Marketing"); advisor7.setFirstName("Julie");
		advisor7.setLastName("Lo"); advisor7.setPassword("JulieLo");
		
		advisor8.setAdvisorID("888"); advisor8.setExpertise("Marketing"); advisor8.setFirstName("Casper"); 
		advisor8.setLastName("Ghost"); advisor8.setPassword("CasperGhost");
		
		advisor9.setAdvisorID("999"); advisor9.setExpertise("Information Technology"); advisor9.setFirstName("Donald");
		advisor9.setLastName("Trump"); advisor9.setPassword("DonaldTrump");

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
	
	

	
//	public static void addBooking() {
//		String[] booking = { ProcessLogIn.studentUsername, advisorID, emptySlot };
////		System.out.println(studentUsername + " " + advisorID + " " + studentSlot);
//		ProcessLogIn.bookingList.add(booking);
//	}
	
	
	
	
	
	
	
	
	public static void createStudentAccount() {
			
			// Create a file instance
			File file = new File("users.txt");
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
				File file= new File("users.txt");
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
					currentAdvisorID = "111";
					whileLogInAsAdvisor();
				} else if (advisor2.getAdvisorID().equals(userName) && advisor2.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "222";
					whileLogInAsAdvisor();
				} else if (advisor3.getAdvisorID().equals(userName) && advisor3.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "333";
					whileLogInAsAdvisor();
				} else if (advisor4.getAdvisorID().equals(userName) && advisor4.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "444";
					whileLogInAsAdvisor();
				} else if (advisor5.getAdvisorID().equals(userName) && advisor5.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "555";
					whileLogInAsAdvisor();
				} else if (advisor6.getAdvisorID().equals(userName) && advisor6.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "666";
					whileLogInAsAdvisor();
				} else if (advisor7.getAdvisorID().equals(userName) && advisor7.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "777";
					whileLogInAsAdvisor();
				} else if (advisor8.getAdvisorID().equals(userName) && advisor8.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "888";
					whileLogInAsAdvisor();
				} else if (advisor9.getAdvisorID().equals(userName) && advisor9.getPassword().equals(password)) {
					loggedIn = true;
					logInAsAdvisor = true;
					System.out.println("You have successfully logged in...");
					currentAdvisorID = "999";
					whileLogInAsAdvisor();
				} else {
				// This is the false block, if either password or username doesn't fit
				System.out.println("You entered a wrong username or password. ");
					//if (counterTries == 1) {
						//System.out.print("OBS! You have 2 tries left\n");
				}
				
				
		} // Closes the while loop for countOfTries
	} // end of logInAsAdvisor Method

	
	
	
	
	
	
public static void whileLogInAsAdvisor() {
	
	Scanner input = new Scanner(System.in);
		
		while (logInAsAdvisor)	{

			
			for(int i = 0; i < bookingList.size(); i++) {
				if (bookingList.get(i)[1].equals(currentAdvisorID)) {
					System.out.println("You have a booking with " + bookingList.get(i)[0]);
				}
				else {
					System.out.println("You do not have any bookings. Please come back later.");
				}
			}
			
			if ((bookingList.size()) == 0) {
				System.out.println("You do not have any bookings. Please come back later.");
			}
			
			System.out.println("When you are done reviewing your bookings, please select option 1");
			System.out.println("1: Log out");
			String menuChoiceAdvisor = input.nextLine();
			
			if (menuChoiceAdvisor.equals("1")) {
					System.out.println("You are now logged out from the Advisor area. Thank you for using our program!"); 
			        logInAsAdvisor = false;
			        logInAndRegisterMethod();
			} 
			else {
				System.out.println("Invalid input. Please try again. Select option 1");
				System.out.println("1: Log out");
				menuChoiceAdvisor = input.nextLine();

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
			 
//			 for (int i = 0; i < LogInManager.users.size(); i++) {
//					if (LogInManager.users.get(i)[0].equals(studentUsername)) {
//						
//						studentFirstName = LogInManager.users.get(i)[2];
//						studentLastName = LogInManager.users.get(i)[3];
//					}
//					System.out.println(studentLastName + studentFirstName);
//
//
//			}
			 
//			 LogInManager account3 = new LogInManager();
//			 
//			 if (account3.authorize(studentUsername)) {
//			 
//				 for (String[] account : LogInManager.users) {
//						if (account[0].equals(studentUsername)) {
//							studentFirstName = account[2];
//							studentLastName = account[3];
//						}
//					}
//					
//				 System.out.println(studentFirstName + studentLastName);
//
//			 }
//			 
//			 

					studentLoggedInMenu();
				
			 } // end of of if login manager authorize
		 else {
			 System.out.println("Wrong username or password input, please try again.");
			 logInAsStudent();
		 }
	
	
	}// closes logInAsStudent Method

	public static boolean verifyStudentBooking(String studentUsername) {
		boolean result = false;
		
		for (String[] booking : bookingList) {
			if (booking[0].equals(studentUsername))
				result = true;
		}
		return result;
	}
	
	
	public static void studentLoggedInMenu() {
		
		boolean correctInput = false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("-------------------------------");
		System.out.println("Welcome to EazyBook");
		System.out.println("-------------------------------");
		
		
		while (!correctInput) {
			
			if (!verifyStudentBooking(studentUsername)) {
				
				System.out.println("Please select an option. Type 1, or 2 \n1. Make a new booking with an advisor \n2. Log out");	
				String menuChoiceStudent1 = input.nextLine();

				
				if (menuChoiceStudent1.equals("1")) {
					logInAsStudent = true;
					makeABooking();
					correctInput = true;
					
				} else if (menuChoiceStudent1.equals("2")) {
					logInAndRegisterMethod();
					correctInput = true;
				} else {
					System.out.println("Invalid input. Please try again \n1. Make a new booking with an advisor \n2. Log out");
					menuChoiceStudent1 = input.nextLine();
				}
			}
			
			else {
				
				for(int i = 0; i < bookingList.size(); i++) {
				System.out.println("Booking: student is: " + bookingList.get(i)[0] +  " and advisorID is: " + bookingList.get(i)[1] + 
						"and the name is " + bookingList.get(i)[2] + bookingList.get(i)[3] + " at time Slot: " + bookingList.get(i)[4]);
				}// want to print the array list to see it temp
				
				
				for (int i = 0; i < bookingList.size(); i++) {
					if (studentUsername.equals(bookingList.get(i)[0])) {
						System.out.println("You have a booking with " + bookingList.get(i)[2] + " " + bookingList.get(i)[3]);
					}
				}
				
				System.out.println("Please select an option. Type 1, or 2 \n1. Cancel my booking \n2. Log out");	
				String menuChoiceStudent1 = input.nextLine();


				if (menuChoiceStudent1.equals("1")) {
				logInAsStudent = true;
				cancelABooking();
//				menuChoiceStudent1 = input.nextLine();
				}
				
				else if (menuChoiceStudent1.equals("2")) {
					logInAndRegisterMethod();
					correctInput = true;
				}
				
				else {
					System.out.println("Invalid input. Please try again \n1. Make a new booking with an advisor \n2. Cancel a booking \n3. Log out");
					menuChoiceStudent1 = input.nextLine();
				}
			}
			
		}// While
	}// end of studentLoggedInMenu
	
	
	public static void makeABooking() {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("\nThis is the list of available advisors to you: ");
		System.out.println("-----------------------------------------------");
		System.out.println("Current logged in StudentID is: " + studentUsername);
		System.out.println("-----------------------------------------------");
		
		// here need options to cancel booking!!!!

		
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
					advisorID = "111";
					break;
				}
				
				else if (menuStudentChoiceOfAdvisor.equals("2"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "222";
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("3"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "333";
					break;
					}
				
				else if (menuStudentChoiceOfAdvisor.equals("4"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "444";
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("5"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "555";
					break;
					}
				
				else if (menuStudentChoiceOfAdvisor.equals("6"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "666";
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("7"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "777";
					break;
					}

				else if (menuStudentChoiceOfAdvisor.equals("8"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "888";
					break;
					} 
				
				else if (menuStudentChoiceOfAdvisor.equals("9"))  {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuStudentChoiceOfAdvisor);
					advisorID = "999";
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

			
		}// End of while-loop
		
		studentLoggedInMenu();	
	}// End of makeABooking method
	
	
	
	
	public static void booking(Advisor advisor1, Advisor advisor2, Advisor advisor3, Advisor advisor4, Advisor advisor5, 
			Advisor advisor6, Advisor advisor7, Advisor advisor8, Advisor advisor9, String advisorChoice){
		/*This void method books the room slot by calling method from the Room class called "makeBooking() on the three objects. Three reference variable of Room e.g room1, room2 and room3 is sent 
		  to this method and one integer variable which is the type of room e.g 1 is for Extreme programming	*/	
			switch (advisorChoice){
				case "1" : currentAdvisorID = advisor1.getAdvisorID(); currentAdvisorFirstName = advisor1.getFirstName(); 
					currentAdvisorLastName = advisor1.getLastName(); advisor1.makeBooking(); break; 
			    case "2" : currentAdvisorID = advisor2.getAdvisorID(); currentAdvisorFirstName = advisor2.getFirstName(); 
			    	currentAdvisorLastName = advisor2.getLastName(); advisor2.makeBooking(); break;
			    case "3" : currentAdvisorID = advisor3.getAdvisorID(); currentAdvisorFirstName = advisor3.getFirstName(); 
			    	currentAdvisorLastName = advisor3.getLastName(); advisor3.makeBooking(); break;
			    case "4" : currentAdvisorID = advisor4.getAdvisorID(); currentAdvisorFirstName = advisor4.getFirstName(); 
			    	currentAdvisorLastName = advisor4.getLastName(); advisor4.makeBooking(); break;
			    case "5" : currentAdvisorID = advisor5.getAdvisorID(); currentAdvisorFirstName = advisor5.getFirstName(); 
			    	currentAdvisorLastName = advisor5.getLastName(); advisor5.makeBooking(); break;
			    case "6" : currentAdvisorID = advisor6.getAdvisorID(); currentAdvisorFirstName = advisor6.getFirstName(); 
			    	currentAdvisorLastName = advisor6.getLastName(); advisor6.makeBooking(); break;
			    case "7" : currentAdvisorID = advisor7.getAdvisorID(); currentAdvisorFirstName = advisor7.getFirstName(); 
			    	currentAdvisorLastName = advisor7.getLastName(); advisor7.makeBooking(); break;
			    case "8" : currentAdvisorID = advisor8.getAdvisorID(); currentAdvisorFirstName = advisor8.getFirstName(); 
			    	currentAdvisorLastName = advisor8.getLastName(); advisor8.makeBooking(); break;
			    case "9" : currentAdvisorID = advisor9.getAdvisorID(); currentAdvisorFirstName = advisor9.getFirstName(); 
			    	currentAdvisorLastName = advisor9.getLastName(); advisor9.makeBooking(); break;
			}//switch
	}//end of makeBooking
	
	
	
	
	
	public static void cancelABooking() {
		if (logInAsStudent)		{
			for(int i = 0; i < bookingList.size(); i++) {
				if (bookingList.get(i)[0] == studentUsername) {
					if (bookingList.get(i)[1].equals("111")) {
						System.out.println("You were booked with " + advisor1.getFirstName() + " " + advisor1.getLastName()+ " in "
								+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor1.isBooked[0] = "0";	
								bookingList.remove(i);
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor1.isBooked[1] = "0";		
								bookingList.remove(i);
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor1.isBooked[2] = "0";	
								bookingList.remove(i);
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor1.isBooked[3] = "0";	
								bookingList.remove(i);
							}
					}
					else if (bookingList.get(i)[1].equals("222")) {
						System.out.println("You were booked with " + advisor2.getFirstName() + " " + advisor2.getLastName()+ " in "
								+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor2.isBooked[0] = "0";						
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor2.isBooked[1] = "0";		
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor2.isBooked[2] = "0";	
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor2.isBooked[3] = "0";	
							}
					
					}
					else if (bookingList.get(i)[1].equals("333")) {
						System.out.println("You were booked with " + advisor3.getFirstName() + " " + advisor3.getLastName()+ " in "
								+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor3.isBooked[0] = "0";						
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor3.isBooked[1] = "0";		
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor3.isBooked[2] = "0";	
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor3.isBooked[3] = "0";	
							}
					}
					else if (bookingList.get(i)[1].equals("444")) {
						System.out.println("You were booked with " + advisor4.getFirstName() + " " + advisor4.getLastName()+ " in "
								+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor4.isBooked[0] = "0";						
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor4.isBooked[1] = "0";		
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor4.isBooked[2] = "0";	
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor4.isBooked[3] = "0";	
							}
					}
					else if (bookingList.get(i)[1].equals("555")) {
						System.out.println("You were booked with " + advisor5.getFirstName() + " " + advisor5.getLastName()+ " in "
								+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor5.isBooked[0] = "0";						
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor5.isBooked[1] = "0";		
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor5.isBooked[2] = "0";	
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor5.isBooked[3] = "0";	
							}
					}
					else if (bookingList.get(i)[1].equals("666")) {
						System.out.println("You were booked with " + advisor6.getFirstName() + " " + advisor6.getLastName() + " in "
						+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor6.isBooked[0] = "0";						
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor6.isBooked[1] = "0";		
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor6.isBooked[2] = "0";	
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor6.isBooked[3] = "0";	
							}
					}
					else if (bookingList.get(i)[1].equals("777")) {
						System.out.println("You were booked with " + advisor7.getFirstName() + " " + advisor7.getLastName() + " in "
						+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
							if (bookingList.get(i)[4] == "Slot1") {
								advisor7.isBooked[0] = "0";						
							}
							else if (bookingList.get(i)[4] == "Slot2") {
								advisor7.isBooked[1] = "0";		
							}
							else if (bookingList.get(i)[4] == "Slot3") {
								advisor7.isBooked[2] = "0";	
							}
							else if (bookingList.get(i)[4] == "Slot4") {
								advisor7.isBooked[3] = "0";	
							}
					}
					else if (bookingList.get(i)[1].equals("888")) {
						System.out.println("You were booked with " + advisor8.getFirstName() + " " + advisor8.getLastName() + " in "
						+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot1") {
							advisor8.isBooked[0] = "0";						
						}
						else if (bookingList.get(i)[4] == "Slot2") {
							advisor8.isBooked[1] = "0";		
						}
						else if (bookingList.get(i)[4] == "Slot3") {
							advisor8.isBooked[2] = "0";	
						}
						else if (bookingList.get(i)[4] == "Slot4") {
							advisor8.isBooked[3] = "0";	
						}
					}
					else if (bookingList.get(i)[1].equals("999")) {
						System.out.println("You were booked with " + advisor9.getFirstName() + " " + advisor9.getLastName()+ " in "
								+ bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot1") {
							advisor9.isBooked[0] = "0";						
						}
						else if (bookingList.get(i)[4] == "Slot2") {
							advisor9.isBooked[1] = "0";		
						}
						else if (bookingList.get(i)[4] == "Slot3") {
							advisor9.isBooked[2] = "0";	
						}
						else if (bookingList.get(i)[4] == "Slot4") {
							advisor9.isBooked[3] = "0";	
						}
					}
				}
				
				for (int j = 0; j < bookingList.size(); j++) {
					if (bookingList.get(j)[0].equals(studentUsername)) {
						bookingList.remove(j);
					}
				}
				
				studentLoggedInMenu();
							
			} // end of for loop
			
		} // end of if logInAsStudent
	} // end of cancel a Booking method

	



} // end of Process
