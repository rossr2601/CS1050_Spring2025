/**
 * This program takes user input to see if they can guess the 
 * random number generated
 */

import java.util.Scanner; 

public class GuessNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Main method
	    int number = (int)(Math.random() * 101);
	    // Declaring a variable (number) and initializing by telling the system
	    // what value it should represent

	    try (Scanner input = new Scanner(System.in)) {
	    	//Creating an object from a class for reading keyboard input
	    	//Putting a try command will automatically close the variable
			System.out.println("Guess a magic number between 0 and 100");
			//Display onto the console this message

			int guess = -1;
			while (guess != number) {
			  
			  System.out.print("\nEnter your guess: ");
			  guess = input.nextInt();
			  //declaring guess and using the object from before

			  if (guess == number)
			    System.out.println("Yes, the number is " + number);
			  //Not hardcoding and using the variables
			  else if (guess > number)
			    System.out.println("Your guess is too high");
			  else
			    System.out.println("Your guess is too low");
			}
		} 
		
	}

}