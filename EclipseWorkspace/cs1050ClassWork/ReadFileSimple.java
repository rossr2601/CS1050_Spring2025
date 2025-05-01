import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileSimple {
    public static void main(String[] args) {
        final String FILENAME = "gym1.txt"; 

        try {
            // Create a Scanner to read from the file
        	File testFile = new File(FILENAME);
            Scanner fileScanner = new Scanner(testFile);

            System.out.println("Reading file contents:");

            while (fileScanner.hasNextLine())
            {
            	
            	String firstName = fileScanner.next();
            	System.out.println(firstName);
            	
            	String lastName = fileScanner.next();
            	System.out.println(lastName);
            
            	double weight = fileScanner.nextDouble();
            	double height = fileScanner.nextDouble();
            	int age = fileScanner.nextInt();
            	
            	double[] dailyCal = new double[7];
        		
        		for (int count = 0; count < 7; count++)
        		{
        			dailyCal[count] = fileScanner.nextDouble();
        		}
            }
            // Always close the file when done
            fileScanner.close();

        } catch (FileNotFoundException e) {
            // Handle the case where the file does not exist
            System.out.println("Error: Could not open file: " + e.getMessage());
        }
    }
}
