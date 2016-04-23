package Project;

import java.util.*;
import java.io.*;

public class LogInManager {

	// creating the ArrayList Users
	static ArrayList<String[]> user = new ArrayList<String[]>();

	LogInManager() {
		loadFile();
	} // LogInManager()

	public static void loadFile() {
		try {
			File file = new File("users.txt");
			Scanner readData = new Scanner(file);
			String[] s1 = null;
			while (readData.hasNextLine()) {
				s1 = readData.nextLine().split(" ");
				user.add(s1);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("There has been no registrations yet - to proceed, please register an account");
		}
	} // loadFile()

	public static boolean authorize(String studentID, String password) {

		boolean result = false;

		for (int i = 0; i < user.size(); i++) {
			if (user.get(i)[0].equals(studentID) && user.get(i)[1].equals(password)) {
				result = true;
				ProcessLogIn.studentFullName = user.get(i)[2] + " " + user.get(i)[3];
			} // If
		} // For
		return result;
	} // authorize()

} // LogInManager class