package homework;

import java.util.Arrays;
import stdlib.*;

/**
 * CSC300Program1  version 1.0
 * 
 *   Name: Terry Yu
 *   CSC 300-501-1005
 *   
 *   Does your program have compile errors?     No
 *   Indicate which TODOs have been completed correctly   
 *   TODO 1    Correct
 *   TODO 2    Correct
 *   TODO 3    Correct
 *   TODO 4    Correct
 *   TODO 5    Correct
 * 
 * This is a skeleton file for your programming assignment. Edit the sections marked TODO. 
 *
 * Unless specified otherwise, you must not change the declaration of any method. 
 * This will be true of every skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static double valRange (double[] list)
 * </pre>
 * to something like
 * <pre>
 *     public static void valRange (double[] list)
 * </pre>
 * or
 * <pre>
 *     public static double valRange (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes.  You should not use any HashSets
 * or ArrayLists, or anything else! Exception: You may use Math.abs  (look it up)
 * In addition, each of your functions should go through the argument array at most once. 
 */
public class CSC300Program2 {

	/**
	 * valRange returns the difference between the maximum and minimum values
	 * in the array; Max-Min.  
	 * Precondition: the array is nonempty. 
	 * Your solution must go through the array exactly once.  
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *    0  == valRange (new double[] { -7 })
	 *    10 == valRange (new double[] { 1, 7, 8, 11 })
	 *    10 == valRange (new double[] { 11, 7, 8, 1 })
	 *    18 == valRange (new double[] { 1, -4, -7, 7, 8, 11 })
	 *    24 == valRange (new double[] { -13, -4, -7, 7, 8, 11 })
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static double valRange (double[] list) { //TODO 1
		//Base case if array has only 1 element
		if(list.length == 1)
			return 0;
		else{
			//Sets the first element as theoretical max and min. Compares it to every other element and appropriately changes their value
			double min = list[0], max = list[0];
			for(int iter = 1; iter < list.length; iter++){
				//Checks for lower min than the current
				if(list[iter] < min)
					min = list[iter];
				//Checks for higher max than current
				if(list[iter] > max)
					max = list[iter];
			}//for
			
			return (max - min); //returns the difference between max and min
		}//else

	}//valRange()

	/**
	 * minPosition returns the position where the minimum value is located
	 *
	 * Precondition:  the array is nonempty and all elements are unique.
	 * Your solution must go through the array exactly once.  
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   0 == minPosition(new double[] { -7 })                      // -7 is the minimum
	 *   2 == minPosition(new double[] { 1, -4, -7, 7, 8, 11 }),    // -7 is is location 2
	 *   0 == minPosition(new double[] { -13, -4, -7, 7, 8, 11 })   // -13 is in location 0
	 *   6 == minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9 }) // -9 is in location 6
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int minPosition (double[] list) { //TODO 2
		//Base case if only 1 element
		if(list.length == 1)
			return 0;
		else{
			//Sets first element as theoretical min and compares to all values.
			//If a lower min is found "index" is changed to match the current iteration
			double min = list[0];
			int index = 0;
			for(int iter = 1; iter < list.length; iter++){
				if(list[iter] < min){
					min = list[iter];
					index = iter;
				}//if
				
			}//for

			return index;
		}//else

	}//minPosition()
	/**
	 * posOfLargestElementLTOET returns the position of the largest element in the array that is
	 * less than or equal to the theVal parameter
	 * if all values are greater than theVal, return -1;
	 * 
	 * Precondition:  the array is nonempty and all elements are unique.
	 * Your solution must go through the array exactly once.  
	 *
	 * <pre>
	 *   0 == posOfLargestElementLTOET(3, new double[] { -7 })                      // value:-7 is in pos 0
	 *   5 == posOfLargestElementLTOET(3, new double[] { 11, -4, -7, 7, 8, 1 }),    // value:1 is in pos 5
	 *  -1 == posOfLargestElementLTOET(-7, new double[] { 1, -4, -5, 7, 8, 11 }),   // all elements are > -7
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int posOfLargestElementLTOET(double theVal, double[] list) {//TODO 3
		//Base case
		if(list.length == 1)
			return 0;
		else{
			double max = 0.0; //0.0 is a placeholder. Will be replaced with a value less than theVal
			int index = 0, filler = 0;
			boolean found = false;
			
			//Finds a value that's less than "theVal" and stores into "max". Will be used later to determine if a value is closer to "theVal"
			//If all values are greater than "theVal" this method will return -1 afterwards.
			while(!found && filler < list.length){
				if(list[filler] <= theVal){
					max = list[filler];
					found = true;
				}//if
				else
					filler++;
			}//while
			
			//If all values in the list is greater than "theVal" return -1
			if(!found)
				return -1;
			
			// Checks for the value that's closest to "theVal" and records the position in "index"
			for(int iter = 1; iter < list.length; iter++){
				if(list[iter] <= theVal && list[iter] > max){
					max = list[iter];
					index = iter;
				}//if
				
			}//for
			return index;
		}//else

	}//posOfLargestElementLTOET
	/**
	 * A test program, using private helper functions.  See below.
	 */
	public static void main (String[] args) {
		// for ValRange: array must be nonempty
		testValRange (0, new double[] {11} );
		testValRange (0, new double[] { 11,11,11,11,11} );
		testValRange (10, new double[] {11, 1} );
		testValRange (10, new double[] {1,11} );
		testValRange (32, new double[] {11, 21, 9, 31, 41});
		testValRange (32, new double[] {41, 21, 9, 31, 11});
		testValRange (32, new double[] {11, 41, 9, 31, 21});
		testValRange (32, new double[] {-41, -21, -11, -31, -9});
		testValRange (32, new double[] {-9, -21, -11, -31, -41});
		testValRange (32, new double[] {-41, -11, -9, -31, -21});
		testValRange (32, new double[] {-11, -21, -41, -31, -9});		
		testValRange (0.7, new double[] { 0.2, -0.5, -0.1});
		StdOut.println();

		// for distanceBetweenMinAndMax: array must be nonempty with unique elements
		testMinPosition (0, new double[] {11});
		testMinPosition (0, new double[] {-11});
		testMinPosition (0, new double[] {9, 11, 21, 31, 41});
		testMinPosition (1, new double[] {11, 9, 21, 31, 41});
		testMinPosition (2, new double[] {11, 21, 9, 31, 41});
		testMinPosition (3, new double[] {11, 21, 31, 9, 41});
		testMinPosition (4, new double[] {11, 21, 31, 41, 9});
		testMinPosition (4, new double[] {9, -11, -21, -31, -41});
		testMinPosition (4, new double[] {-11, -21, -31, 9, -41});
		testMinPosition (3, new double[] {-11, -21, -31, -41, 9});
		testMinPosition (2, new double[] {1, -4, -7, 7, 8, 11, 9, -5});
		testMinPosition (1, new double[] {0.2, -0.5, -0.1});

		StdOut.println();
		
		//TODO 4
		// for posOfElementClosestTo: array must be nonempty with unique elements
		testPosOfLargestElementLTOET( 0, 3 , new double[] {-7});      
		testPosOfLargestElementLTOET( 5, 3 , new double[] {11, -4, -7, 7, 8, 1}); 
		testPosOfLargestElementLTOET( 3, 12 , new double[] {4, 2, -8, 10, -17, 15});      
		testPosOfLargestElementLTOET( 7, 8 , new double[] {6, 9, 12, 13, 2, 3, 4, 7}); 
		testPosOfLargestElementLTOET( -1, -20 , new double[] {30, 38, 15, 29, 32, 13, 28, 37, 18, 19, 25, 17});      
		
// TODO 4   Add calls for three more test cases for posOfElementClosestTo
//		   these must be substantively different than two provided.
//         Try to imagine what 'could go wrong' in the function being tested and create a test case that 
//         checks this case.
		
		StdOut.println ("Finished tests");
	}//main
	
	/* Test functions --- lot's of similar code! */
	private static void testValRange (double expected, double[] list) {
		double actual = valRange (list);
		if (expected != actual) {
			StdOut.format ("Failed valRange(%s): Expecting (%.1f) Actual (%.1f)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void testMinPosition (int expected, double[] list) {
		
		int actual = minPosition (list);
		
		if (expected != actual) {
			StdOut.format ("Failed testMinPosition(%s): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}	
	
	private static void testPosOfLargestElementLTOET (int expected, double theVal, double[] list) {
		//TODO 5
		int actual = posOfLargestElementLTOET(theVal, list);
		if(expected != actual)
			StdOut.format ("Failed. posOfElementClosestTo   Actually the test was not even attempted!  Fix this!\n");

	}
	
}