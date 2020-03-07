import java.util.Scanner;

public class subjectPrint 
{
	public static void main(String[] args) 
	{
		// Setup
		Scanner keyboard = new Scanner(System.in);
		int dataNum;
		System.out.println("Enter Data Num :");
		dataNum = keyboard.nextInt();
		String subject[] = new String[dataNum];
		int credit[] = new int[dataNum];
		
		// Input
		System.out.println("Enter Subject Title(Note : Please change ' ' to '_')");
		for (int i = 0; i < dataNum; i++)
			subject[i] = keyboard.next();
		System.out.println("Enter Subject Credit");
		for (int i = 0; i < dataNum; i++)
			credit[i] = keyboard.nextInt();

		// Print
		for (int i = 0; i < dataNum; i++)
		{
			System.out.println(subject[i] + "  " + credit[i]);
		}
	}
}