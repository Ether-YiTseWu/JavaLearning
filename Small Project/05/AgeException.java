/**
 * @author YiTse
 * @data 2020-5-7
 */

public class AgeException extends Exception
{
	private int age;
	
	AgeException(int theAge, String warning)
	{
		super(warning);
		this.age = theAge;
	}
	
	public int getAge()
	{
		return age;
	}
}
