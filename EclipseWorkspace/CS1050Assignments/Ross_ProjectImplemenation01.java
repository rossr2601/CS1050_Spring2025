/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;

public class Ross_ProjectImplemenation01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner userInput = new Scanner(System.in);
		
		//query user for # of athletes for array construction
		System.out.print("Enter number of athletes: ");
		int athleteNum = getValidInt(userInput);
		
		//create relevant arrays for info to be put into for later display
		double[] athWeight = new double[athleteNum];
		int[] athAge = new int[athleteNum];
		double[] athHeight = new double[athleteNum];
		double[] avgCal = new double[athleteNum];
		double[] athBMI = new double[athleteNum];
		
		//getting generic info to be used in later calculations
		for (int index = 0; index < athleteNum; index++)
		{
			System.out.print("Enter Athlete " + (index+1) + " weight: ");
			athWeight[index] = getValidDouble(userInput);
			System.out.print("\nEnter Athlete " + (index+1) + " age: ");
			athAge[index] = getValidInt(userInput);
			System.out.print("\nEnter Athlete " + (index+1) + " height: ");
			athHeight[index] = getValidDouble(userInput);
			double[] dailyCal = getDailyCalBurned(userInput);
			avgCal[index] = avgCalBurned(dailyCal);
			
		}
		
	}
	
	public static int getValidInt(Scanner userInput)
	{
		int integer = userInput.nextInt();
		
		while (integer<=0) 
		{
			System.out.print("\nError: Value must be greater than 0.\nPlease try again: ");
			integer = userInput.nextInt();
		}
		return integer;
	}
	
	public static double getValidDouble(Scanner userInput)
	{
		double doubl = userInput.nextDouble();
		
		while (doubl <= 0)
		{
			System.out.print("\nError: Value must be greater than 0.\nPlease try again: ");
			doubl = userInput.nextDouble();
		}
		return doubl;
	}
	
	public static double[] getDailyCalBurned(Scanner userInput)
	{
		double[] dailyCal = new double[7];
		
		for (int count = 0; count < 7; count++)
		{
			System.out.print("Enter calories burned on day " + (count+1) + ":");
			dailyCal[count] = getValidDouble(userInput);
		}
		return dailyCal;
	}
	
	public static double avgCalBurned(double[] dailyCal)
	{
		double sum = 0;
		for (int count = 0; count < dailyCal.length; count++)
		{
			sum = dailyCal[count] + sum;
		}
		
		double avg = sum / dailyCal.length;
		
		return avg;
	}

}
