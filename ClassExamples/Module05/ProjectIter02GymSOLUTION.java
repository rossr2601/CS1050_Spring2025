import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//Main class
public class ProjectIter02Gym
{
	public static void main(String[] args)
	{
		int MAX_GYM_MEMBERS = 3;
		
		Gym gym1 = new Gym("Elite Fitness", MAX_GYM_MEMBERS);

		try
		{
			readGymAthletesInfoFromFile("gym1.txt", gym1);
			gym1.displayAthleteSummaries();
			gym1.saveReportToFile();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}
		
		Gym gym2 = new Gym("Work in Progress", MAX_GYM_MEMBERS);

		try
		{
			readGymAthletesInfoFromFile("gym2.txt", gym2);
			gym2.displayAthleteSummaries();
			gym2.saveReportToFile();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}

	}

	/**
	 * 
	 */
	public static void readGymAthletesInfoFromFile(String filename, Gym currentGym) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try
		{

			fileScanner = new Scanner(new File(filename));


			while (fileScanner.hasNext())
			{
				String firstName = fileScanner.next().trim();
				String lastName = fileScanner.next().trim();

				double weight = fileScanner.nextDouble();
				double height = fileScanner.nextDouble();
				int age = fileScanner.nextInt();
				double[] dailyCalories = new double[7];
				for (int i = 0; i < 7; i++)
				{
					dailyCalories[i] = fileScanner.nextDouble();
				}
				fileScanner.nextLine();
				
				Athlete tempAthlete = new Athlete(firstName, lastName, weight, height, age, dailyCalories);
				
				currentGym.addAthlete(tempAthlete);
			}
		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}// end load cars

}



// Athlete class 
class Athlete 
{
	private String firstName;
	private String lastName;
	private double weight; // in lbs
	private double height; // in inches
	private int age;
	private double[] dailyCaloriesBurned;


	public Athlete(String firstName, String lastName, double weight, double height, int age,
			double[] dailyCaloriesBurned)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.dailyCaloriesBurned = dailyCaloriesBurned;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public double calculateBMI()
	{
		final int BMI_US_FACTOR = 703;
		return (weight * BMI_US_FACTOR) / (height * height);
	}
	

	public int calculateMaxHeartRate()
	{
		return 220 - age;
	}

	public String getBMICategory()
	{
        String category;
		if (this.calculateBMI() < 18.5) {
			category = "Underweight";
		}
		else if (this.calculateBMI() < 25) {
			category = "Normal";
		}
		else if (this.calculateBMI() < 40) {
			category = "Overweight";
		}
		else {
			category = "Obese";
		}
		return category;
		
	}
	
	public double getAverageCaloriesBurned()
	{
		double total = 0;
		for (int day = 0; day < dailyCaloriesBurned.length; day++) {
            total = total + dailyCaloriesBurned[day];
        }
		double average = total/dailyCaloriesBurned.length;
		return average;
	}


}

// Gym class (Stores trainer and athletes)
class Gym
{
	private String name;
	private Athlete[] athletes;
	private int numAthletes;

	public Gym(String name, int maxAthletes)
	{
		this.name = name;
		this.athletes = new Athlete[maxAthletes];
		this.numAthletes = 0;
	}
	

	public void addAthlete(Athlete athlete)
	{
		if (numAthletes < athletes.length)
		{
			athletes[numAthletes] = athlete;
			numAthletes++;
		}else
		{
			System.out.printf("Gym is full. Can't add %s %s ",
					athlete.getFirstName(),
					athlete.getLastName());
		}
	}

	public void displayAthleteSummaries()
	{
		System.out.println("\n****** Gym Fitness Report ******");
		System.out.println("Gym: " + name);

		for (int i = 0; i < numAthletes; i++)
		{
	        System.out.printf("Athlete: %s %s\n "
	        		+ "\tMax Heart Rate: %d bpm\n "
	        		+ "\tAverage Daily Calories Burned: %.1f\n "
	        		+ "\tBMI: %.1f \tCategory: %s\n",
	        		athletes[i].getFirstName(), athletes[i].getLastName(),  
	        		athletes[i].calculateMaxHeartRate(), athletes[i].getAverageCaloriesBurned(),  
	        		athletes[i].calculateBMI(), athletes[i].getBMICategory());

		}
		int indexTopAthlete = findTopAthlete();
		System.out.printf("\nTop Athlete (Most Calories Burned): %s %s\n", 
				athletes[indexTopAthlete].getFirstName(),
				athletes[indexTopAthlete].getLastName());
		
		displayUnderweightAthletes();
	}

	public void saveReportToFile() throws FileNotFoundException
	{
		File file = new File(name + "_Report.txt");
		PrintWriter outputFile = new PrintWriter(file);
		outputFile.println("****** Gym Fitness Report ******");

		for (int i = 0; i < numAthletes; i++)
		{
			outputFile.printf("Athlete: %s %s\n "
	        		+ "\tMax Heart Rate: %d bpm\n "
	        		+ "\tAverage Daily Calories Burned: %.1f\n "
	        		+ "\tBMI: %.1f \tCategory: %s\n",
	        		athletes[i].getFirstName(), athletes[i].getLastName(), 
	        		athletes[i].calculateMaxHeartRate(), athletes[i].getAverageCaloriesBurned(),  
	        		athletes[i].calculateBMI(), athletes[i].getBMICategory());
		}

		outputFile.close();
		System.out.println("\nReport saved to: " + file.getAbsolutePath());
	}

	private int findTopAthlete()
	{
		int topIndex = 0;
		for (int i = 1; i < numAthletes; i++)
		{
			if (athletes[i].getAverageCaloriesBurned() > athletes[topIndex].getAverageCaloriesBurned())
			{
				topIndex = i;
			}
		}
		return topIndex;
	}
	
    private void displayUnderweightAthletes() {
        System.out.println("\nUnderweight Athletes:");
        boolean found = false;
        for (int index = 0; index < numAthletes; index++) {
            if (athletes[index].calculateBMI() < 18.5) {
	            System.out.printf("\n%s %s\n", 
        						athletes[index].getFirstName(),
        						athletes[index].getLastName());
                found = true;
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No underweight athletes.");
        }
    }
	
}
