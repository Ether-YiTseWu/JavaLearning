import java.io.Serializable;

/**
 * @author YiTse
 * @version 2020.4.30
 */

public class VideoGame extends Item
{
    private String company;
    private String type;

    public VideoGame(String theTitle, int time, int thePrice, String theType, String theCompany)
    {
        super(theTitle, thePrice, time);
        type = theType;
        company = theCompany;
    }
    
    public String getCompany()
    {
        return company;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void print()
    {
    	super.print();
        System.out.println("    company: " + company);
        System.out.println("    type: " + type);
    }
}
