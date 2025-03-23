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
		double[] defaultWeight = defaultWeight();
		
	}

	public static double validateWeight(double weight, Scanner input) {
		weight = input.nextDouble();
		
		while (weight <= 0 || weight >= 1) {
			System.out.println("Please enter a weight between 0 and 1");
			weight = input.nextDouble();
		}
		
		return weight;
	}
	
	public static double[] defaultWeight() {
		double[] category = new double[5];
		
		category[0] = 0.1;
		category[1] = 0.2;
		category[2] = 0.25;
		category[3] = 0.25;
		category[4] = 0.2;
		
		return category;
		
	}
}
