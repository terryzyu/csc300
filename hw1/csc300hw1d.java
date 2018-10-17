/*
 * Name: Terry Yu
 * Class: CSC 300
 * Assignment: csc300hw1d
 * Filename: csc300hw1d.java
 * 
Input: 9

Output:
Enter an integer: 9
M is: 1
sumInts(M) is: 1
(M+1)*M/2 = 1

M is: 2
sumInts(M) is: 3
(M+1)*M/2 = 3

M is: 3
sumInts(M) is: 6
(M+1)*M/2 = 6

M is: 4
sumInts(M) is: 10
(M+1)*M/2 = 10

M is: 5
sumInts(M) is: 15
(M+1)*M/2 = 15

M is: 6
sumInts(M) is: 21
(M+1)*M/2 = 21

M is: 7
sumInts(M) is: 28
(M+1)*M/2 = 28

M is: 8
sumInts(M) is: 36
(M+1)*M/2 = 36

 */

package homework;

import stdlib.StdIn;
import stdlib.StdOut;

public class csc300hw1d {
	public static void main(String[] args) {
		
		StdOut.print("Enter an integer: "); //Prompts user for the end value, N
		int N = StdIn.readInt(); //Stores the N value
		
		//Loop to iterate through integers between 1 to N, N exclusive.
		for(int M = 1; M < N; M++){
			StdOut.println("M is: " + M); //Displays what iteration we're on
			StdOut.println("sumInts(M) is: " + sumInts(M)); //Displays the sum of integers from 1 to M using sumInts(M)
			StdOut.println("(M+1)*M/2 = " + (M+1)*M/2); //Displays the requested calculation.
			StdOut.println(); //Prints blank line for formatting
		}//for
		
	}//main

	//Calculates the sum between 1 to parameter, inclusive. Returns the the integer: sum
	private static int sumInts(int N) {
		int sum = 0; //Stores sum
		
		//Loop to calculate sum between 1 to N, inclusive. 
		for(int x = 1; x <= N; x++)
			sum += x;
		return(sum);
		
	}//sumInts
	
}//class
