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
		final double MIN_GRADE = 0;
		final double MAX_GRADE = 105;
		
		double[] categories = new double[5];
		double[] grades = new double[5];
		
		String userContinue = "n";
		
		do {
		
		System.out.println("Do you wish to use the default category weights? (y/n)");
		String userWeight = input.next();
		
		if (userWeight.equals("y")) {
			double[] defaultWeight = WeightedCategory.defaultWeight();
			System.out.println("Class Participation: " + defaultWeight[0]);
			System.out.println("Guided Exploration: " + defaultWeight[1]);
			System.out.println("Quiz: " + defaultWeight[2]);
			System.out.println("Project Iterations: " + defaultWeight[3]);
			System.out.println("Final Exam: " + defaultWeight[4]);
			categories = defaultWeight;
		}
		else {
		categories = userCategoryWeight(categories, input);
		
		validateCategoryWeight(categories, input);
		}
		
		grades = userGrades(grades, MIN_GRADE, MAX_GRADE, input);
		
		double result = 0;
		for (int i = 0; i < grades.length; i++) {
			result = (grades[i]*categories[i])+result;
		}
		
		double finalGrade = result;
		
		System.out.println("\nFinal Percent: " + finalGrade + "%");
		System.out.println("Final Letter Grade: " + CategoryGrade.determineLetterGrade(finalGrade));
		
		System.out.print("Do you want to input another student's grades? (y/n): ");
		userContinue = input.next();
		
		} while (userContinue.equals("y"));
		
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
		
		while (sum <=0 || sum > 1) {
			
			for (int i = 0; i < passedArray.length; i++) {
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
	
	public static double[] userGrades(double grades[], double MIN_GRADE, double MAX_GRADE, Scanner input) {
		System.out.print("\nEnter Class Participation Grade: ");
		grades[0]  =  CategoryGrade.getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.print("Enter Guided Exploration Grade: ");
		grades[1] = CategoryGrade.getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.print("Enter Quiz Grade: ");
		grades[2] = CategoryGrade.getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.print("Enter Project Iteration Grade: ");
		grades[3] = CategoryGrade.getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.print("Enter Final Exam Grade: ");
		grades[4] = CategoryGrade.getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		return grades;
	}

}
