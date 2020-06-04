/**
 * @author YiTse
 * @data 2020-5-7
 */

public class NameException extends Exception
{
	private String name;
	
	NameException(String theName, String warning)
	{
		super(warning);
		this.name = theName;
	}
	
	public String getName()
	{
		return name;
	}
}
