package Project;

import java.util.*;
import java.io.*;

public class ProcessLogIn {
	
	static Advisor advisor1 = new Advisor();
	static Advisor advisor2 = new Advisor();
	static Advisor advisor3 = new Advisor();
	static Advisor advisor4 = new Advisor();
	static Advisor advisor5 = new Advisor();
	static Advisor advisor6 = new Advisor();
	static Advisor advisor7 = new Advisor();
	static Advisor advisor8 = new Advisor();
	static Advisor advisor9 = new Advisor();
	public static ArrayList advisorList = new ArrayList();
	
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
		advisor9.setExpertise("IT");
		advisor9.setFirstName("Donald");
		advisor9.setLastName("Trump");
		advisor9.setPassword("DonaldTrump");

		advisorList.add(advisor1);
		advisorList.add(advisor2);
		advisorList.add(advisor3);
		advisorList.add(advisor4);
		advisorList.add(advisor5);

		try {
			logInAndRegisterMethod();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // END OF MAIN
	
	
	public static void logInAndRegisterMethod() throws IOException {
		
		System.out.println("What would you like to do?\n1. Log-in \n2. Register (Students) ");
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
	
	
	public static void createStudentAccount() throws IOException {
			
			// Create a file instance
			java.io.File file = new java.io.File("/Users/constanceremy/Documents/workspace/user.txt");
			Scanner input = new Scanner(System.in);
			//String lineSeparator = System.getProperty("line.separator");
			
			// Create a file
			try (PrintWriter output = new PrintWriter(new FileOutputStream(file, true)); ){
			
		Student student1 = new Student();
		   System.out.println("Please enter your first name:");
		   student1.setFirstName(input.next());

		   System.out.println("Please enter your last name:");
		   student1.setLastName(input.next());

		   System.out.println("Please enter your StudentID:");
		   student1.setStudentID(input.nextLine());
		   String studentID = input.nextLine();
		   Boolean studentIDInput = false;
		   while (!studentIDInput) {
				   if (studentID.length() == 8
					&& Character.isLetter(studentID.charAt(0)) 
					&& Character.isLetter(studentID.charAt(1))
					&& Character.isLetter(studentID.charAt(2))
					&& Character.isLetter(studentID.charAt(3))
					&& Character.isDigit(studentID.charAt(4))
					&& Character.isDigit(studentID.charAt(5))
					&& Character.isLetter(studentID.charAt(6))
					&& Character.isLetter(studentID.charAt(7))) {
					   studentIDInput = true;
				   } else {
					   System.out.println("Invalid studentID, please try again");
					   studentID = input.nextLine();
				   }
		   }
		   
		   System.out.println("Your password must contain only letters and numbers, no spaces, a minimum 8 characters and at least one number: ");
		   boolean noWhite = false;
		   boolean oneDigit = false;
		   Scanner scan = new Scanner(System.in);
		   String password = "";
		   while (!noWhite ||  !oneDigit || password.length() < 8) {
		     System.out.print("Enter your new password: ");
		     password = scan.nextLine();
		     noWhite = !password.contains(" ");
		     oneDigit = password.matches(".*\\d.*");
		   }

		   System.out.println("Please choose a thesis topic");
		   System.out.println("1. Economics");
		   System.out.println("2. Finance");
		   System.out.println("3. Accounting");
		   System.out.println("4. Marketing");
		   System.out.println("5. IT");
		   Boolean topicDecision = false;
		   String topicChoice = input.next();

		   while (!topicDecision) {
			   if (topicChoice.equals("1")) {
				   student1.setStudentTopic("Economics");
				   topicDecision = true;
			   } else if (topicChoice.equals("2")) {
				   student1.setStudentTopic("Finance");
				   topicDecision = true;
			   } else if (topicChoice.equals("3")) {
				   student1.setStudentTopic("Accounting");
				   topicDecision = true;
			   } else if (topicChoice.equals("4")) {
				   student1.setStudentTopic("Marketing");
				   topicDecision = true;
			   } else if (topicChoice.equals("5")) {
				   student1.setStudentTopic("IT");
				   topicDecision = true;
			   } else {
				   System.out.println("Invalid input, please try again");
				   System.out.println("Please choose a thesis topic");
				   System.out.println("1. Economics");
				   System.out.println("2. Finance");
				   System.out.println("3. Accounting");
				   System.out.println("4. Marketing");
				   System.out.println("5. IT");
				   topicChoice = input.next();
			   }
		   } // end of while loop
			   
		   System.out.println("Please enter your email:");
		   student1.setStudentEmail(input.nextLine());
		   boolean emailValid = false; 
		   String email = input.nextLine();
		   
		   //Here the system will check if a valid email was entered (an "@" is required)
		   do { 
			   for (int j = 0; j<email.length(); j++) {
		    	  if (email.charAt(j)=='@') {
		    		  emailValid = true;
		    	  } // end of if to check that email has an @
		      } // end of for loop
		      if(!emailValid) {
		    	  System.out.println("Invalid email, please try again");	      
		      } 
		   } while (!emailValid); // end of do while
		   
		   output.println(studentID + " " + password + " " + student1.getFirstName() + " " + student1.getLastName() 
		   					+ " " + student1.getStudentTopic() + " " + email);
	
		   System.out.println("Congratulations - your account has been created ");
		      output.close();
		      boolean canLogIn = true;
		      if (canLogIn = true) {
		    	  logInMenu();
		      }
			} // closes try
	} // closes createStudentAccount
	
	
	// A log-in method that is called when user wishes to log in rather than register. 
	public static void logInMenu() throws IOException {
		
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
				logInAsAdvisor();
				userDecisionTwo = true;
			}
			
			else if (userChoiceTwo.equals(logInMenuStudent)) {
				logInAsStudent();
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
			
		} // closes while loop
		
	} // closes logInMenu
	
	
	// the actual log in system method for the advisor
	public static void logInAsAdvisor() throws IOException {
		String userName = "";
		String password = "";
		int counterTries = 0;
		int numberOfTries = 3;
		boolean loggedIn = false;
		
		Scanner input = new Scanner(System.in);
		
			while ((counterTries < numberOfTries) && !loggedIn) {	
			// Telling the user how many tries it has left to enter valid username or password
				if (counterTries == 1) {
					System.out.println("OBS! You have 2 attempts left. ");
				} else if (counterTries == 2) {
					System.out.println("OBS! You have 1 attempt left. ");
				}
		
				counterTries++; // Counts the user tries to log-in, up till 3 attempts total
				// Prompts user to enter log-in credentials
				System.out.println("To log in as an advisor, please enter your username: ");
				userName = input.nextLine();
			
				System.out.println("Now enter your password: ");
				password = input.nextLine();
	
				for (Advisor tempAdv : advisorList ) {
					if(tempAdv.userName.equals(userName) && tempAdv.getPassword().equals(password))
					{
						loggedIn = true;
						logInAsAdvisor = true;
						System.out.println("Welcome "+ tempAdv.name +"! You have successfully logged in...");
						whileLogInAsAdvisor();	
					}
				}
				 {
			
				
				if (counterTries == 3 && !loggedIn) {
					System.out.println("You've unsuccesfully logged in for 3 attempts, the program is closed now. ");
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
			
			
		} //end of while logInAsAdvisor
	}

	
	// The actual log in system method - it is called when the user wishes to log in as student	
	public static void logInAsStudent() throws IOException {
		
		// Create a File instance
		File file = new File("/Users/constanceremy/Documents/workspace/user.txt");
					
		try {
		// Create a Scanner to read data
		Scanner readData = new Scanner(file); // Read data from a file
		// readData.useDelimiter(",");
		String storedStudentID = "";
		String storedPassword = "";
		
		while (readData.hasNext()) {
			storedStudentID = readData.next();
			storedPassword = readData.next();
			System.out.println(storedStudentID + " " + storedPassword);
		}
					
//		String storeFirstName = readData.nextLine();
//		String storedLastName = readData.next();
//		String storedStudentID = readData.next();
//		String storedPassword = readData.next();
//		String storeEmail = readData.next();
//		
		// Used for holding input from the user
		String userName = "";
		String password = "";
		int counterTries = 0;
		int numberOfTries = 3;
		boolean loggedIn = false;
		
		// Create a scanner that reads the user input
		Scanner input = new Scanner(System.in);
		
			while ((counterTries < numberOfTries) && !loggedIn) {	
				// Telling the user how many tries it has left to enter valid username or password
				if (counterTries == 1) {
					System.out.println("OBS! You have 2 attempts left. ");
				} else if (counterTries == 2) {
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
				System.out.println("You have successfully logged in...");
				loggedIn = true;
				boolean logInAsStudent = true;
				whileLogInAsStudent();
				} else {
				// This is the false block, if either password or username doesn't fit
				System.out.println("You entered a wrong username or password. ");
					//if (counterTries == 1) {
						//System.out.print("OBS! You have 2 tries left\n");
				}
				
				if (counterTries == 3 && !loggedIn) {
					System.out.println("You've unsuccesfully logged in for 3 attempts, the program is closed now. ");
				}
				
			} // Closes the while loop for countOfTries
	
		} // Closes the try function
	
			catch (FileNotFoundException ex) {
				System.out.println("There has not been any student registration yet. Please register first in order to log in.");
				logInAndRegisterMethod();
			}
	} // closes logInAsStudent Method

	public static void whileLogInAsStudent() {
		while (logInAsStudent)		{	
			// if student has booking already, show it here. GET DATA IN FILES
			// should not be able to book another advisor if already has booking/has booking pending
			int menuChoiceStudent1 = firstMenuChoiceStudent();
			if (menuChoiceStudent1 == 1) {
				System.out.println("These advisor are experts in your thesis topic:");
				
			 // print advisor choices based on student's topic
				// need to get student topic in file (from registering) GET DATE IN FILE
				// or when student logs in, create array with data from student. that way we can now his thesis topic.
				// will be something like getStudentTopic etc.
						for( Advisor tempAdv : advisorList)
						{
							if(tempAdv.getExpertise().equals(menuChoiceStudent1.getExpertise()))
							{
								System.out.println(tempAdv.getFirstName()+menuChoiceStudent1.getFirstName());	
							}
						}
				System.out.println("Which advisor would you like to book?");
			
				Scanner input = new Scanner(System.in);
				int menuChoiceStudentBooking = input.nextInt();
				if (menuChoiceStudentBooking == 1) {
					// need to add all the other advisors
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuChoiceStudentBooking);
				} else if (menuChoiceStudentBooking == 2) {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuChoiceStudentBooking);
				} else if (menuChoiceStudentBooking == 3) {
					booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuChoiceStudentBooking);
				}
			} else if (menuChoiceStudent1 == 2) {
				// add all advisors
				cancel(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, menuChoiceStudent1);
			} else if (menuChoiceStudent1 == 3) {
				System.out.println("You are now logged out from the Student area. Thank you for using our program!");
		        boolean logInAsStudent = false;
			}
			
		} // end of while logInAsStudent
	}

	public static int firstMenuChoiceStudent() {
			  	System.out.println("Please select an option. Type 1, 2 or 3");
				System.out.println("1: Make a new booking with an advisor");				
				System.out.println("2: Cancel a booking");
				System.out.println("3: Log out");
				Scanner input = new Scanner(System.in);
				int menuChoiceStudent1 = input.nextInt();
				return menuChoiceStudent1;
	}//method firstMenuChoiceStudent

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
			Advisor advisor6, Advisor advisor7, Advisor advisor8, Advisor advisor9, int advisorChoice){
		/*This void method books the room slot by calling method from the Room class called "makeBooking() on the three objects. Three reference variable of Room e.g room1, room2 and room3 is sent 
		  to this method and one integer variable which is the type of room e.g 1 is for Extreme programming	*/	
			switch (advisorChoice){
				case 1 : advisor1.makeBooking(); break;
			    case 2  :advisor2.makeBooking(); break;
			    case 3  :advisor3.makeBooking(); break;
			    case 4  :advisor4.makeBooking(); break;
			    case 5  :advisor5.makeBooking(); break;
			    case 6  :advisor6.makeBooking(); break;
			    case 7  :advisor7.makeBooking(); break;
			    case 8  :advisor8.makeBooking(); break;
			    case 9  :advisor9.makeBooking(); break;
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
