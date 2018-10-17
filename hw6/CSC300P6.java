package homework;
import java.util.Arrays;

import stdlib.*;

public class CSC300P6 {

	/* Verison 1.1
	 *   updated value in last testInCommon call
	 *   added code to correctly handle an empty string in   arrayFrom  
	 * 
	 * Your Name goes here: Terry Yu
	 * Your class section  goes here: CSC 300-501-1005 

	 * 
	 * The class  CSC300P6 implements a singly linked list:
	 *    the instance variables are:
	 *       first:  reference to the first node in the list
	 *       N:      the number of nodes in the list
	 *     	 
	 * Complete the methods below (ToDos 1-5)
	 * There are two sets of methods to complete.
	 *             
	 * The first set are instance methods which modify the linked list 
	 * accessed through the instance variable: first
	 * Note that this list keeps track of the number of elements in the instance varible N
	 * It is important that N accurately reflect the length of the list.
	 * 
	 * The second set of methods are static methods which modify the array
	 * that is passed to it 
	 * 
	 * Note that this list keeps track of the number of elements N.
	 * It is important that N accurately reflect the length of the list. 
	 * 
	 * You may not add any fields to the node or list classes.
	 * You may not add any methods to the node class.
	 * 
	 */

	static class Node {
		public Node (int data, Node next) { this.data = data; this.next = next; }
		public int data;
		public Node next;
	}
	int N;       // number of nodes in list
	Node first;  // reference to the first node in the list


	static boolean showMeSuccess = false;   // set to true to also see Success notifications for tests
										  //  set to false to only see Failure notifications for tests

	// deleteNodeInPos
	//
	// delete the node in position k (where k is between 0 and N-1 inclusive)
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//              :  N >=1 ; list is not empty
	//
	// You can solve the problem iteratively or recursively
	//    an iterative solution must use a single loop
	//    a recursive solution may use a single helper function.
	// 
	// You may not use/call any other functions, java classes or java utilities
	public void deleteNodeInPos (int k) {
		Node temp = first; //Temp storage of 
		
		if(first == null) //Empty list
			return;
		
		if(k == 0) {//If you want to delete the first node
			first = first.next;
			return;
		}//if
		
		//Navigates to the previous node before deleted node
		for(int x = 0; temp != null && x < k-1; x++)
			temp = temp.next;
		
		//Makes sure it doesn't hit a null down the line
		if(temp == null || temp.next == null)
			return;
		
		Node forward = temp.next.next; //Jumps over the node to be deleted
		temp.next = forward; //Unlinks the deleted node from the original list. 
	}//deleteNodeInPos()
	
	// valueAt
	//
	// return the value in the node at position k
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//              :  N >=1 ; list is not empty
	//
	// You can solve the problem iteratively or recursively
	//    an iterative solution must use a single loop
	//    a recursive solution may use a single helper function.
	// 
	// You may not use/call any other functions, java classes or java utilities
	public int valueAt( int k ) {
		Node temp = first; //Temp storage
		
		//Loop to navigate through the list to the node
		for(int x = 0; x < k; x++)
			temp=temp.next;
		
		return temp.data; //Returns the data stored in the node. 
	}//valueAt()
	
	// listMerge
	//
	// merge the nodes from the secondList into the first list
	// using an every-other node strategy
	// preconditions: original list is NOT empty
	//                secondlist may be empty
	//                secondlist may be shorter, longer or the same length as the other list
	//postcondition:
	//    the values from the second list are merged into the first list
	//    the second list is unchanged
	//
	// You can solve the problem iteratively or recursively
	//    an iterative solution must use a single loop
	//    a recursive solution may use a single helper function.
	// 
	// You may not use/call any other functions, java classes or java utilities
	
	public void listMerge(CSC300P6 secondList ) {
		listMergeHelper(first, secondList.first);
	}//listMerge
	
	public Node listMergeHelper(Node firstNode, Node secondNode) {
		// Base cases
		if (firstNode == null) return secondNode;
		if (secondNode == null) return firstNode;
		
		//The next two blocks effectively alternate between the two lists. Which is why you see them reversed compared to their naming scheme
		//Checks the data to sort. Sets the next node to the next one in first list
		if (firstNode.data < secondNode.data) {
			firstNode.next = listMergeHelper(firstNode.next, secondNode);
			return firstNode;
		}//if
		
		else { //Sets the secondNode to the next one in the secondList
			secondNode.next = listMergeHelper(secondNode.next, firstNode);
			return secondNode;
		}//else
		
	}//listMergeHelper
	
	
    // inCommon
	//  find the number of values in common between two arrays of integers
	//  precondition: both input arrays are sorted low to high
	//               the elements within each array are unique.
	// input arrays can have any length including 0
	// You can solve the problem iteratively or recursively
	//    an iterative solution must use a single loop
	//    a recursive solution may use a single helper function.
	// 
	// You may not use/call any other functions, java classes or java utilities
	
	public static int inCommon(int[] a, int[] b) {
		int count = 0, aIndex = 0, bIndex = 0; //Count stores number of common occurrences, indexes keep track of position in arrays
		while (aIndex < a.length && bIndex < b.length) {
			if (a[aIndex] < b[bIndex]) //If the number in b is larger than in a, keeps comparing and incrementing up a
				aIndex++;
			else if (b[bIndex] < a[aIndex]) //If the number in a is larger than in b, keeps comparing and incrementing up b
				bIndex++;
			else { //When both numbers are the same. 
				count++;
				aIndex++;
			}//else
		}//while
		
		return count; // Todo 4 complete this method
	}//inCommon()
	
	
	// arrayIntersection
	//
	// Create and return a new array which contains only the elements common to both arrays
	// the elements of the new array must be in increasing order
	// precondition: both input arrays are sorted low to high
	//               the elements within each array are unique.
	// 
	// You can solve the problem iteratively or recursively
	//    an iterative solution must use a single loop
	//    a recursive solution may use a single helper function.
	// 
	// You may call the function inCommon
	// You may not use/call any other functions, java classes or java utilities
	//               
	public static int[] arrayIntersection(int[] a, int[] b) {
		int[] total = new int[inCommon(a, b)]; //Creates new array sized the length of the common count
		int aIndex = 0, bIndex = 0, totalIndex = 0;
		
		//Follows exact same idea as inCommon, only difference is to store the common number into the total array. 
		while (aIndex < a.length && bIndex < b.length) {
			if (a[aIndex] < b[bIndex])
				aIndex++;
			else if (b[bIndex] < a[aIndex])
				bIndex++;
			else {
				total[totalIndex] = b[bIndex++];
				totalIndex++;
				aIndex++;
			}//else
		}//while
		return total;

	}//arrayIntersection()
	
	public static void main (String args[]) {
		runListTests ();
		runArrayTests();
	}

	private static void runListTests () {

		testDeleteNodeInPos (0, "11", "[ ]");
		testDeleteNodeInPos (0, "11 21 31 41 51", "[ 21 31 41 51 ]");
		testDeleteNodeInPos (1, "11 21 31 41 51", "[ 11 31 41 51 ]");
		testDeleteNodeInPos (2, "11 21 31 41 51", "[ 11 21 41 51 ]");
		testDeleteNodeInPos (3, "11 21 31 41 51", "[ 11 21 31 51 ]");
		testDeleteNodeInPos (4, "11 21 31 41 51", "[ 11 21 31 41 ]");

		testValueAt (0, "11", 11);
		testValueAt (0, "11 21 31 41 51", 11);
		testValueAt (1, "11 21 31 41 51", 21);
		testValueAt (2, "11 21 31 41 51", 31);
		testValueAt (3, "11 21 31 41 51", 41);
		testValueAt (4, "11 21 31 41 51", 51);

		testListMerge ("1","", "[ 1 ]");
		testListMerge ("1","2", "[ 1 2 ]");
		testListMerge ("1","2 3", "[ 1 2 3 ]");
		testListMerge ("1","2 3 4", "[ 1 2 3 4 ]");
		testListMerge ("1 5","4", "[ 1 4 5 ]");
		testListMerge ("1 7 8","6", "[ 1 6 7 8 ]");
		testListMerge ("1 3 5","2 4", "[ 1 2 3 4 5 ]");
		testListMerge ("1 3 5","2 4 6 8 ", "[ 1 2 3 4 5 6 8 ]");

		StdOut.println ("Finished list tests");
	}
	private static void runArrayTests () {
		testArrayInCommon(0, "1", "");
		testArrayInCommon(0, "1", "2");
		testArrayInCommon(0, "", "2");
		testArrayInCommon(1, "1", "1");
		testArrayInCommon(1, "1", "1 2");
		testArrayInCommon(1, "1 2", "1");
		testArrayInCommon(2, "1 2", "1 2");
		testArrayInCommon(2, "1 4 9 12", "1 3 9 15");
		testArrayInCommon(2, "1 5 6 7 8 9 ", "1 9 11");
		testArrayInCommon(5, "1 2 3 4 5", "1 2 3 4 5"); // fixed


		testArrayIntersection("", "1", "2");
		testArrayIntersection("", "", "2");
		testArrayIntersection("1", "1", "1");
		testArrayIntersection("1", "1", "1 2");
		testArrayIntersection("1", "1 2", "1");
		testArrayIntersection("1 2", "1 2", "1 2");
		testArrayIntersection("1 9", "1 4 9 12", "1 3 9 15");
		testArrayIntersection("1 9", "1 5 6 7 8 9 ", "1 9 11");
		testArrayIntersection("1 2 3 4 5", "1 2 3 4 5", "1 2 3 4 5");

		StdOut.println ("Finished array tests");
	}

	/* ToString method to print */
	public String toString () { 
		// Use DecimalFormat #.### rather than String.format 0.3f to leave off trailing zeroes
		StringBuilder result = new StringBuilder ("[ ");
		for (Node x = first; x != null; x = x.next) {
			result.append (x.data);
			result.append (" ");
		}
		result.append ("]");
		return result.toString ();
	}

	/* Method to create lists from a string*/
	public static CSC300P6 of(String s) {
		int N = 0;
		Node first = null;
		String[] nums = s.split (" ");
		for (int i = nums.length-1; i >= 0; i--) {
			try { 
				int num = Integer.parseInt(nums[i]);
				first = new Node (num, first);  
				N++;
			} catch (NumberFormatException e) {
				// ignore anything that is not a double
			}
		}
		CSC300P6 result = new CSC300P6 ();
		result.first = first;
		result.N = N;
		return result;
	}
	// method to create array of doubles from a string.
	
	public static int[]  arrayFrom(String s) {
		int N = 0;
		String[] nums;
		if ( s.isEmpty()) nums = new String[0];
		else nums = s.split (" ");
		int[] arr  = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			try { 
				int num = Integer.parseInt(nums[i]); 
				arr[i] = num;
			} catch (NumberFormatException e) {
				// ignore anything that is not an int
			}
		}
		return arr;
	}
	
	

	// testing methods,  best left alone
	
	// test the linked list   delete method
	private static void testDeleteNodeInPos (int k, String list, String expected) {
		CSC300P6 actual = CSC300P6.of (list);
		
		actual.deleteNodeInPos (k);

		boolean status = true;
		if (!expected.equals (actual.toString ())) {
			StdOut.println (String.format ("Failure delete: expected=%s, actual=%s", expected, actual.toString ()));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success delete: delete element %d  Before: [ %s ] after  %s\n", k, list, actual.toString());

	}

	// test the linked list   at method
	private static void testValueAt (int k, String list, double expected) {
		CSC300P6 theList = CSC300P6.of (list);

		double	 actual = theList.valueAt(k);

		boolean status = true;
		if (expected != actual) {
			StdOut.println (String.format ("Failure       at: expected=%.0f, actual=%.0f", expected, actual));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success       at:  value at pos %d Expected: %s  actual  %s\n", k, expected, actual);
	}

	// test the listMerge method
	private static void testListMerge(String list1, String list2, String expected) {
		CSC300P6 one = CSC300P6.of (list1);
		CSC300P6 two = CSC300P6.of (list2);

		one.listMerge(two);
		boolean status = true;
		if (!expected.equals (one.toString ())) {
			StdOut.println (String.format ("Failure listMerge: expected=%s, actual=%s", expected, one.toString ()));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success listMerge:  original:[ %s ]  merge:[ %s ] after  %s\n", list1, list2, one.toString());

	}
//
//	// test the arrayInsert method
	private static void testArrayInCommon (int expected, String sa, String sb) {

		int[] a = arrayFrom(sa);
		int[] b = arrayFrom(sb);
		int actual = inCommon(a,b);

		boolean status = true;

		if( expected != actual) {
			StdOut.format ("Failure inCommon:a: [ %s ], b: [ %s ] expected=%d, actual=%s\n", 
					 sa, sb, expected, actual);
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success inCommon:a: [ %s ], b: [ %s ] expected=%d, actual=%s\n",
					sa,sb, expected, actual);

	}
//	
//	 test the arrayDelete method
	private static void 		testArrayIntersection (String expectedString, String sa, String sb)  {

		int[] a = arrayFrom(sa);
		int[] b = arrayFrom(sb);
		int[] actual = arrayIntersection(a,b);
		int[] expected = arrayFrom(expectedString);

		boolean status = true;

		if( !Arrays.equals(actual, expected)) {
			StdOut.format ("Failure intersection: [ %s ], b: [ %s ] expected= %s , actual= %s\n", 
					 sa, sb, Arrays.toString(expected), Arrays.toString(actual));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success intersection: [ %s ], b: [ %s ] expected=%s, actual=%s\n",
					 sa, sb, Arrays.toString(expected), Arrays.toString(actual));

	}

}
