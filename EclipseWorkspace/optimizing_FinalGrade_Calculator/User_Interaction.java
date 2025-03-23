/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;

public class User_Interaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		double[] categories = new double[5];
		double[] grades = new double[5];
		
		categories = userCategoryWeight(categories, input);
		
		validateCategoryWeight(categories, input);
		
	}
	
	public static double[] userCategoryWeight(double categories[], Scanner input) {
		
		System.out.print("\nEnter Class Participation Weight: ");
		categories[0] = WeightedCategory.validateWeight(0, input);
		
		System.out.print("Enter Guided Exploration Weight: ");
		categories[1] = WeightedCategory.validateWeight(0, input);
		
		System.out.print("Enter Quiz Weight: ");
		categories[2] = WeightedCategory.validateWeight(0, input);
		
		System.out.print("Enter Project Iteration Weight: ");
		categories[3] = WeightedCategory.validateWeight(0, input);
		
		System.out.print("Enter Final Exam Weight: ");
		categories[4] = WeightedCategory.validateWeight(0, input);
		
		return categories;
	}
	
	public static void validateCategoryWeight(double passedArray[], Scanner input) {
		
		double sum = 0;
		int i = 0;
		
		while (sum <=0 || sum > 1) {
			
			for (i = 0; i < passedArray.length; i++) {
			sum = passedArray[i] + sum;
			}
		
			if (sum == 1) {
			System.out.println("Begin entering grades");
			}
			else {
			System.out.println("Please re-enter category weights. "
					+ "They must add to 1");	
			passedArray = userCategoryWeight(passedArray, input);
			sum = 0;
			}
		
		}
	}

}
