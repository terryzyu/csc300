package homework;
import java.text.DecimalFormat;
import stdlib.*;
public class CSC300Program5 {

	// this class maintains a linked structure via the instance variable first

	/* 
	 * CSC300Program5  version 1.1
	 *   update format of output statements in testPositionOfLastOccurrence & testDeleteSecondIfOdd
	 * 
	 *   Name: Terry Yu
	 *   CSC 300-501-1005 
	 *   
	 *   Does your program have compile errors?     No
	 *  
	 * 
	 * Complete the methods below.
	 * None of the methods should modify the list, unless that is the purpose of the method.
	 * 
	 * You may not add any fields to the node or list classes.
	 * You may not add any methods to the node class.
	 * 
	 * You MAY add private methods to the CSC300Program5 class (helper functions for the recursion). 
	 */
	static boolean showMeSuccess = false;   // set to true to also see Success notifications for tests
										   //  set to false to only see Failure notifications for tests

	static class Node {
		public Node (int item, Node next) { this.item = item; this.next = next; }
		public int item;
		public Node next;
	}

	Node first;

	// a function to compute the size of the list, using a loop
	//  an empty list has size 0
	public int sizeIterative () {
		int count = 0; //Stores how many nodes
		
		//Iterates through chain and counts nodes. 
		for(Node x = first; x != null; x = x.next)
			count++;
		
		return count;
	}//sizeIterative()


	// a function to compute the size of the list using recursion
	// empty list has size 0
	// You will want to create a helper function to do the recursion
	public int sizeRecursive () {
		Node x = first;
		return sizeRecursiveHelper(x);

	}//sizeRecursive()
	
	public int sizeRecursiveHelper(Node start) {
		if(start == null) //Stops when the last node is null
			return 0;
		else
			return 1 + sizeRecursiveHelper(start.next); //Keeps going and incrementing until a null is hit
		
	}//sizeRecursiveHelper()

	// a function to compute the position within the list of the last occurrence 
	// of the parameter NUM 
	// positions are counted as an offset from the beginning.  
	//
	// if NUM is 5.0 and 5.0 is the last element in a list of size 4, the position is 3
	// if NUM is 5.0 and it does not appear, return -1
	//
	// you can write this iteratively or recursively,  but you should only have one loop or recursive helper
	// I would expect
	// [0,1,2,5,5,5,5,5,8,9].positionOfLastOccurrence(5) == 7
	// [0,1,3,4,5,5,2,5,8,9].positionOfLastOccurrence(2) == 6


	public int positionOfLastOccurrence (int num) {
		int position = 0, further = 0; //Position keeps track of position in list, further keeps track if another occurrence is found later. 
		boolean found = false; //Flag if the number is found or not. 
		
		//Iterates through the list. If the num is found, found is set to true and position is set to the current iteration.
		for(Node x = first; x != null; x = x.next) {
			if(x.item == num) {
				found = true;
				if(further > position) //Meant for if an occurrence is found later
					position = further;
			}//if
			further++;
		}//for
		
		//Either returns the position if it was found or -1 if it wasn't. 
		if(found)
			return position;
		else
			return -1;
		
	}//positionOfLastOccurrence()

	// return the sum of the last two values in the list,   
	// Precondition:  the list has at least 2 values
	//  you can write this iteratively or recursively,  but you should only have one loop or recursive helper
	//  you may not call any other method (e.g.  size  )
	//
	// [0,1,2,5,5,5,5,5,8,9].sumOfLastTwo() == 17
	// [0,1].sumOfLastTwo() == 1
	public int sumOfLastTwo () {
		int total = 0; //Stores summation
		
		//Iterates through list until it hits the last two nodes. Computes summation.
		for(Node x = first; x.next != null; x = x.next) 
			if(x.next.next == null)
				total = x.item + x.next.item;
		
		return total;
	}//sumOfLastTwo()

	// a function to delete the second node if its value is odd, 
	//     otherwise the list is unchanged
	// [0,1,2,8,9].deleteSecondIfOdd() --> [0,2,8,9]
	// [0,9].deleteSecondIfOdd() --> [0]
	// [0,4,9].deleteSecondIfOdd() --> [0,4,9]
	// [].deleteSecondIfOdd() --> []
	public void deleteSecondIfOdd () {
		int size = sizeIterative(); //Stores size of list
		
		if(size >= 2) //Single and empty lists are unchanged. Everything else are checked
			if(first.next.item % 2 == 1) //Takes the second node, checks if odd, and deletes if necessary. 
				first.next = first.next.next;
		
	}//deleteSecondIfOdd()

	// for debugging purposes, you may comment/uncomment the two calls in main below 
	// you should restore the call to mainRunTests as below when you submit your solution
	public static void main (String args[]) {
		//mainDebug ();    
		mainRunTests ();
	}
	private static void mainDebug () {
		// Use this for debugging!
		// Add the names of helper functions if you use them.
		Trace.drawStepsOfMethod ("sizeIterative");
		Trace.drawStepsOfMethod ("sizeRecursive");
		Trace.drawStepsOfMethod ("positionOfLastOccurrence");
		Trace.drawStepsOfMethod ("sumOfLastTwo");
		Trace.drawStepsOfMethod ("deleteSecondIfOdd");
		Trace.run (); 
		// To Use:  Put the test here you want to debug:
		testSizeIterative (4, "11 -21.2 31 41");
	}
	private static void mainRunTests () {
		testSizeIterative (0, "");
		testSizeIterative (1, "11");
		testSizeIterative (2, "11 21");	
		testSizeIterative (4, "11 -21 31 41");

		testSizeRecursive (0, "");
		testSizeRecursive (1, "11");
		testSizeRecursive (2, "11 21");	
		testSizeRecursive (4, "11 -21 31 41");

		testPositionOfLastOccurrence (-1, 99, "");
		testPositionOfLastOccurrence (-1, 99,  "11");
		testPositionOfLastOccurrence (-1, 99, "11 21 31 41");
		testPositionOfLastOccurrence (0, 11, "11 21 31 41");
		testPositionOfLastOccurrence (3, 11, "11 21 31 11");
		testPositionOfLastOccurrence (4, 11, "11 11 11 11 11");
		testPositionOfLastOccurrence (3, 31, "31 21 31 31 41");

		testSumOfLastTwo(72, "11 21 31 41");
		testSumOfLastTwo(52, "11 21 31");
		testSumOfLastTwo(32, "11 21");

		testDeleteSecondIfOdd ("", "");
		testDeleteSecondIfOdd ("11", "11");
		testDeleteSecondIfOdd ("11 12", "11 12");
		testDeleteSecondIfOdd ("11", "11 13");
		testDeleteSecondIfOdd ("11 14", "11 13 14");

		StdOut.println ("Finished tests");
	}


	/* ToString method to print */
	public String toString () { 
		// Use DecimalFormat #.### rather than String.format 0.3f to leave off trailing zeroes
		DecimalFormat format = new DecimalFormat ("#.###");
		StringBuilder result = new StringBuilder ("[ ");
		for (Node x = first; x != null; x = x.next) {
			result.append (format.format (x.item));
			result.append (" ");
		}
		result.append ("]");
		return result.toString ();
	}

	/* Method to create lists */
	public static CSC300Program5 of(String s) {
		Node first = null;
		String[] nums = s.split (" ");
		for (int i = nums.length-1; i >= 0; i--) {
			try { 
				int num = Integer.parseInt (nums[i]); 
				first = new Node (num, first);  
			} catch (NumberFormatException e) {
				// ignore anything that is not an int
			}
		}
		CSC300Program5 result = new CSC300Program5 ();
		result.first = first;
		return result;
	}

	// lots of copy and paste in these test!
	private static void testSizeIterative (int expected, String sList) {
		CSC300Program5 list = CSC300Program5.of (sList);
		String sStart = list.toString ();
		int actual = list.sizeIterative();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sizeIterative(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sizeIterative(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success sizeIterative():  Result: %d  input: %s\n", actual, sStart);
	}	


	private static void testSizeRecursive (int expected, String sList) {
		CSC300Program5 list = CSC300Program5.of (sList);
		String sStart = list.toString ();
		int actual = list.sizeRecursive();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sizeRecursive(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sizeRecursive(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess)  
			StdOut.format ("Success sizeRecursive():  Result: %d  input: %s\n", actual, sStart);
	}	


	private static void testPositionOfLastOccurrence (int expected, int num, String sList) {
		CSC300Program5 list = CSC300Program5.of (sList);
		String sStart = list.toString ();
		int actual = list.positionOfLastOccurrence(num);
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.positionOfLastOccurrence(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.positionOfLastOccurrence(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success positionOfLastOccurrence():  Result: %d  position of last %d in %s\n", actual, num , sStart);
	}	

	private static void testSumOfLastTwo (int expected, String sList) {
		CSC300Program5 list = CSC300Program5.of (sList);
		String sStart = list.toString ();
		int actual = list.sumOfLastTwo();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sumOfLastTwo(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sumOfLastTwo(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success sumOfLastTwo():  Result: %d  %s\n", actual, sStart);
	}	


	private static void testDeleteSecondIfOdd (String expected, String sList) {
		CSC300Program5 list = CSC300Program5.of (sList);
		CSC300Program5 elist = CSC300Program5.of (expected);
		list.deleteSecondIfOdd();
		String actual = list.toString ();
		expected = elist.toString();

		boolean status = true;
		if (! expected.equals(actual) ) {
			StdOut.format ("Failed %s.deleteSecondIfOdd(): Expecting %s Actual %s\n", sList, expected, actual);
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success deleteSecondIfOdd():  Expected: %s  actual  %s\n", expected, actual);
	}

}
