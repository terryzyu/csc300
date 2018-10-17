/*
 * Name: Terry Yu
 * Class: CSC 300
 * Assignment: csc300hw1a
 * File Name: csc300hw1a.java
 * 
Input: 3.5, 4.2

Output:
Please enter two floating point numbers
First: 3.5
Second: 4.2
Sum: 7.7
Difference: -0.7
Quotient: 0.83333
Power: 192.79052344938842

 */

package homework;
import java.math.BigDecimal;

import stdlib.StdIn;
import stdlib.StdOut;

public class csc300hw1a {
	public static void main(String[] args) {
		
		//Prompts user for floats and stores them in A and B respectively
		//Using BigDecimal library to avoid floating point error in operations later
		StdOut.println("Please enter two floating point numbers");
		StdOut.print("First: ");
		BigDecimal A = new BigDecimal(Float.toString(StdIn.readFloat()));
		StdOut.print("Second: ");
		BigDecimal B = new BigDecimal(Float.toString(StdIn.readFloat()));
		
		//Displays the sum, difference, quotient, and power of the inputs. 
		StdOut.println("Sum: " + (A.add(B)));
		StdOut.println("Difference: " + (A.subtract(B)).floatValue()); 
		StdOut.println("Quotient: " + (A.divide(B,5, BigDecimal.ROUND_HALF_UP)));
		StdOut.println("Power: " + Math.pow(A.floatValue(), B.floatValue())); //BigDecimal doesn't have built-in number raised to fractional power. I'm using Math.pow however it loses precision after 4 decimal places. 
	}//main

}//class
