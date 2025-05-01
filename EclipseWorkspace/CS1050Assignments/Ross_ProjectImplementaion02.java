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
	
	public double calcBMI(double height, double weight)
	{
		double BMI = (703*weight)/(height*height);
		double roundedBMI = Math.round(BMI * 100.0)/ 100.0;
		return roundedBMI;
	}
	
	public int maxHeartRate(int athAge)
	{
		int maxHR = 220 - athAge;
		return maxHR;
	}
	
	public String categoryBMI(double BMI)
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
	
	public double avgCalBurned(double[] dailyCal)
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
	
	public void displayInfo()
	{
		System.out.println("Athlete: " + firstName + " " + lastName);
		System.out.println("\tMax Heart Rate: " + maxHeartRate(age));
		System.out.println("\tAverage Daily Calories Burned: " + avgCalBurned(dailyCal));
		System.out.print("\tBMI: " + calcBMI(height, weight));
		System.out.print("\tCategory: " + categoryBMI(calcBMI(height, weight)));
	}
}
