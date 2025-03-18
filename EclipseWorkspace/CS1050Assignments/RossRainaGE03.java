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
		
		final double CP_WEIGHT = 0.1;
		final double GE_WEIGHT = 0.2;
		final double Q_WEIGHT = 0.25;
		final double PI_WEIGHT = 0.25;
		final double FE_WEIGHT = 0.2;
		
		System.out.println("CS1050 Final Grades\n");
		programInfo(CP_WEIGHT,GE_WEIGHT,Q_WEIGHT,PI_WEIGHT,FE_WEIGHT);
		
		Scanner input = new Scanner(System.in);
		
		// user prompting to input grades
		System.out.println("\nEnter Class Participation Grade: ");
		double classParticipation  =  getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.println("Enter Guided Exploration Grade: ");
		double guidedExploration = getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.println("Enter Quiz Grade: ");
		double quizzes = getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.println("Enter Project Iteration Grade: ");
		double projectIteration = getValidGrade(MIN_GRADE, MAX_GRADE, input);
		
		System.out.println("Enter Final Exam Grade: ");
		double finalExam = getValidGrade(MIN_GRADE, MAX_GRADE, input);

		// final grade calculation
		double finalGrade = ((CP_WEIGHT*classParticipation)
				+(GE_WEIGHT*guidedExploration)
				+(Q_WEIGHT*quizzes)
				+(PI_WEIGHT*projectIteration)
				+(FE_WEIGHT*finalExam));
		
		System.out.println("Final Percent: " + finalGrade + "%");
		
		// print final letter grade
		System.out.println("Final Letter Grade: " + determineLetterGrade(finalGrade));
		
	}

	public static double getValidGrade (double MIN_GRADE, double MAX_GRADE, Scanner input) {
		
		// ensuring that to start the grade is not within range
		double grade = -1;
		
		while (grade < 0 || grade > 105)
		{
			grade = input.nextDouble();
			
			//error message to display if outside of range
			if (grade < 0 || grade > 105)
			{
				System.out.println("Please input a grade between 0 and 105");
			}
		}
		return grade;
	}
	
	public static void programInfo (double CP_WEIGHT, double GE_WEIGHT, double Q_WEIGHT, double PI_WEIGHT, double FE_WEIGHT) {
		
		System.out.println("Categories\n");
		System.out.println("Class Paricipation " + (CP_WEIGHT*100) + "%");
		System.out.println("Guided Exploration " + (GE_WEIGHT*100) + "%");
		System.out.println("Quizzes " + (Q_WEIGHT*100) + "%");
		System.out.println("Project Iterations " + (PI_WEIGHT*100) + "%");
		System.out.println("Final Exam " + (FE_WEIGHT*100) + "%");
		
		System.out.println("\nGrade Ranges\n");
		System.out.println("A: 90 to 100");
		System.out.println("B: 80 to < 90");
		System.out.println("C: 70 to < 80");
		System.out.println("D: 60 to < 70");
		System.out.println("F: < 60");
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
