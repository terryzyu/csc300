package homework;

import csc300w18.CSC300Sorts;  // you must have the csc300.jar file installed
// and added to the build path.
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;

/*
 * This is the starter file for Homework 8
 * Terry Yu
 * 
 * As shown in the main function I called runner on each of the sorting algorithms 
 * and it displayed the amount of time in seconds of how long it took to sort a randomized array of size 2^N.
 * I copied the time down into the Word document and calculated the doubling ratio in there. Throwing out any
 * apparent outliers I calculated the average of the doubling ratio and proceeded to determine b.
 * Sort2 took a very long time once it reached size 2^17 so I decided to cut it off there.
 * Calculating the estimated time to complete 2^N for the other algorithms I cut them off in the appropriate places as 
 * seen in main. 
 * 
 */
public class CSC300HW8 {

	//	ToDo 1
	//	write a function:  isSorted,  which will check to see if an array of doubles 
	//	passed as a parameter, is sorted.
	//  
	 
	
	
	// this sample main program creates an array of size 9, passes it to Sort1
	// and prints the elapsed time.
	// you might try changing Sort2, Sort3, Sort4  just to make sure 
	// they are 'callable'
	//
	//  ToDo:  Change main, add additional methods if you want to facilitate
	//         collecting the data you need.
	//         You can automate this as much or as little as you like
	//
	//         You might want to review  XSortCompare in algs21 for some code hints
	//
	//	       Somewhere you should show how you used the   isSorted  function   
	//
	//		   You may not use any other Java classes or methods

	
	
	
	/* Computes average time of sorting algorithm
	 * Params:
	 * M: # of times to run algorithm. Higher M leads to better accuracy
	 * Size: Size of array
	 * sort: algorithm to use
	 */
	public static double sortAverage(int M, int size, String sort) {
		double[] list = new double[size]; //List to store random doubles for algorithm to sort through
		double collectiveTime = 0; //Stores total time used to sort through list
		boolean sortingParam = true, sorted = true; //sortingParam is if a valid algorithm is used, sorted is if the list is sorted afterwards
		Stopwatch watch; //Tracks time. New instance every time it runs the loop again
		for(int iter = 0; iter < M && sorted && sortingParam; iter++) {
			
			//Populates array with random doubles
			for(int fill = 0; fill < size; fill++) {
				list[fill] = StdRandom.random();
			}//for
			
			watch = new Stopwatch(); // Starts timer
			
			//Calls appropriate sorting alg
			switch (sort.toLowerCase()) {
			case "sort1":
				CSC300Sorts.Sort1(list);
				break;
			case "sort2":
				CSC300Sorts.Sort2(list);
				break;
			case "sort4":
				CSC300Sorts.Sort4(list);
				break;
			default:
				StdOut.println("Invalid Sorting Param. Please use sort1, sort2, etc.");
				sortingParam = false;
				break;
			}//switch
			
			collectiveTime += watch.elapsedTime(); //Stores time needed to sort array
			sorted = isSorted(list); //Verifies array is sorted
		}//for
		
		return collectiveTime/M; //Average time
	}//sortAverage()
	
	//Determines if a list is sorted. Returns true/false
	public static boolean isSorted(double[] list) {
		boolean sorted = true; //Initializes boolean. Will change if list isn't sorted at any point
		
		//Loops through list and checks if the number is larger than the previous
		for(int x = 1; x < list.length-1 && sorted; x++) {
			if(!(list[x] >= list[x-1]))
				sorted = false; //List is not sorted, short circuits loop
		}//for
		
		return sorted;
	}//isSorted()
	
	
	/*Method that iterates through powers of 2 and calls the sorting alg
	 * Params:
	 * start: Initial power for 2, i.e. 2^start
	 * end: Ending power for 2 you'd like to stop at
	 * M: Iterations to run sorting alg
	 * alg: Algorithm to be used
	 */
	
	public static void runner(int start, int end, int M, String alg) {
		int power; //Stores 2^# for later
		
		System.out.println("Time is in seconds. You are running " + alg);
		
		//Loop to iterate through each power of 2 between start and end
		for(int x = start; x <= end; x++) {
			power = (int) Math.pow(2, x); //Calculates power
			StdOut.println(Integer.toString(power) + ": " + sortAverage(M, power, alg)); //Calls sorting alg and performs the average
		}//for
		
	}//runner()
	
	
	public static void main( String[] args) {
		//To use program. Call runner with the appropriate params. Indicate what power of 2 to start at and end at, i.e. 2^10 = 1024.
		runner(10, 24, 100, "sort1");
		runner(10, 17, 100, "sort2");
		runner(10, 20, 100, "sort4");
		
	}//main()
	
}//class
