/* Coded by											: ***** *****
 * ***#										: *********
 * Description										: Sooo....I don't really like how this works but let me explain. 
 * 													  The list class functions like a stack so as I go to take something 
 *                                                    out of one list and put it in another, it inverts the order. I could 
 *                                                    fix it by changing the list class but I heard one of our TA's in the 
 *                                                    lab say that we can't change the List and Node classes 
 */
import java.util.Scanner;
public class ListUtilityDemo {

	public static void main(String[] args) {
		
		//the variables we will use
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		List<String> tempOutput = new List<String>();
		String input;
		Scanner kbs = new Scanner(System.in);
		Scanner kbi = new Scanner(System.in);
		boolean testing = true;
		int choice;
	
		//this loop allows the user to enter values into list1
		System.out.print("enter strings for list 1 [enter exit to quit]: ");
		input = kbs.next();
		while (!input.equals("exit") && input != null) {
			list1.add(input);
			input = kbs.next();
		}

		//this loop allows the user to enter values into list2
		System.out.print("\nenter strings for list 2 [enter exit to quit]: ");
		input = kbs.next();
		while (!input.equals("exit") && input != null) {
			list2.add(input);
			input = kbs.next();
		}
		
		System.out.println("");
		
		//this loop lets you test the methods from ListUtility
		while (testing == true) {
			//Prints the menu for the demo
			System.out.println("1.findUnion");
			System.out.println("2.findIntersection");
			System.out.println("3.interleave");
			System.out.println("4.chopSkip");
			System.out.println("5.contains");
			System.out.println("6.enumerate list1");
			System.out.println("7.enumerate list2");			
			System.out.println("8.exit");
			System.out.print("Enter selection [1-6]: ");
			
			//get the users choice in options
			choice = kbi.nextInt();
			
			//this switch handles the menu options
			switch (choice) {
			case 1: tempOutput = ListUtility.findUnion(list1, list2);
					tempOutput.enumerate();
					System.out.println("\n");
					break;
			case 2: tempOutput = ListUtility.findIntersection(list1, list2);
					tempOutput.enumerate();
					System.out.println("\n");
					break;
			case 3: tempOutput = ListUtility.interleave(list1, list2);
					tempOutput.enumerate();
					System.out.println("\n");
					break;
			case 4: System.out.print("Which list would you like to chipSkip? [1 or 2] : ");
					while (choice != 1 && choice != 2) {
						choice = kbi.nextInt();
						if (choice == 1) {
							tempOutput = ListUtility.chopSkip(list1);
							tempOutput.enumerate();
							System.out.println("\n");
						}
						else if (choice == 2) {
							tempOutput = ListUtility.chopSkip(list2);
							tempOutput.enumerate();
							System.out.println("\n");
						}
						else {
							System.out.print("No such list. Please choose 1 or 2 :");
						}
					}
					break;
			case 5: System.out.print("Which list would you like to check? [1 or 2]: ");
					while (choice != 1 && choice != 2) {
						choice = kbi.nextInt();
						if (choice == 1) {
							System.out.print("Does list1 contain [enter item]: ");
							System.out.println("Contains returns: " + list1.contains(kbs.next()) + "\n");
						}
						else if (choice == 2) {
							System.out.print("Does list2 contain [enter item]: ");
							System.out.println("Contains returns: " + list2.contains(kbs.next()) + "\n");						
						}
						else {
							System.out.println("no such list. please enter 1 or 2");
						}
					}
					break;
			case 6: list1.enumerate();
					System.out.println("\n");
					break;
			case 7: list2.enumerate();
					System.out.println("\n");
					break;
			case 8: testing = false;
					System.out.println("Ok, we made it. Nothing blew up. Let's all just go home and never speak of this again");
					break;
			}
		}
	}
}
