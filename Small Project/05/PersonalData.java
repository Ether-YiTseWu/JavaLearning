import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author YiTse
 * @data 2020-5-7
 */

public class PersonalData 
{
	private String name;
	private int age;
	
	public void setName(String theName) throws NameException
	{
		name = theName;
		
		Pattern pattern = Pattern.compile("[0-9]+");  
        Matcher isNum = pattern.matcher(theName);  
        if( isNum.find() )
        {
        	name = "NULL";
        	age = -999;
        	throw new NameException(theName, "Sorry, but there are digits in your name");
        }
	}
	
	public void setAge(int theAge) throws AgeException
	{
		age = theAge;
		if (theAge < 0 || theAge > 120)
		{
			age = -999;
			if (theAge < 0)
				throw new AgeException(theAge, "Sorry, but your age is lower than 0");
			else
				throw new AgeException(theAge, "Sorry, but your age is higher than 120");
		}
	}
	
	public void list()
	{
		System.out.println("\nName : " + name);
		System.out.println("Age  : " + age);
	}
}
