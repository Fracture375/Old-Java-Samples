/* Coded by											: ***** *****
 * ***#												: **********
 * Description										: A simple quiz to test knowledge of world capitals
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeographyQuiz {

	public static void main(String[] args) throws FileNotFoundException {
		
		//variables used
		List<String> countries = new List<String>();
		List<String> capitals = new List<String>();
		Scanner kbs = new Scanner(System.in);
		String currCountries;
		String currCapitals;
		String fileName;
		String choice;
		String answer;
		int index, toggle;
		int points = 0;
		boolean testing = true;
		
		//finding the file we want to read from
		System.out.print("Enter the name of the file you want to load your data from: ");
		fileName = kbs.nextLine();
		File file = new File(fileName);
		Scanner f = new Scanner(file);
		
		//adds the data from the text files to our list
		while (f.hasNextLine()) {
			countries.add(f.nextLine());
			capitals.add(f.nextLine());
		}
		
		//loops through the testing cycle
		while (testing == true) {
			System.out.print("Do you want to play? [y / n] : ");
			choice = kbs.nextLine();
			//choose to play
			if (choice.equals("y")) {
				index = (int) (Math.random() * 75 + 1);	//I wasn't sure how many countries there were so i guessed 75
				toggle = (int) (Math.random() * 2 + 1); //This is used to toggle between testing countries and capitals
				//reset the currs to firsts
				currCountries = countries.first();
				currCapitals = capitals.first();
				
				//cycles up to the given country/capital index
				for (int i = 0; i < index; i++) {
					currCountries = countries.next();
					currCapitals = capitals.next();
				}
				
				//this option is for testing people on their knowledge of capitals
				if (toggle == 1) {
					System.out.print("What is the capital of " + currCountries + "? :");
					answer = kbs.nextLine();
					//checks to see if we picked the right  answer
					if (answer.equalsIgnoreCase(currCapitals)) {
						System.out.println("Correct!");
						points++;
					}
					//ops :(
					else {
						System.out.println("Incorrect :( the correct answer is " + currCapitals);
					}
				}
				//this option for testing people on their knowledge of countries based on their capitals
				else {
					System.out.print("Where is the capital city..." + currCapitals + " located?...who knows this stuff??? :");
					answer = kbs.nextLine();
					//if we picked the right answer...
					if (answer.equalsIgnoreCase(currCountries)) {
						System.out.println("Correct!");
						points++;
					}
					//aww, wrong answer :(
					else {
						System.out.println("Incorrect :( the correct answer is " + currCountries);
					}
				}
				System.out.println("You have " + points + " point(s)");
			}
			//choose to stop playing the game
			else if (choice.equalsIgnoreCase("n")){
				testing = false;
				System.out.println("Your final score is " + points);
				System.out.println("gg, wp");
			}
			//choice did not register (e.g entered something other than y or n)
			else {
				System.out.println("Sorry, I didn't understand that answer");
			}
		}
	}
}
