 /*
  *  add comments
  */

import java.util.Scanner;

public class ArraysCode {

	public static void main(String[] args)
	{
		
		//5. Declare a new array
		int[] randomNumbers = new int[3];
		
		//6. Random number

		for (int i = 0; i < randomNumbers.length; i++)
		{
			final int MULTIPLIER = 10;
			int newNumbers = (int)Math.random()*MULTIPLIER;
			randomNumbers[i] = newNumbers;
		}

		// 1. Example of processing arrays
		final int TOTAL_NUMBERS = 5;
		// initialize array
		int[] numbers = new int[TOTAL_NUMBERS];
		//explain
		int numbersLength = numbers.length;

		// //Increment the index values 1 after every input into the array
		System.out.println("Update this message with what is going on");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + numbersLength + " values: ");
		for (int index = 0; index < numbersLength; index++) {
			System.out.printf("Enter value #%d: ", index+1);
			numbers[index] = input.nextInt();
		}

		// 2. Explain
		System.out.println("Update this message with what is going on");
		for (int index = 0; index < numbersLength; index++) {
			System.out.println("numbers[" + index + "] = " + numbers[index]);
		}

		// 3. Explain
		System.out.println("Update this message with what is going on");
		int badNameVar = 0;
		for (int index = 0; index < numbers.length; index++) {
			badNameVar = badNameVar + numbers[index];
		}
		System.out.println("Update badNameVar = " + badNameVar);

		// 4. Explain
		System.out.println("Update this message with what is going on");
		int badNameVar2 = numbers[0];
		for (int index = 1; index < numbers.length; index++) {
			if (numbers[index] > badNameVar2) {
				badNameVar2 = numbers[index];
			}
		}
		System.out.println("Update badNameVar2 = " + badNameVar2);
		
		// 5. Declare new array called randomNumbers 
		
		// 6. Write Code to fill the array with random numbers from 1 to 10 
		
		// 7. Write Code to find the index containing the smallest number in the randomNumbers array 
		
		// 8. write code to display the index and value of the smallest number
		
		// 9. write a method to return the index containing the smallest number in the randomNumber array
		
		
		input.close();
	} // main
	

	
}// end class
