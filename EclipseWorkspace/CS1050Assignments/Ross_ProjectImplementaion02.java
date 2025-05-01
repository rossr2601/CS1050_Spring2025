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

		Athlete ath1 = new Athlete("Raina", "Ross", 64.4, 160.0, 20, new double[] {100, 200, 150, 300, 50, 164, 20});
	
		ath1.displayInfo();
	}

}

class Gym {
	private String name;
	private int athleteMax;
	private int currentNumAthletes;
	private Athlete[] athleteList = new Athlete[athleteMax];
	
	// Constructor
	public Gym(String name, int athleteMax)
	{
		this.name = name;
		this.athleteMax = athleteMax;
		currentNumAthletes = 0;
	}
	
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
		
		System.out.println("Top Athlete by average daily calories burned is: " + (athleteList[currentTopIndex].getFirstName()));
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
	public Athlete(String firstName, String lastName, double height, double weight,
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
		System.out.println("Athlete: " + firstName + " " + lastName);
		System.out.println("\tMax Heart Rate: " + maxHeartRate());
		System.out.printf("%s%.2f", "\tAverage Daily Calories Burned: ", avgCalBurned());
		System.out.printf("%s%.2f","\n\tBMI: " , calcBMI());
		System.out.print("\tCategory: " + categoryBMI());
	}
}
