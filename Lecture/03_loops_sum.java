/**
 * 
 */
import java.util.Scanner;
import java.lang.*;
/**
 * @author user
 *
 */
public class loops_sum 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		double num1 = 0.01, num2 = 1.0, sum = 0.0;
		while(num1 <= 1.0 || Math.abs(num1)-1 <= 0.0001)
		{
			//System.out.println("num 1: " + num1);
			sum += num1;
			num1 += 0.01;
		}
		System.out.println("Sum 1: " + sum);
		sum = 0.0;
		while(num2 >= 0.0)
		{
			//System.out.println("num 2: " + num2);
			sum += num2;
			num2 -= 0.01;
		}
		System.out.println("Sum 2: " + sum);
	}
}
