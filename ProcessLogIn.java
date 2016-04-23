package Project;

import java.util.*;
import java.io.*;

public class ProcessLogIn {

	// creating the ArrayList of student bookings that will be created every
	// time we start the console.
	static ArrayList<String[]> bookingList = new ArrayList<String[]>();

	// creating variables that are accessible from other classes.
	static String studentUsername = "";
	static String studentFullName = "";
	static String advisorID = "";
	static String currentAdvisorID = "";
	static String currentAdvisorFirstName = "";
	static String currentAdvisorLastName = "";

	// creating a student1 object in which we are temporarily storing the values
	// of the new students.
	static Student student1 = new Student();

	// hardcoding the new advisor objects.
	static Advisor advisor1 = new Advisor();
	static Advisor advisor2 = new Advisor();
	static Advisor advisor3 = new Advisor();
	static Advisor advisor4 = new Advisor();
	static Advisor advisor5 = new Advisor();
	static Advisor advisor6 = new Advisor();
	static Advisor advisor7 = new Advisor();
	static Advisor advisor8 = new Advisor();
	static Advisor advisor9 = new Advisor();

	// creating booleans that are accessible from other classes.
	static boolean logInAsStudent = false;
	static boolean logInAsAdvisor = false;

	public static void main(String[] args) {

		// giving the 9 advisor objects their data fields (using inheritance for
		// first name, last name and password).
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

		// the main is only the logInAndRegisterMethod.
		logInAndRegisterMethod();

	} // Main

	// logInAndRegisterMethod is the method where students and advisors can
	// choose if they want to login or register
	// (advisors can only login)
	public static void logInAndRegisterMethod() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Welcome to the EazyBook system - we'll help you find an advisor!");
		System.out.println("----------------------------------------------------------------");
		System.out.println("\nWhat would you like to do?\n1. Log-in \n2. Register (Students)");

		String userChoiceOne = ""; // Declaring variable 'choice' as early as
									// possible

		Scanner input = new Scanner(System.in);
		userChoiceOne = input.nextLine();

		boolean userDecisionOne = false;

		while (!userDecisionOne) {
			if (userChoiceOne.equals("1")) { // This choice presents the user
												// with the log-in menu
				logInMenu();
				userDecisionOne = true;
			} // If
			else if (userChoiceOne.equals("2")) { // This choice presents the
													// user with the
													// registration menu
				createStudentAccount();
				userDecisionOne = true;
			} // Else if
			else if (userChoiceOne.equals("")) { // Prompts this conditional if
													// there's no input at all
				System.out.println("No input recognized. Please try again.\n1. Log-in \n2. Register (Students) ");
				userChoiceOne = input.nextLine();
			} // Else if
			else { // This message is prompted if the input is not valid e.g
					// letters or anything but 1 or 2
				System.out.println("Incorrect input. Please try again.\n1. Log-in \n2. Register (Students) ");
				userChoiceOne = input.nextLine();
			} // Else
		} // While
	} // logInAndRegisterMethod()

	public static boolean ifStudentIDRegistered(String studentID) {

		boolean studentIDRegistered = false;

		for (int i = 0; i < LogInManager.user.size(); i++) {
			if (LogInManager.user.get(i)[0].equals(studentID)) {
				studentIDRegistered = true;
				break;
			} // If
			else {
				studentIDRegistered = false;
			} // Else
		} // For

		return studentIDRegistered;
	}// ifStudentIDRegistered()

	// this method is called when a student chooses to register.
	public static void createStudentAccount() {

		// Create a file instance
		File file = new File("users.txt");
		Scanner input = new Scanner(System.in);

		LogInManager loginManager = new LogInManager();

		// Create a object of type PrintWriter and FileOutputStream makes the
		// text append previous text
		try (PrintWriter output = new PrintWriter(new FileOutputStream(file, true));) {

			System.out.println("Please enter your first name:");
			boolean noWhiteFirstName = false;

			while (!noWhiteFirstName) {
				student1.setFirstName(input.nextLine());
				if (student1.getFirstName().contains(" ")) {
					System.out.println("Invalid input. Please try again with no spaces.");
				} // If
				else if (student1.getFirstName().equals("")) {
					System.out.println("No input recognized. Please enter your first name:");
				} // Else if
				else {
					noWhiteFirstName = true;
				} // Else
			} // While

			System.out.println("Please enter your last name:");
			boolean noWhiteLastName = false;

			while (!noWhiteLastName) {
				student1.setLastName(input.nextLine());
				if (student1.getLastName().contains(" ")) {
					System.out.println("Invalid input. Please try again with no spaces:");
				} // If
				else if (student1.getLastName().equals("")) {
					System.out.println("No input recognized. Please enter your last name:");
				} // Else If
				else {
					noWhiteLastName = true;
				} // Else
			} // While

			System.out.println("Please enter your StudentID:");
			student1.setStudentID(input.next());
			boolean studentIDInput = false;
			boolean studentIDRegistered = false;

			while (!studentIDInput) {
				if (student1.getStudentID().length() == 8 && Character.isLetter(student1.getStudentID().charAt(0))
						&& Character.isLetter(student1.getStudentID().charAt(1))
						&& Character.isLetter(student1.getStudentID().charAt(2))
						&& Character.isLetter(student1.getStudentID().charAt(3))
						&& Character.isDigit(student1.getStudentID().charAt(4))
						&& Character.isDigit(student1.getStudentID().charAt(5))
						&& Character.isLetter(student1.getStudentID().charAt(6))
						&& Character.isLetter(student1.getStudentID().charAt(7))) {

					// this while loop checks that this studentID has not
					// already been registered.
					while (!studentIDRegistered) {

						try {
							Scanner scanner = new Scanner(file);
							if (ifStudentIDRegistered(student1.getStudentID())) {
								System.out.println("Username is already in use. Please start again:");
								createStudentAccount();
							} // If
							else {
								System.out.println("This studentID is not used already. You are good to go!");
								studentIDInput = true;
								break;
							} // Else
						} // Try
						catch (FileNotFoundException ex) {
						} // Catch
					} // While
				} // If
				else {
					System.out.println("Invalid studentID. Please try again:");
					student1.setStudentID(input.next());
				} // Else
			} // While

			System.out.println(
					"Your password must contain only letters and numbers, no spaces, a minimum 8 characters and at least one number:");
			boolean noWhitePassword = false;
			boolean oneDigit = false;
			Scanner scan = new Scanner(System.in);
			String password = "";

			while (!noWhitePassword || !oneDigit || password.length() < 8) {
				System.out.print("Enter your new password:");
				password = scan.nextLine();
				noWhitePassword = !password.contains(" ");
				oneDigit = password.matches(".*\\d.*");
			} // While

			System.out.println("Congratulations - your account has been created!");
			output.println(student1.getStudentID() + " " + password + " " + student1.getFirstName() + " "
					+ student1.getLastName());

			output.close();
			logInMenu();

		} // Try

		catch (FileNotFoundException ex) {
		} // Catch

	} // createStudentAccount()

	// A log-in method that is called when user wishes to log in rather than
	// register.
	public static void logInMenu() {

		Scanner input = new Scanner(System.in);
		System.out.println(
				"\nChoose either 1 or 2 to proceed. \n1. Log in as advisor \n2. Log in as student \n3. Go Back ");
		String userChoiceTwo; // Declaring user's choice as early on as possible
		boolean userDecisionTwo = false;

		userChoiceTwo = input.nextLine();

		while (!userDecisionTwo) { // While loop for userChoiceTwo makes the
									// menu appear until choice is valid
			if (userChoiceTwo.equals("1")) {
				logInAsAdvisor();
				userDecisionTwo = true;
			} // If

			else if (userChoiceTwo.equals("2")) {

				try {
					File file = new File("users.txt");
					Scanner readData = new Scanner(file);
					logInAsStudent();
					userDecisionTwo = true;
				} // Try

				catch (FileNotFoundException ex) {
					System.out.println("There has been no registration yet - to proceed please register an account.\n");
					logInAndRegisterMethod();
				} // Catch

			} // Else If

			else if (userChoiceTwo.equals("3")) {
				logInAndRegisterMethod();
			} // Else If

			else if (userChoiceTwo.equals("")) {
				System.out.println(
						"No input recognized. Please try again.\n1. Log in as advisor \n2. Log in as student \n3. Go Back ");
				userChoiceTwo = input.nextLine();
			} // Else If

			else {
				System.out.println(
						"Invalid input. Please try again.\n1. Log in as advisor \n2. Log in as student \n3. Go Back ");
				userChoiceTwo = input.nextLine();
			} // Else
		} // While
	} // logInMenu()

	// the actual log in system method for the advisor
	public static void logInAsAdvisor() {

		String userName = "";
		String password = "";

		boolean loggedIn = false;

		Scanner input = new Scanner(System.in);

		while (!loggedIn) {
			System.out.println("-------------------------------------------");
			System.out.println("1. Go back");
			System.out.println("-------------------------------------------\n");
			System.out.println("To log in as an advisor, please enter your username: ");
			userName = input.nextLine();

			if (userName.equals("1")) { // Gives the user a chance to create an
										// account if none exists
				logInMenu();
			} // If

			System.out.println("Now enter your password: ");
			password = input.nextLine();

			if (advisor1.getAdvisorID().equals(userName) && advisor1.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor1.getFirstName() + "!");
				currentAdvisorID = advisor1.getAdvisorID();
				whileLogInAsAdvisor();
			} // If
			else if (advisor2.getAdvisorID().equals(userName) && advisor2.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor2.getFirstName() + "!");
				currentAdvisorID = advisor2.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor3.getAdvisorID().equals(userName) && advisor3.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor3.getFirstName() + "!");
				currentAdvisorID = advisor3.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor4.getAdvisorID().equals(userName) && advisor4.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor4.getFirstName() + "!");
				currentAdvisorID = advisor4.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor5.getAdvisorID().equals(userName) && advisor5.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor5.getFirstName() + "!");
				currentAdvisorID = advisor5.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor6.getAdvisorID().equals(userName) && advisor6.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor6.getFirstName() + "!");
				currentAdvisorID = advisor6.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor7.getAdvisorID().equals(userName) && advisor7.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor7.getFirstName() + "!");
				currentAdvisorID = advisor7.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor8.getAdvisorID().equals(userName) && advisor8.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor8.getFirstName() + "!");
				currentAdvisorID = advisor8.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else if (advisor9.getAdvisorID().equals(userName) && advisor9.getPassword().equals(password)) {
				loggedIn = true;
				logInAsAdvisor = true;
				System.out.println("You have successfully logged in. Welcome " + advisor9.getFirstName() + "!");
				currentAdvisorID = advisor9.getAdvisorID();
				whileLogInAsAdvisor();
			} // Else If
			else {
				// This is the false block, if either password or username
				// doesn't fit
				System.out.println("You entered a wrong username or password. ");
				// if (counterTries == 1) {
				// System.out.print("OBS! You have 2 tries left\n");
			} // Else
		} // While
	} // logInAsAdvisor()

	public static void whileLogInAsAdvisor() {

		Scanner input = new Scanner(System.in);

		while (logInAsAdvisor) {
			if (bookingList.size() > 0) {
				for (int i = 0; i < bookingList.size(); i++) {
					if (bookingList.get(i)[1].equals(currentAdvisorID)) {
						System.out.println("You have a booking with " + bookingList.get(i)[5] + ", studentID: "
								+ bookingList.get(i)[0]);
					} // If
					else {
						System.out.println("You do not have any bookings. Please come back later.");
					} // Else
				} // For
			} else {
				System.out.println("You do not have any bookings. Please come back later.");
			} // If

			System.out.println("When you are done reviewing your bookings, please select option 1");
			System.out.println("1: Log out");
			logOutAsAdvisor();

		} // While
	}// whileLogInAsAdvisor()

	public static void logOutAsAdvisor() {

		Scanner input = new Scanner(System.in);

		String menuChoiceAdvisor = input.nextLine();

		if (menuChoiceAdvisor.equals("1")) {
			System.out.println("You are now logged out from the Advisor area. Thank you for using our program!");
			logInAsAdvisor = false;
			logInAndRegisterMethod();
		} // If
		else if (menuChoiceAdvisor.equals("")) {
			System.out.println("No input recongnized, please try again. Select option 1 \n1. Log out");
			logOutAsAdvisor();
		} else {
			System.out.println("Invalid input. Please try again. Select option 1");
			System.out.println("1. Log out");
			logOutAsAdvisor();
		} // Else
	} // logOutAsAdvisor()

	// The actual log in system method - it is called when the user wishes to
	// log in as student
	public static void logInAsStudent() {

		LogInManager loginManager = new LogInManager();

		Scanner input = new Scanner(System.in);

		System.out.println("-------------------------------------------");
		System.out.println("1. Go back");
		System.out.println("2. Take me back - I need to register");
		System.out.println("-------------------------------------------\n");
		System.out.println("Please insert your StudentID: ");
		String insertStudentID = input.nextLine();

		if (insertStudentID.equals("1")) { // Gives the user a chance to create
											// an account if none exists
			logInMenu();
		} // If
		else if (insertStudentID.equals("2")) {
			logInAndRegisterMethod();
		} // Else if

		System.out.println("Please insert your password: ");
		String insertPassword = input.nextLine();

		if (LogInManager.authorize(insertStudentID, insertPassword)) {
			System.out.println("You've succesfully logged in\n");
			studentUsername = insertStudentID;
			System.out.println("\n---------------------------------------");
			System.out.println("Welcome to EazyBook - " + student1.toString());
			System.out.println("---------------------------------------\n");
			studentLoggedInMenu();
		} // If
		else {
			System.out.println("Wrong username or password input, please try again.");
			logInAsStudent();
		} // Else
	}// logInAsStudent()

	// Method created to verify if the studentID appears in the arraylist
	// 'bookingList'
	public static boolean verifyStudentBooking(String studentUsername) {
		boolean result = false;

		for (String[] booking : bookingList) {
			if (booking[0].equals(studentUsername)) {
				result = true;
			} // If
		} // For
		return result;
	} // verifyStudentBooking()

	public static void studentLoggedInMenu() {

		Scanner input = new Scanner(System.in);
		String menuChoiceStudent1;
		boolean correctInput = false;

		while (!correctInput) {
			if (!verifyStudentBooking(studentUsername)) {

				System.out.println(
						"Please select an option. Type 1, or 2 \n1. Make a new booking with an advisor \n2. Log out");
				menuChoiceStudent1 = input.nextLine();

				if (menuChoiceStudent1.equals("1")) {
					logInAsStudent = true;
					makeABooking();
					correctInput = true;
				} // If
				else if (menuChoiceStudent1.equals("2")) {
					logInAndRegisterMethod();
					correctInput = true;
				} // Else If

				else if (menuChoiceStudent1.equals("")) {
					System.out.println("No input recognized. ");
				} else {
					System.out.println("Invalid input.");
				} // Else
			} // If
			else {
				for (int i = 0; i < bookingList.size(); i++) {
					if (studentUsername.equals(bookingList.get(i)[0])) {
						System.out.println("You have a booking with advisor " + bookingList.get(i)[2] + " "
								+ bookingList.get(i)[3]);
					} // If
				} // For

				System.out.println("Please select an option. Type 1, or 2 \n1. Cancel my booking \n2. Log out");
				menuChoiceStudent1 = input.nextLine();

				if (menuChoiceStudent1.equals("1")) {
					logInAsStudent = true;
					cancelABooking();
				} // If
				else if (menuChoiceStudent1.equals("2")) {
					logInAndRegisterMethod();
					correctInput = true;
				} // Else If
				else {
					System.out.println("Invalid input.");
					studentLoggedInMenu();
				} // Else
			} // Else
		} // While
	}// studentLoggedInMenu()

	public static void makeABooking() {

		Scanner input = new Scanner(System.in);
		System.out.println("\n---------------------------------------------------------");
		System.out.println("This is the list of available advisors to you: ");
		System.out.println("---------------------------------------------------------");

		// print advisor choices based on student's topic
		// or when student logs in, create array with data from student. that
		// way we can now his thesis topic.
		// will be something like getStudentTopic etc.

		System.out.println("1. " + advisor1.getFirstName() + " " + advisor1.getLastName() + " is researching in: "
				+ advisor1.getExpertise());
		System.out.println("2. " + advisor2.getFirstName() + " " + advisor2.getLastName() + " is researching in: "
				+ advisor2.getExpertise());
		System.out.println("\n");
		System.out.println("3. " + advisor3.getFirstName() + " " + advisor3.getLastName() + " is researching in: "
				+ advisor3.getExpertise());
		System.out.println("4. " + advisor4.getFirstName() + " " + advisor4.getLastName() + " is researching in: "
				+ advisor4.getExpertise());
		System.out.println("\n");
		System.out.println("5. " + advisor5.getFirstName() + " " + advisor5.getLastName() + " is researching in: "
				+ advisor5.getExpertise());
		System.out.println("6. " + advisor6.getFirstName() + " " + advisor6.getLastName() + " is researching in: "
				+ advisor6.getExpertise());
		System.out.println("\n");
		System.out.println("7. " + advisor7.getFirstName() + " " + advisor7.getLastName() + " is researching in: "
				+ advisor7.getExpertise());
		System.out.println("8. " + advisor8.getFirstName() + " " + advisor8.getLastName() + " is researching in: "
				+ advisor8.getExpertise());
		System.out.println("\n");
		System.out.println("9. " + advisor9.getFirstName() + " " + advisor9.getLastName() + " is researching in: "
				+ advisor9.getExpertise());

		System.out.println("---------------------------------------------------------");
		System.out.println("\nWhich advisor would you like to book?");
		String menuStudentChoiceOfAdvisor = input.nextLine();

		while (logInAsStudent) {
			// if student has booking already, show it here. GET DATA IN
			// ARRAYLIST
			// should not be able to book another advisor if already has
			// booking/has booking pending

			if (menuStudentChoiceOfAdvisor.equals("1")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "111";
				break;
			} // If
			else if (menuStudentChoiceOfAdvisor.equals("2")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "222";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("3")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "333";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("4")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "444";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("5")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "555";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("6")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "666";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("7")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "777";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("8")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "888";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("9")) {
				booking(advisor1, advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9,
						menuStudentChoiceOfAdvisor);
				advisorID = "999";
				break;
			} // Else If
			else if (menuStudentChoiceOfAdvisor.equals("")) {
				System.out.println("No input recognized. Please try again.");
				makeABooking();
			} else {
				System.out.println("Invalid input. Please try again.");
				makeABooking();
			} // Else
		} // While
		studentLoggedInMenu();
	}// makeABooking()

	// method to book the right advisor with input from makeABooking()
	public static void booking(Advisor advisor1, Advisor advisor2, Advisor advisor3, Advisor advisor4, Advisor advisor5,
			Advisor advisor6, Advisor advisor7, Advisor advisor8, Advisor advisor9, String advisorChoice) {
		// This void method books the advisor slot by calling method from the
		// Advisor class called "makeBooking() on the objects.
		// Nine reference variable of Advisor e.g advisor1, advisor2 etc. is
		// sent to this method
		switch (advisorChoice) {
		case "1":
			currentAdvisorID = advisor1.getAdvisorID();
			currentAdvisorFirstName = advisor1.getFirstName();
			currentAdvisorLastName = advisor1.getLastName();
			advisor1.makeBooking();
			break;
		case "2":
			currentAdvisorID = advisor2.getAdvisorID();
			currentAdvisorFirstName = advisor2.getFirstName();
			currentAdvisorLastName = advisor2.getLastName();
			advisor2.makeBooking();
			break;
		case "3":
			currentAdvisorID = advisor3.getAdvisorID();
			currentAdvisorFirstName = advisor3.getFirstName();
			currentAdvisorLastName = advisor3.getLastName();
			advisor3.makeBooking();
			break;
		case "4":
			currentAdvisorID = advisor4.getAdvisorID();
			currentAdvisorFirstName = advisor4.getFirstName();
			currentAdvisorLastName = advisor4.getLastName();
			advisor4.makeBooking();
			break;
		case "5":
			currentAdvisorID = advisor5.getAdvisorID();
			currentAdvisorFirstName = advisor5.getFirstName();
			currentAdvisorLastName = advisor5.getLastName();
			advisor5.makeBooking();
			break;
		case "6":
			currentAdvisorID = advisor6.getAdvisorID();
			currentAdvisorFirstName = advisor6.getFirstName();
			currentAdvisorLastName = advisor6.getLastName();
			advisor6.makeBooking();
			break;
		case "7":
			currentAdvisorID = advisor7.getAdvisorID();
			currentAdvisorFirstName = advisor7.getFirstName();
			currentAdvisorLastName = advisor7.getLastName();
			advisor7.makeBooking();
			break;
		case "8":
			currentAdvisorID = advisor8.getAdvisorID();
			currentAdvisorFirstName = advisor8.getFirstName();
			currentAdvisorLastName = advisor8.getLastName();
			advisor8.makeBooking();
			break;
		case "9":
			currentAdvisorID = advisor9.getAdvisorID();
			currentAdvisorFirstName = advisor9.getFirstName();
			currentAdvisorLastName = advisor9.getLastName();
			advisor9.makeBooking();
			break;
		} // switch
	} // booking()

	// method to cancel a booking according to logged in student and then set
	// the isBooked[] to 0 for the right advisor and the right slot
	// and then deleting the right line containing the booking in the ArrayList.
	public static void cancelABooking() {
		if (logInAsStudent) {
			for (int i = 0; i < bookingList.size(); i++) {
				if (bookingList.get(i)[0] == studentUsername) {
					if (bookingList.get(i)[1].equals("111")) {
						System.out.println(
								"You were booked with " + advisor1.getFirstName() + " " + advisor1.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor1.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor1.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor1.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor1.isBooked[3] = "0";
						} // Else if
					} // If
					else if (bookingList.get(i)[1].equals("222")) {
						System.out.println(
								"You were booked with " + advisor2.getFirstName() + " " + advisor2.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor2.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor2.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor2.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor2.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("333")) {
						System.out.println(
								"You were booked with " + advisor3.getFirstName() + " " + advisor3.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor3.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor3.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor3.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor3.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("444")) {
						System.out.println(
								"You were booked with " + advisor4.getFirstName() + " " + advisor4.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor4.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor4.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor4.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor4.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("555")) {
						System.out.println(
								"You were booked with " + advisor5.getFirstName() + " " + advisor5.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor5.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor5.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor5.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor5.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("666")) {
						System.out.println(
								"You were booked with " + advisor6.getFirstName() + " " + advisor6.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor6.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor6.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor6.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor6.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("777")) {
						System.out.println(
								"You were booked with " + advisor7.getFirstName() + " " + advisor7.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor7.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor7.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor7.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor7.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("888")) {
						System.out.println(
								"You were booked with " + advisor8.getFirstName() + " " + advisor8.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor8.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor8.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor8.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor8.isBooked[3] = "0";
						} // Else if
					} // Else if
					else if (bookingList.get(i)[1].equals("999")) {
						System.out.println(
								"You were booked with " + advisor9.getFirstName() + " " + advisor9.getLastName()
										+ " in " + bookingList.get(i)[4] + ". Your booking is now cancelled.");
						if (bookingList.get(i)[4] == "Slot 1") {
							advisor9.isBooked[0] = "0";
						} // If
						else if (bookingList.get(i)[4] == "Slot 2") {
							advisor9.isBooked[1] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 3") {
							advisor9.isBooked[2] = "0";
						} // Else if
						else if (bookingList.get(i)[4] == "Slot 4") {
							advisor9.isBooked[3] = "0";
						} // Else if
					} // Else if
				} // If

				for (int j = 0; j < bookingList.size(); j++) {
					if (bookingList.get(j)[0].equals(studentUsername)) {
						bookingList.remove(j);
					} // If
				} // For

				studentLoggedInMenu();

			} // For

		} // If
	} // cancelABooking()

} // end of Process