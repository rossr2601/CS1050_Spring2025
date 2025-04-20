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
		String[] athBMICategory = new String[athleteNum];
		
		//getting generic info to be used in later calculations
		for (int index = 0; index < athleteNum; index++)
		{
			System.out.print("\nEnter Athlete " + (index+1) + " weight(lbs): ");
			athWeight[index] = getValidDouble(userInput);
			System.out.print("\nEnter Athlete " + (index+1) + " age: ");
			athAge[index] = getValidInt(userInput);
			System.out.print("\nEnter Athlete " + (index+1) + " height(in): ");
			athHeight[index] = getValidDouble(userInput);
			// dailyCal pops in each iteration and we don't use it for 
			// anything else so it makes sense to immediately calc avgCal
			double[] dailyCal = getDailyCalBurned(userInput);
			avgCal[index] = avgCalBurned(dailyCal);
			athBMI[index] = calcBMI(athHeight[index],athWeight[index]);
			// I think putting these variables in now will make iterating through
			// the arrays for the summary easier
			athBMICategory[index] = categoryBMI(athBMI[index]);
			
		}
		
		for (int j = 0; j < athleteNum; j++)
		{
			athSummary(j,athAge[j],avgCal[j],athBMI[j],athBMICategory[j]);
		}
		
		topAth(avgCal);
		getUnderweightAth(athBMICategory);
		
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
			System.out.print("\nEnter calories burned on day " + (count+1) + ":");
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
		
		double roundedAvg = Math.round(avg * 100.0) / 100.0;
		
		return roundedAvg;
	}
	
	// no need to validate because age has been
	public static int maxHeartRate(int athAge)
	{
		int maxHR = 220 - athAge;
		return maxHR;
	}
	
	// no need to validate b/c height and weight have already been previously
	public static double calcBMI(double height, double weight)
	{
		double BMI = (703*weight)/(height*height);
		double roundedBMI = Math.round(BMI * 100.0)/ 100.0;
		return roundedBMI;
	}
	
	// assigning to a new array to be called on makes more sense
	// I know I'm kind of just doing classes but in methods but it works best
	// in my brain
	public static String categoryBMI(double BMI)
	{
		String category;
		
		if (BMI < 18.5)
		{
			category = "Underweight";
		}
		else if (18.5 <= BMI && BMI < 25)
		{
			category = "Normal";
		}
		else if (25 <= BMI && BMI < 30)
		{
			category = "Overweight";
		}
		else
		{
			category = "Obese";
		}
		return category;
	}	
	
	public static void athSummary(int athNum, int athAge, double avgCal, double BMI, String catBMI)
	{
		System.out.println("\nAthlete " + (athNum +1) + " Summary");
		// doing HR calc here cause no need to do it sooner
		System.out.println("\n\tMax Heart Rate: " + maxHeartRate(athAge));
		System.out.println("\tAverage Daily Calories Burned: " + avgCal);
		System.out.print("\tBMI: " + BMI);
		System.out.println("\tCategory: " + catBMI);
	}
	
	public static void topAth(double[] avgCal)
	{
		double currentMax = avgCal[0];
		for (int count = 0; count < avgCal.length; count++)
		{
			if(avgCal[count] > currentMax)
			{
				currentMax = avgCal[count];
			}
		}
		
		System.out.println("Top Athlete by average daily calories burned is: Athlete " + (currentMax+1));
	}
	
	public static void getUnderweightAth(String[] BMICat)
	{
		for (int count = 0; count < BMICat.length; count++)
		{
			if (BMICat[count] == "Underweight")
			{
				System.out.println("Athlete " + (count+1) + " is underweight.");
			}
		}
	}
	

}
