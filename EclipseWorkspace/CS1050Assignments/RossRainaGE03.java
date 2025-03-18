/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;


public class RossRainaGE03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		final double MIN_GRADE = 0;
		final double MAX_GRADE = 105;
		
		System.out.print("CS1050 Final Grades");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Class Participation grade: ");
		double classParticipation  =  getValidGrade(MIN_GRADE, MAX_GRADE, input);

		
	}

	public static double getValidGrade (double MIN_GRADE, double MAX_GRADE, Scanner input) {
		
		double grade = -1;
		
		while (grade <= 0 || grade >=105)
		{
			grade = input.nextDouble();
			
			System.out.println("Please input a grade between 0 and 105");
		}
		return grade;
	
	}
	
}
