/* Coded by								: ***** *****
 * ***#									: **********
 * Description							: This demo program will allow the user to test the functionality
 * 											of the StudentList class. You must load a set of students from
 * 											a plain text file. After that you will be given options for
 * 											the different methods specified in the lab pdf.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StudentListDemo {

	public static void main(String[] args) throws FileNotFoundException {
		
		StudentList students = new StudentList();
		
		//creating the file path to read from
		Scanner kbs = new Scanner(System.in);
		System.out.print("Enter the name of the file you would like to load from: ");
		String name = kbs.next();
		File file = new File(name);
		Scanner f = new Scanner(file);
		
		
		//initialize the variables which will be used in the following loop
		String FirstName, LastName, StudentID, Major, Faculty, Email;
		Student student;
		
		//This loop will create the students from the data file and enter them into the list
		while (f.hasNextLine()) {
			String line = f.nextLine();
			String[] data = line.split("\\s+");
			student = new Student(data[0], data[1], data[2], data[3], data[4], data[5]);
			students.addStudent(student);
		}
		
		
		//Scanner for integers to avoid glitches and an int to record choices for the options
		Scanner kbi = new Scanner(System.in);
		int choice = 0;
		
		//this controls the loop that allows us to test the methods of StudentList
		boolean testing = true;
		
		while (testing == true) {
			
			//lists the menu of choices
			System.out.println("1.Add student to list");
			System.out.println("2.Remove student from list by ID#");
			System.out.println("3.Find student by Name");
			System.out.println("4.Find student by ID#");
			System.out.println("5.Find student by Email");
			System.out.println("6.Find all students of a given major");
			System.out.println("7.Find all students of a given faculty");
			System.out.println("8.Print the list");
			System.out.println("9.Exit");
			System.out.print("Enter your choice [1-9]: ");
			
			//records the users choice of actions
			choice = kbi.nextInt();
			
			//hands your choice of options
			switch (choice) {
			//add student
			case 1: System.out.print("Enter a Student ID#: ");
					StudentID = kbs.next();
					System.out.print("Enter a first name: ");
					FirstName = kbs.next();
					System.out.print("Enter a last name: ");
					LastName = kbs.next();
					System.out.print("Enter a email address: ");
					Email = kbs.next();
					System.out.print("Enter a Major: ");
					Major = kbs.next();
					System.out.print("Enter a Faculty: ");
					Faculty = kbs.next();
					student = new Student(StudentID, FirstName, LastName, Email, Major, Faculty);
					students.addStudent(student);
					System.out.println("Student record created. \n");
					break;
			//remove student
			case 2: System.out.print("Enter the ID number of the student you would like to remove: ");
					StudentID = kbs.next();
					students.removeStudentByID(StudentID);
					System.out.println("Student removed. \n");
					break;
			//find student by name
			case 3: System.out.print("Enter a students last name to find that studet: ");
					LastName = kbs.next();
					System.out.print("Enter a students first name to find that studet: ");
					FirstName = kbs.next();
					student = students.findByLastAndFirstName(LastName, FirstName);
					// if there is no such student
					if (student != null) {
						System.out.println(student.toString() + "\n");
					}
					break;
			//find student by student ID number
			case 4: System.out.print("Enter a students ID number to find that studet: ");
					StudentID = kbs.next();
					student = students.findByID(StudentID);
					//if there is no such id number
					if (student != null) {
						System.out.println(student.toString() + "\n");
					}
					break;
			//find student by email address
			case 5: System.out.print("Enter a students email to find that studet: ");
					Email = kbs.next();
					student = students.findByEmail(Email);
					//if there is no such  email address
					if (student != null) {
						System.out.println(student.toString() + "\n");
					}
					break;
			//find all students of a given major
			case 6: System.out.print("Enter a major: ");
					Major = kbs.next();
					StudentList major = students.thisMajor(Major);
					System.out.println(major.toString() + "\n");
					break;
			//find all students under a given faculty
			case 7: System.out.print("Enter a faculty: ");
					Faculty = kbs.next();
					StudentList faculty = students.thisFaculty(Faculty);
					System.out.println(faculty.toString() + "\n");
					break;
			//print all students
			case 8: System.out.println(students.toString());
					break;
			//exit the demo
			case 9: testing = false;
					break;
			}
		}
	}
}
