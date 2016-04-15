package Project;

import java.util.*;
import java.io.*;

public class ArrayListTesting {

	public static void main(String[] args) throws IOException {
	
	File testFile = new File("C://Users//Zhagzi//testArray.txt");
	writeFile(testFile);	
	readFile(testFile);	
	
	
	
	}// MAIN
	
	
	
		public static void writeFile(File testFile) throws IOException {
			System.out.println("Input your first name: ");
			Scanner input = new Scanner(System.in);
			String firstname = input.next();
			System.out.println("Input your last name: ");
			String lastname = input.next();
			
			try (PrintWriter output = new PrintWriter(new FileOutputStream(testFile, true));) {
			output.println(firstname + " " + lastname);
			
			
			}
		}
	
	
		public static void readFile(File testFile) throws IOException {
		
			String S1 = "";
			
		Scanner readData = new Scanner(testFile);
		
		
		
//			while (readData.hasNext()) {
//			S1 = readData.nextLine();
//			System.out.println(S1);
//			}
//		
//			readData.close();
		

		
			
			List<String> list = new ArrayList<String>();
			String[] dataArray;
			
			while(readData.hasNext()) {
				S1 = readData.nextLine();
				dataArray = S1.split(" ");
				list.add(S1);
			}
			
			
			
			System.out.println(dataArray[0]);
			
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			
			}
		} // readFile method closing
		
		
} // Class
