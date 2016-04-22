package Project;

import java.util.*;
import java.io.*;

public class LogInManager {
	static ArrayList<String[]> users = new ArrayList<String[]>();
	
	LogInManager() {
		loadFile();
	}

	public static void loadFile() {
		try {	
		
		File file= new File("users.txt");
		Scanner readData = new Scanner(file);
		String S1 = "";
		
		
		while (readData.hasNextLine()) {
			S1 = readData.nextLine();
		
			String[] account = S1.split(" ", 3);
			String[] name = account[2].split(" ", 2);
			
			users.add(account);
			
//			System.out.println("-----------------------------");
//            System.out.println(String.format("The username is '%s'", account[0]));
//            System.out.println(String.format("the password is '%s'", account[1]));
//            System.out.println(String.format("the user's full name is '%s'", account[2]));
//            System.out.println(String.format("the user's first name is '%s'", name[0]));
//            System.out.println(String.format("the user's last name is '%s'", name[1]));
			
  

		}
	}
	
	catch (FileNotFoundException ex) {
		System.out.println("There has been no registrations yet - to proceed, please register an account");
		
	}
}

	
	
		public static boolean authorize(String studentID, String password) {
			boolean result = false;
			
			for (String[] account : users) {
				if (account[0].equals(studentID) && account[1].equals(password)) {
					result = true;
					ProcessLogIn.studentFullName = account[2];
				}
			}
		
			return result;
			
		}
		
		
//		public static boolean verifyStudentID(String studentID) {
//			boolean result = false;
//			
//			for (String[] account : users) {
//				if (account[0].equals(studentID)) {
//					result = true;
//				}
//			}
//		
//			return result;
//			
//		}
		
		
		
		
		
	
		public static boolean ifStudentIDRegistered(String studentID) {
			boolean studentIDRegistered = false;
//			Scanner input = new Scanner(System.in);
			
			
				for (String[] account : users) {
					if (account[0].equals(studentID)) {
						studentIDRegistered = true;
//						System.out.println("This username is already in use, please use another or log-in");
//						ProcessLogIn.studentID = input.nextLine();
					}// If
					
					else {
						studentIDRegistered = false;
					}
				}// For
			
			return studentIDRegistered;
		}// Method
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
}
