/* Coded by									: ***** *****
 * ***#										: *********
 * Description								: These are an assortment of neat utilities for working with
 * 												unordered lists. It was a little tricky because the static
 * 												class didn't like the generic variables at first and eclipse
 * 												is still giving me a lot of minor warnings. I am not happy
 * 												with how efficient those methods are, but I am not sure how
 * 												to do better without sorting the list, and the problem specifies
 * 												an unordered list.
 */
public class ListUtility<T> {
	
	//joins two lists together without duplicates. The instructions were not clear about how this should
	//be done so I went with what I thought was most logical
	public static <T> List<T> findUnion(List<T> list1, List<T> list2){
		
		//These are the variables used
		List<T> list3 = new List<T>();
		T curr1 = list1.first();
		T curr2 = list2.first();
		
		//checks to see if the lists are empty to save time
		if (list1.size() == 0 && list2.size() == 0) {
			System.out.println("input lists are empty");
			return list3;
		}
		
		//loop 1 will add all items from list1 to list3
		while (curr1 != null) {
			list3.add(curr1);
			curr1 = list1.next();
		}
		
		//loop 2 will add the unique items from list 2 to list 3
		while (curr2 != null) {
			//checks to see if the current item is in list3
			if (!contains(curr2, list3)) {
				list3.add(curr2);
			}
			curr2 = list2.next();
		}
		
		return list3;
	}
	
	public static <T> List<T> findIntersection(List<T> list1, List<T> list2){
		//Create and return a third list that contains the items
		//that are common to both list1 and list2.
		//Do not add duplicates.
		
		//These are the variables we will be using
		List<T> list3 = new List<T>();
		T curr1 = list1.first();
		T curr2 = list2.first();
		
		//checks to see if the lists are empty to save time
		if (list1.size() == 0 && list2.size() == 0) {
			System.out.println("input lists are empty");
			return list3;
		}
		
		//This is the main loop
		while (curr1 != null) {
			//this sub loop checks the current item in loop1 against each item in loop2
			while (curr2 != null) {
				//This checks that the item in list1 is in list2 but not list3
				if ((curr1.equals(curr2)) && !contains(curr1, list3)) {
					list3.add(curr1);
					curr1 = list1.next();
					break;
				}
				curr2 = list2.next();
			}
			curr2 = list2.first();
			curr1 = list1.next();
		}
		if (list3.size() == 0) {
			System.out.println("No overlapping data found");
		}
		return list3;
	}
	
	
	/*Create and return a third list that contains the items
	*in list1 interleaved with the items in list2.
	*For example, list1={A, C}, list2={B, P, M, N, Z}
	*list3 = {A, B, C, P, M, N, Z}
	*these are the variables we will be using
	*/
	public static <T> List<T> interleave(List<T> list1, List<T> list2){
		//variables used
		List<T> list3 = new List<T>();
		T curr1 = list1.first();
		T curr2 = list2.first();
				
		//This is out loop. It will continue until we have processed everything in both lists
		while (curr1 != null || curr2 != null) {
			//this if statement checks to see if the current item of list 1 is in list 3
			if (!contains(curr1, list3) && curr1 != null) {
				list3.add(curr1);
			}			
			//this if statement checks to see if the current item of list 2 is in list 3
			if (!contains(curr2, list3) && curr2 != null) {
				list3.add(curr2);
			}
			curr1 = list1.next();
			curr2 = list2.next();
		}	
		return list3;					
	}
	
	
	public static <T> List<T> chopSkip(List<T> list1){
		 //Create and return a list that has the items in list1
		//with every second item removed.
		//For example, if list1={A, B, C, D, E}
		//the list returned is {A, C, E}
		
		//if the list is empty, give feed back and return list one since there is no point in creating
		//list2 because it would be identical.
		if (list1.size() == 0) {
			System.out.println("input list is empty");
			return list1;
		}
		
		//variables we will use
		List<T> list2 = new List<T>();
		T curr1 = list1.first();
		
		//this is the chopSkip
		while (curr1 != null) {
			list2.add(curr1);
			//list1.next().next() didn't work :(
			curr1 = list1.next();
			curr1 = list1.next();
		}
		
		return list2;
	}
	
	//This tells us if a list contains an item. I hate this method. It embodies my inability to do this
	//efficiently.
	public static <T> boolean contains(T item, List<T> list) {
		T curr = list.first();
		//This horrible while loop ruins all of my efficiencies for my methods.
		while (curr != null) {
			//If we have a match, return false and exit the loop of doom.
			if (curr.equals(item) || curr == item) {
				return true;
			}
			curr = list.next();
		}
		//after having increased the processing time by a factor of O(n), return a measly boolean 
		return false;
	}
}
