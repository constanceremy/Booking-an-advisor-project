package Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class Advisor extends User {
			
		public String advisorID;
		public String[] studentSlot = new String[4];
		public String[] isBooked = new String[4];
		public String expertise;
		
		Advisor(){//constructor method called Room(). It is used to initialize states of the class
			studentSlot[0] = "Slot 1";
			studentSlot[1] = "Slot 2";
			studentSlot[2] = "Slot 3";
			studentSlot[3] = "Slot 4";
			
			isBooked[0] = "0";
			isBooked[1] = "0";
			isBooked[2] = "0";
			isBooked[3] = "0";
		
			int emptySlot = -1;
			
			
		}//constructor method Room()
		
		// setter methods
		
				void setAdvisorID(String aID){
					advisorID = aID;
				}
				
				void setStudentSlots(String[] slot){
					studentSlot = slot;
				}
				
				void setIsBooked(String[] booked){
					isBooked = booked;
				}
				
				void setExpertise(String aexpertise){
					expertise = aexpertise;
				}
				
		// getter methods
		
		String getAdvisorID(){
			return advisorID;
		}
		
		String[] getStudentSlot(){
			return this.studentSlot;
		}
		
		String[] getIsBooked(){
			return this.isBooked;
		}
		
		String getExpertise(){
			return expertise;
		}
		
		
		void makeBooking(){
			   /*This is a void method which first finds an empty slot which is the location of the array
			    isBooked*/
						 
					int emptySlot = -1; /*this variable is initialised so if it does not change we know code 
					below has not found an emptyslot*/
			        emptySlot = findEmptySlot();
					if(emptySlot != -1) { // emptyslot -1 means nothing is available
						System.out.println("There is an available slot for this advisor : " + getStudentSlot()[emptySlot]);
						System.out.println("This slot is now booked for you\n\n");
						String[] booking = {ProcessLogIn.studentUsername, 
								ProcessLogIn.currentAdvisorID, ProcessLogIn.currentAdvisorFirstName, 
								ProcessLogIn.currentAdvisorLastName, getStudentSlot()[emptySlot], ProcessLogIn.studentFullName};
								ProcessLogIn.bookingList.add(booking);
//							for(int i = 0; i < ProcessLogIn.bookingList.size(); i++) {
//								System.out.println("Booking: student is: " + ProcessLogIn.bookingList.get(i)[0] + 
//										" and advisorID is: " + ProcessLogIn.bookingList.get(i)[1] + "and the name is " +
//										ProcessLogIn.bookingList.get(i)[2] + ProcessLogIn.bookingList.get(i)[3] + 
//										" at time Slot: " + ProcessLogIn.bookingList.get(i)[6]);
//							}// want to print the array list to see it temp
						isBooked[emptySlot] = "1";//makes the booking for the first available slot
					}
					else { //empty slot has not been found
						System.out.println("The advisor you selected does not have any empty student slots.");
					}
		}// method makeBooking
				
		int findEmptySlot(){  // this is a return method
			int emptySlot = -1; // if the returned value is -1, there are no time slots available
			for(int i = 0; i < isBooked.length; i++){//used to go through the array
				if(isBooked[i] == "0"){//finds an empty slot
					emptySlot = i;//assign the location of the array to emptySlot variable
					break;
				}//if
			}//for
			return emptySlot;//returns the location of the array that is empty
		}//method findRoomSlot
				
		
} // end of advisor
