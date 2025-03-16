/**
 * 
 */

/**
 * 
 */
public class Part2_SumMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 5;
		
		System.out.println("Total is " + sum(max));
		
		}
	public static int sum (int max) {
		
		int total = 0;
		int count = 0;
		
		while (count <= max) {
			total = total + count;
			count++;
			}
		return total;
		}
	}
