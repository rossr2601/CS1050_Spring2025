/*
 * Raina Ross
 * CS1050 (T/R)
 * 2/09/25
 * Guided Exploration 01
 * This program will print a couple paragraphs about my passions and interests.       
 * The program will store and display my final grade based on the weights in the syllabus

/**
 * 
 * 
 */
import java.util.Scanner;

public class RossRainaGE01Calculations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Print 2 paragraphs about myself
		System.out.print("Hi my name is Raina and I am a computer science major.\n");
		System.out.print("I am technically a senior, but I recently switched my major to CS.\n");
		System.out.print("My goal is to work in Data engineering one day.\n\n");
		
		System.out.print("My passions include persuing the great outdoors.\n");
		System.out.print("It's one of the big reasons that I moved to Colorado.\n");
		System.out.print("One day I would love to complete the Pacific Crest Trail.\n");
		
		
		//Adding grade calculations
		
		//allowing user input from keyboard
		try (Scanner input = new Scanner(System.in)) {;
		
		//defining weight categories
		final double CLASS_PARTICPATION_WEIGHT = 0.1;
		final double GUIDED_EXPLORATIONS_WEIGHT = 0.2;
		final double MODULE_QUIZ_WEIGHT = 0.25;
		final double PROJECT_ITERATION_WEIGHT = 0.25;
		final double FINAL_WEIGHT = 0.2;
		
		
		//getting user input for grades
		System.out.print("\nWhat is your average in Class Participation?  ");
		double classParticipation = input.nextDouble();
		
		System.out.print("\nWhat is your average in Guided Explorations?  ");
		double guidedExploration = input.nextDouble();
		
		System.out.print("\nWhat is your average in Module Quizzes?  ");
		double moduleQuiz = input.nextDouble();
		
		System.out.print("\nWhat is your average in Project Iterations?  ");
		double projectIteration = input.nextDouble();
		
		System.out.print("\nWhat is your Final exam grade?  ");
		double finalExam = input.nextDouble();
		
		//final grade calculation
		int finalGrade = (int) ((CLASS_PARTICPATION_WEIGHT*classParticipation)
							+(GUIDED_EXPLORATIONS_WEIGHT*guidedExploration)
							+(MODULE_QUIZ_WEIGHT*moduleQuiz)
							+(PROJECT_ITERATION_WEIGHT*projectIteration)
							+(FINAL_WEIGHT*finalExam));
		
		//display final grade to user
		System.out.printf("\nYour final grade is " + finalGrade);
		
				
			
		
		}
	}

}
