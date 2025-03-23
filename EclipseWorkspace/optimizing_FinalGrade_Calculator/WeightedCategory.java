/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;

public class WeightedCategory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
	}

	public static double validateWeight(double weight, Scanner input) {
		weight = -1;
		System.out.print("\nEnter category weight: ");
		weight = input.nextDouble();
		
		while (weight < 0 || weight > 1) {
			System.out.println("Please enter a weight between 0 and 1");
			weight = input.nextDouble();
		}
		
		return weight;
	}
}
