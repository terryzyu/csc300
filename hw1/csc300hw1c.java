/*
 * Name: Terry Yu
 * Class: CSC 300
 * Assignment: csc300hw1c
 * File Name: csc300hw1c.java
 
Input:
4.0
3.7
2.9
3.5
-1

Output:
Enter a GPA or a negative number to exit: 4.0
Enter a GPA or a negative number to exit: 3.7
Enter a GPA or a negative number to exit: 2.9
Enter a GPA or a negative number to exit: 3.5
Enter a GPA or a negative number to exit: -1
Number of GPAs entered: 4
Sum of GPAs: 14.1
Average GPA: 3.525

 */

package homework;

import stdlib.StdIn;
import stdlib.StdOut;

public class csc300hw1c {
	public static void main(String[] args) {
		
		String[] GPA; //Will store GPA, currently uninitialized as we do not know how many GPAs user will enter. Cannot use ArrayList by request of professor.
		String storage = ""; //Stores all entries entered by user
		int count = 0; //Stores number of entries user has made, will be used to generate appropriate length array
		double input = 0, sum = 0; //Stores user input and sum of GPAs for later
		boolean exit = false; //Flag for loop
		
		//Loop to continuously prompt user for input. Exits when a negative GPA is entered
		while(!exit){
			StdOut.print("Enter a GPA or a negative number to exit: "); //Prompts user for GPA
			input = StdIn.readDouble(); //Stores GPA
			
			//If GPA is positive, it gets stored in the string, otherwise it sets to flag to exit loop
			if(input >= 0){
				storage += input + ",";
				count++;
			}
			else
				exit = true;
		}//while
		
		GPA = new String[count]; //Creates the array with the length of the number of entries
		GPA = storage.split(","); //Parses the inputs from the string and stores into the array. 
	
		//Loop to calculate sum of GPAs
		for(int x = 0; x < GPA.length; x++)
			sum += Double.parseDouble(GPA[x]);
		
		//Displays the count, sum, and average of GPAs
		StdOut.println("Number of GPAs entered: " + GPA.length);
		StdOut.println("Sum of GPAs: " + sum);
		StdOut.println("Average GPA: " + (sum / GPA.length));
	}//main

}//class
