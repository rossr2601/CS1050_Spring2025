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
		
		
		
	}
	
	public static int getValidInt(Scanner userInput)
	{
		int integer = userInput.nextInt();
		
		while (integer<=0) 
		{
			System.out.println("Error: Value must be greater than 0.");
			System.out.print("Enter number of athletes: ");
			integer = userInput.nextInt();
		}
		return integer;
	}

}
