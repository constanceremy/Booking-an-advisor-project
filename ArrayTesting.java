package Project;

import java.util.*;
import java.io.*;

public class ArrayTesting {

	static Scanner readData;
	static Scanner input;
	public static void main(String[] args) throws IOException {
	
	File testFile = new File("myfile.txt");
//	writeFile(testFile);
	readFile(testFile);	
	
	}// MAIN
	
		public static void writeFile(File testFile) throws IOException {
			System.out.println("Input your first name: ");
			input = new Scanner(System.in);
			String firstname = input.next();
			System.out.println("Input your last name: ");
			String lastname = input.next();
			
			try (PrintWriter output = new PrintWriter(new FileOutputStream(testFile, true));) {
			output.println(firstname + " " + lastname);
			
			
			}
		}
	    public static void readFile(File testFile) throws IOException {

			readData = new Scanner(testFile);

	//   while (readData.hasNext()) {
	//   S1 = readData.nextLine();
	//   System.out.println(S1);
	//   }
	//  
	//   readData.close();
	        
	        List<String[]> list = new ArrayList<>();
	        String[] dataArray=null;

	        while (readData.hasNext()) {
	            dataArray = readData.nextLine().split(" ");            
	            list.add(dataArray);
	            

	            
	        }
	        
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i)[0].equals("core15ab")) { // Or use equals() if it actually returns an Object.
	                // Found at index i. Break or return if necessary.
	            }
	        }
	        
//	        System.out.println(list.indexOf("core15ab"));
	        


	        
//	        for(int i=0;i<=list.size();i++){
//		    	if (list.get(i)[0].contains("core15ab")) {
//			        System.out.print("something????");
//		    	} else {
//		    		System.out.println("It looks like you have not registered yet. Please register before logging in.");
//		    	}
//		    	
//		    }
	        		
	        	
	        }//show me text file
	        
	        //what i m trying to parse data and iterate in loop
	         //please cut and past inside the
	        // basically what we are doing trying to fetch 1st postion then in that array postion where is ur main  just run and check
//	        System.out.println(dataArray[0]);
	//
//	        for (int i = 0; i < list.size(); i++) {
//	            System.out.println(list.get(i));
	//
//	        }
	    } // readFile method closing
	    
//			System.out.println(list.get(i));
/*public static void readFile(File testFile) throws IOException {
		
			String S1 = "";
			
		Scanner readData = new Scanner(testFile);
		

		
			List<String> list = new ArrayList<String>();
			String[] dataArray;
			
			while(readData.hasNext()) {
				S1 = readData.nextLine();
				dataArray = S1.split(",");
				list.add(S1);
			}

			List<String> list1 = null;
			list1.add("constance");
			
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i)).contains((CharSequence)list1)) {
					System.out.println(list.get(i));
				}
				
			
			}
			
			String str = list.get(0);
			String[] splited = str.split("\\s+");
			System.out.println(splited);
			
			
//			
//			String[] user = new String[];
//			
//			list.get(0)) = String[] user;
//			
//			// System.out.println(dataArray[0]);
//			
//			
			
//			
//			System.out.println(list[0][1]);
//			
//			ArrayList<String[]> students = new ArrayList<String[]>();
//			students.add(new String[S1]);
//		} // readFile method closing
//		
//		
		}// comment this lines */
