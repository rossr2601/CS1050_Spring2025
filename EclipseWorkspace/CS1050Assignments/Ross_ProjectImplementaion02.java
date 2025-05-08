import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * 
 */



/**
 * 
 */

public class Ross_ProjectImplementaion02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String GYM01_FILE = "gym1.txt";
		
		Gym gym01 = new Gym("Epic-ness", 4);
	
		try
		{
			gymSetUp(gym01, GYM01_FILE);
			gym01.displayAllAthletes();
			
			gym01.topAthlete();
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: Can't upload athlete information\n" + e.getMessage());
		}
		
	}

	public static void gymSetUp(Gym gym, String filename) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try 
		{
			fileScanner = new Scanner(new File(filename));
			// add athletes from a file to gym
			while (fileScanner.hasNextLine())
	         {
	         	String firstName = fileScanner.next().trim();
	         	String lastName = fileScanner.next().trim();         
	         	double weight = fileScanner.nextDouble();
	         	double height = fileScanner.nextDouble();
	         	int age = fileScanner.nextInt();
	         	double[] dailyCal = new double[7];
	     		for (int count = 0; count < 7; count++)
	     		{
	     			dailyCal[count] = fileScanner.nextDouble();
	     		}
	     		Athlete tempAthlete = new Athlete(firstName, lastName, weight, height, age, dailyCal);
	     		gym.addAthlete(tempAthlete);
	         }
		} finally
			 {
				 if (fileScanner != null)
				 {
					 fileScanner.close();
				 }
			 }
		}
}

class Gym {
	private String name;
	private int currentNumAthletes;
	private Athlete[] athleteList;
	
	// Constructor
	public Gym(String name, int athleteMax)
	{
		athleteList = new Athlete[athleteMax];
		this.name = name;
		currentNumAthletes = 0;
	}
	
	// getters for instance variables
	public String getName()
	{
		return name;
	}
	
	public int getNumAthlete()
	{
		return currentNumAthletes;
	}
	
	// searches through array to compare the avg cal burned
	public void topAthlete()
	{
		double currentTop = athleteList[0].avgCalBurned();
		int currentTopIndex = 0;
		for (int count = 1; count < athleteList.length; count++)
		{
			if (athleteList[count].avgCalBurned() > currentTop)
			{
				currentTop = athleteList[count].avgCalBurned();
				currentTopIndex = count;
			}
		}
		
		System.out.println("\nTop Athlete by average daily calories burned is: " 
		+ (athleteList[currentTopIndex].getFirstName()) + " " + (athleteList[currentTopIndex].getLastName()));
	}
	
	public void getUnderweightAthlete()
	{
		System.out.println("Underweight Athletes: ");
		// boolean flag for alternative outcome
		boolean noUnderweight = true;
		
		// Check if each athlete is underweight, if yes list them
		for (int count = 0; count < athleteList.length; count++)
		{
			if(athleteList[count].categoryBMI() == "Underweight")
			{
				System.out.println((athleteList[count].getFirstName()) + " " + (athleteList[count].getLastName()));
				noUnderweight = false;
			}
		}
		// Alternative outcome
		if(noUnderweight = true)
		{
			System.out.println("No Underweight Athletes");
		}
	}
	
	// adds new athlete to gym or returns error that gym is full
	public void addAthlete(Athlete newAthlete)
	{
		if (currentNumAthletes < athleteList.length)
		{
			athleteList[currentNumAthletes] = newAthlete;
			currentNumAthletes++;
		}
		else
		{
			System.out.println("Gym is full.");
		}
	}
	
	public void displayAllAthletes()
	{
		System.out.println("\n***** " + name + " Weekly Fitness Summary *****");
		
		for (int i = 0; i < currentNumAthletes; i++)
		{
			athleteList[i].displayInfo();
			System.out.println("\n**********************");
		}
	}
	
	public void saveReport() throws IOException
	{
		File reportFile = new File(name + "Report.txt");
		PrintWriter outputFile = new PrintWriter(reportFile);
		
		String absoluteFilePath = reportFile.getAbsolutePath();
		System.out.println("\nOpen the file located at " + absoluteFilePath);
		
		outputFile.close();
	}
	
}

class Athlete {
	private String firstName;
	private String lastName;
	private int age;
	private double height;
	private double weight;
	private double[] dailyCal = new double[7];
	
	// Constructor
	public Athlete(String firstName, String lastName, double weight, double height,
					int age, double[] dailyCal)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.dailyCal = dailyCal;
	}
	
	// getters for instance variables
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	// calculate athlete BMI
	public double calcBMI()
	{
		double BMI = (703*weight)/(height*height);
		return BMI;
	}
	
	public int maxHeartRate()
	{
		int maxHR = 220 - age;
		return maxHR;
	}
	
	// assign category based on BMI
	public String categoryBMI()
	{
		String category;
		double BMI = calcBMI();
		
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
	
	// calculate average calorie burned
	public double avgCalBurned()
	{
		double sum = 0;
		for (int count = 0; count < dailyCal.length; count++)
		{
			sum = dailyCal[count] + sum;
		}
		
		double avg = sum / dailyCal.length;
		
		
		return avg;
	}
	
	public void displayInfo()
	{
		System.out.println("\nAthlete: " + firstName + " " + lastName);
		System.out.println("\tMax Heart Rate: " + maxHeartRate());
		System.out.printf("%s%.1f", "\tAverage Daily Calories Burned: ", avgCalBurned());
		System.out.printf("%s%.1f","\n\tBMI: " , calcBMI());
		System.out.print("\tCategory: " + categoryBMI());
	}
}
