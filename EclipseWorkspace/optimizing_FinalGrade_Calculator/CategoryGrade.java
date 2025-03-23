/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;

public class CategoryGrade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
	}
	
	public static double getValidGrade (double MIN_GRADE, double MAX_GRADE, Scanner input) {
		
		// ensuring that to start the grade is not within range
		double grade = -1;
		
		while (grade < MIN_GRADE || grade > MAX_GRADE)
		{
			grade = input.nextDouble();
			
			//error message to display if outside of range
			if (grade < MIN_GRADE || grade > MAX_GRADE)
			{
				System.out.println("Please input a grade between " + MIN_GRADE + " and " + MAX_GRADE);
			}
		}
		return grade;
	}
	
	public static char determineLetterGrade(double finalGrade)
	{
		char letterGrade = ' ';
			
		if (finalGrade >= 90)
		{
			letterGrade =  'A';
		}
		else if (finalGrade >= 80)
		{
			letterGrade = 'B';
		} 
		else if (finalGrade >= 70)
		{
			letterGrade = 'C';
		} 
		else if (finalGrade >= 60)
		{
			letterGrade = 'D';
		} 
		else
		{
			letterGrade = 'F';
		}
		return letterGrade;
	}

}
