import java.util.Scanner;

/**
 * @author YiTse
 * @data 2020-5-7
 */

public class Demo
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Setup
		String yourName;
		int yourAge;
		Scanner scanner = new Scanner(System.in);
		PersonalData D1 = new PersonalData();
		
		// try, catch, and finally
		try
		{
			System.out.print("Please Input Your Name : ");
			yourName = scanner.nextLine();
			D1.setName(yourName);
			
			System.out.print("Please Input Your Age  : ");
			yourAge = scanner.nextInt();
			D1.setAge(yourAge);
		}
		catch (NameException e)
		{
			System.out.println("\n" + e.getMessage());
			e.printStackTrace();
		}
		catch (AgeException e)
		{
			System.out.println("\n" + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			D1.list();
		}
	}
}
