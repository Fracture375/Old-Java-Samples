/* Coded by								: ***** *****
 * ***#									: **********
 * Description							: This is a type of list that holds and handles students.
 * 											There are methods extending those of the list class as
 * 											well as additional methods to search the list based on
 * 											the data in the Student object.
 */
public class StudentList {
	
	//all we really need is the list of students
	private List<Student> students; 
	
	//basic constructor
	public StudentList() {
		students = new List<Student>();
	}
	
	//adds a student to the list
	public void addStudent(Student student) {
		students.add(student);
	}
	
	//remove the first entry of this student from the list
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	//remove the first entry of this student from the list by their ID#
	public void removeStudentByID(String studentID) {
		Student student = this.findByID(studentID);
		students.remove(student);
	}
	
	//returns the size of the list
	public int size() {
		return students.size();
	}
	
	//this will return the first student with a given ID or null if there is no such student
	public Student findByID(String studentID) {
		Student curr = students.first();
		//cycles through the list
		while (curr != null) {
			//checks to see if the studentID of the current student matches the studentID we are looking for
			if (curr.getStudentID().equalsIgnoreCase(studentID)) {
				return curr;
			}
			curr = students.next();
			
		}
		System.out.println("No student with ID#: " + studentID);
		return null;
	}
	
	//this will return the first student with a given name or null if there is no such student
	public Student findByLastAndFirstName(String LastName, String FirstName) {
		Student curr = students.first();
		//cycles through the list
		while (curr != null) {
			//checks to see if the current students name matches the name we are looking for
			if (curr.getLastName().equalsIgnoreCase(LastName) && curr.getFirstName().equalsIgnoreCase(FirstName)) {
				return curr;
			}
			curr = students.next();
		}
		System.out.println("No student with first name: " + LastName + " " + FirstName);
		return null;
	}
	
	//this will return the first student with a given first name or null if there is no such student
	public Student findByEmail(String Email) {
		Student curr = students.first();
		//cycles  through the list
		while (curr != null) {
			//checks to see if the current students email address matches the address we are looking for
			if (curr.getEmail().equalsIgnoreCase(Email)) {
				return curr;
			}
			curr = students.next();
		}
		System.out.println("No student with Email: " + Email);
		return null;
	}
	
	//Find all students of a given major
	public StudentList thisMajor(String Major) {
		StudentList major = new StudentList();
		
		Student curr = students.first();
		
		//while there are more entry in the main list, check the next entry and add it to the
		//new list if that student is part of the same major
		while (curr != null) {
			if (curr.getMajor().equalsIgnoreCase(Major)) {
				major.addStudent(curr);
			}
			curr = students.next();
		}
		if (major.size() == 0) {
			System.out.println("No students enrolled in this major");
		}
		return major;
	}
	
	//Find all students of a given faculty
	public StudentList thisFaculty(String Faculty) {
		StudentList faculty = new StudentList();
			
		Student curr = students.first();
		
		//while there are more entry in the main list, check the next entry and add it to the
		//new list if that student is part of the same faculty
		while (curr != null) {
			if (curr.getFaculty().equalsIgnoreCase(Faculty)) {
				faculty.addStudent(curr);
			}
			curr = students.next();
		}
		if (faculty.size() == 0) {
			System.out.println("No such faculty exists. Check spelling");
		}
		return faculty;
	}
	
	//prints every student in the list. Also adds a new line so, even though it is returned as a String,
	//it still shows up on multiple lines
	public String toString() {
		Student curr = students.first();
		String s = "";
		//cycles through the list
		while (curr != null) {
			//adds the toString of the current student to the string then signals a new line
			s = s + curr.toString() + "\n";
			curr = students.next();
		}
		return s;
	}
}
