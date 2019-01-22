/* Coded by						: ***** *****
 * ***#							: *********
 * Description					: This object stores the data associated with a student
 */
public class Student {
	
	//object variables
	private String StudentID, FirstName, LastName, Email, Major, Faculty;
	
	//constructor class
	public Student(String StudentID, String FirstName, String LastName, String Email, String Major, String Faculty) {
		this.StudentID = StudentID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.Major = Major;
		this.Faculty = Faculty;
	}
	
	//get and set methods
	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public String getFaculty() {
		return Faculty;
	}

	public void setFaculty(String faculty) {
		Faculty = faculty;
	}
	
	//hey look! its the toString method!
	public String toString() {
		return FirstName + " " + LastName + ", ID# " + StudentID + " is majoring in " + Major + " in the faculty of " + Faculty + ". Email: " + Email; 
	}
	
}
