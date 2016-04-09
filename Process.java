package Project;

import java.util.Scanner;

public class Process {
	
	static boolean logInAsStudent = true;
	static boolean logInAsAdvisor = false;
	
	public static void main (String[] args) {
		
				Advisor advisor1 = new Advisor();
				Advisor advisor2 = new Advisor();
				Advisor advisor3 = new Advisor();
				Advisor advisor4 = new Advisor();
				Advisor advisor5 = new Advisor();
				Advisor advisor6 = new Advisor();
				Advisor advisor7 = new Advisor();
				Advisor advisor8 = new Advisor();
				Advisor advisor9 = new Advisor();

				
				//set the advisors data fields using methods (setmethod etc.)		
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
				
		
		while (logInAsStudent = true)		{	
			// if student has booking already, show it here. GET DATA IN FILES
			// should not be able to book another advisor if already has booking/has booking pending
			int menuChoiceStudent1 = firstMenuChoiceStudent();
			if (menuChoiceStudent1 == 1) {
				System.out.println("These advisor are experts in your thesis topic:");
				
			 // print advisor choices based on student's topic
				// need to get student topic in file (from registering) GET DATE IN FILE
				// will be something like getStudentTopic etc.
						if (advisor1.getExpertise().equals("Accounting")) {
							System.out.println(advisor1.getFirstName() + " " + advisor1.getLastName());
						}
						if (advisor2.getExpertise().equals("Accounting")) {
							System.out.println(advisor2.getFirstName() + " " + advisor2.getLastName());	
						}
						if (advisor3.getExpertise().equals("Accounting")) {
							System.out.println(advisor3.getFirstName() + " " + advisor3.getLastName());
						}
						if (advisor4.getExpertise().equals("Accounting")) {
							System.out.println(advisor4.getFirstName() + " " + advisor4.getLastName());
						}
						if (advisor5.getExpertise().equals("Accounting")) {
							System.out.println(advisor5.getFirstName() + " " + advisor5.getLastName());
						}
						if (advisor6.getExpertise().equals("Accounting")) {
							System.out.println(advisor6.getFirstName() + " " + advisor6.getLastName());
						}
						if (advisor7.getExpertise().equals("Accounting")) {
							System.out.println(advisor7.getFirstName() + " " + advisor7.getLastName());
						}
						if (advisor8.getExpertise().equals("Accounting")) {
							System.out.println(advisor8.getFirstName() + " " + advisor8.getLastName());
						}
						if (advisor9.getExpertise().equals("Accounting")) {
							System.out.println(advisor9.getFirstName() + " " + advisor9.getLastName());
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
		        logInAsStudent = false;
			}
			
		} // end of while logInAsStudent
		
		while (logInAsAdvisor = true)	{
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
		
		
	} // end of Main


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
			    case 4  :advisor3.makeBooking(); break;
			    case 5  :advisor3.makeBooking(); break;
			    case 6  :advisor3.makeBooking(); break;
			    case 7  :advisor3.makeBooking(); break;
			    case 8  :advisor3.makeBooking(); break;
			    case 9  :advisor3.makeBooking(); break;
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
		    case 4  :advisor3.cancelBooking(); break;
		    case 5  :advisor3.cancelBooking(); break;
		    case 6  :advisor3.cancelBooking(); break;
		    case 7  :advisor3.cancelBooking(); break;
		    case 8  :advisor3.cancelBooking(); break;
		    case 9  :advisor3.cancelBooking(); break;
			}//switch	
		}//end of cancelBooking
	


} // end of Process
