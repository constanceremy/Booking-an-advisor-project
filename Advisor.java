package Project;

import java.util.Scanner;

public class Advisor extends User {
		
		private String advisorID;
		private String[] studentSlot = new String[4];
		private String[] isBooked = new String[4];
		private String expertise;
		
		Advisor(){//constructor method called Room(). It is used to initialize states of the class
			studentSlot[0] = "Slot 1";
			studentSlot[1] = "Slot 2";
			studentSlot[2] = "Slot 3";
			studentSlot[3] = "Slot 4";
			
			isBooked[0] = "0";
			isBooked[1] = "0";
			isBooked[2] = "0";
			isBooked[3] = "0";
			
			
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
					if(emptySlot != -1){ // emptyslot -1 means nothing is available
						System.out.println("There is an available slot for this advisor : " + getStudentSlot()[emptySlot]);
						System.out.println("This slot is now booked for you");
						System.out.print("\n");
						isBooked[emptySlot] = "1";//makes the booking for the first available slot
					}
					else //empty slot has not been found
						System.out.println("The advisor you selected does not have any empty student slots.");
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
				
		
		void cancelBooking(){
			int found = findBooking();//calls the findBooking method below to find the location of the booking
			if (found !=-1){
					isBooked[found] = "0";//sets it to unbooked i.e "0"
				System.out.println("Your booking of advisor "+ getAdvisorID()+" \n"
						+ " is now cancelled");
			}	//if
			
		}//cancelBooking
		
		int findBooking(){
			//This is a method that returns the index of array isBooked where the booking is found
			Scanner input = new Scanner(System.in);
			String confirmation = "no";
			int foundLocation = -1;
			 for (int i = 0; i<getStudentSlot().length; i++){
				   if (isBooked[i].equalsIgnoreCase("1")){/*this outer if condition only applies when 
				   there is a booking i.e iBooked[i] is "1"*/
				    System.out.print("Is this your booking: type yes/no "+ getStudentSlot()[i] + " ");
					confirmation = input.nextLine();
				  
				     if (confirmation.equalsIgnoreCase("yes")){
						foundLocation= i;//find the location i if the user confirms that it is his/her booking
					 break;//breaks out of the for loop if the booking is found
					}//if
				      
				  }//outer if
			   }//for 

			 
			 if (foundLocation == -1){/*this variable remains -1 if either there is no booking or user 
				confirms it is not heir booking*/
					System.out.println("Sorry your booking has not been found");
			 }//if
			 else System.out.println("Your booking has been found at "+ (foundLocation+1) + "location");
			 return foundLocation;//returns -1 if the booking is not found or the location otherwise
			
		}//findBooking
			
				 
//		void rejectBooking(){
//			int found = findBookingToReject();//calls the findBooking method below to find the location of the booking
//			if (found !=-1){
//					isBooked[found] = "0";//sets it to unbooked i.e "0"
//				System.out.println("Your booking of advisor "+ getAdvisorID()+" \n"
//						+ " is now cancelled");
//			}	//if
//			
//		}//cancelBooking
//		
//		int findBookingToReject(){
//			//This is a method that returns the index of array isBooked where the booking is found
//			Scanner input = new Scanner(System.in);
//			String confirmation = "no";
//			int foundLocation = -1;
//			 for (int i = 0; i<getStudentSlot().length; i++){
//				   if (isBooked[i].equalsIgnoreCase("1")){/*this outer if condition only applies when 
//				   there is a booking i.e iBooked[i] is "1"*/
//				    System.out.print("Is this your booking: type yes/no "+ getStudentSlot()[i] + " ");
//					confirmation = input.nextLine();
//				  
//				     if (confirmation.equalsIgnoreCase("yes")){
//						foundLocation= i;//find the location i if the user confirms that it is his/her booking
//					 break;//breaks out of the for loop if the booking is found
//					}//if
//				      
//				  }//outer if
//			   }//for 
//
//		 
//				 if (foundLocation == -1){/*this variable remains -1 if either there is no booking or user 
//					confirms it is not heir booking*/
//						System.out.println("Sorry your booking has not been found");
//				 }//if
//				 else System.out.println("Your booking has been found at "+ (foundLocation+1) + "location");
//				 return foundLocation;//returns -1 if the booking is not found or the location otherwise
//				
//			}//findBooking

		
} // end of advisor
