package Project;

import java.util.*;
import java.io.*;

public class Booking {
	private static ArrayList<String[]> bookingList = new ArrayList<String[]>();
	
	
	private String bookingStatus;
	
	
	String getBookingStatus() {
		return bookingStatus;
	}
	
	void setBookingStatus(String status) {
		bookingStatus = status;
	}
	
}
