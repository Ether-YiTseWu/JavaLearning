/**
 * @author Administrator
 *
 */
import java.util.Scanner;

public class addTwoNum
{
	public static void main(String[] args)
	{
		System.out.println("Hello out there!");
		System.out.println("I will add two numbers for you");
		System.out.println("Enter Two Whole Numbers on a line :");
		int n1, n2;
		Scanner keyboard = new Scanner(System.in);
		n1 = keyboard.nextInt();
		n2 = keyboard.nextInt();
		System.out.println("The sum of these two numbers is :");
		System.out.println(n1+n2);
	}
}
