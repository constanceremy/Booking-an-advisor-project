public class Student
{
	public int studentID;
	public boolean plannedBooking = false;
	
	//Constructor for advisor object
	public void Student(int id)
	{
		this.studentId = id;
	}

}

public class Advisor
{
	//Init hash map
	public static Map<String, Student> bookingList = new HashMap<String, Student>();

	//Constructor for advisor object - defines the time slots
	public void Advisor()
	{
		map.put("8-10", new Student(-1));
		map.put("10-11", new Student(-1));
		map.put("11-13", new Student(-1));
		map.put("13-15", new Student(-1));
	}

}

public class Schedule {

	public void Schedule()
	{
		//Initialize students and advisors
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Advisor advisor = new Advisor();

		//PICK A TIME
		Student tempstudent = advisor.bookingList.get("10-11");
		//Check if time slot is available
		if(tempstudent.studentId == -1)
		{
			//Set the student as booked
			student1.plannedBooking = true;
			
			//Here we actually use overwriting to overwrite the the existing entry 
			advisor.bookingList.put("10-11", student1);
			System.out.PrintLin("Slot is booked for you"+student1.studentId);
		}
		else
		{
			System.out.PrintErr("The choosen timeslot is not available");
		}
	}
}