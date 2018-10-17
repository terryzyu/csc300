/*
 * Name: Terry Yu
 * Class: CSC 300
 * Assignment: csc300hw1b
 * File Name: csc300hwb.java
 * 
Input: 8
Output: 

Please enter a positive integer: 8
N: 4
N: 2
N: 1
Iterations: 3
log base 2 of N: 3.0

Input: 19
Output: 

Please enter a positive integer: 19
N: 9
N: 4
N: 2
N: 1
Iterations: 4
log base 2 of N: 4.247927513443585

*/

package homework;

import stdlib.StdIn;
import stdlib.StdOut;

public class csc300hw1b {
	public static void main(String[] args) {
		int N = 0; //Stores user input for later
		
		//Loop to get user input. Will exit when a positive integer is entered
		do{
			StdOut.print("Please enter a positive integer: "); //Prompts user
			N = StdIn.readInt(); //Stores integer input in N
			
		}while(N<=0);
		
		double log2N = Math.log(N)/Math.log(2); //Stores log base 2 of N
		int iter = 0; //Stores number of iterations it takes to reach 1 when dividing by 2 and truncating
		
		//Loop to calculate number of iterations to reach 1 and displays each computation. Exits when 1 is reached
		do{
			N = (int)(N/2); //Divides number by 2 and truncates
			StdOut.println("N: "+N); //Prints out the number after a division
			iter++; //Stores number of divisions performed
		}while(N > 1); 
		
		//Prints number of iterations performed and the value of log base 2 of N
		StdOut.println("Iterations: " + iter);
		StdOut.println("log base 2 of N: " + log2N);
		
	}//main
}//class
