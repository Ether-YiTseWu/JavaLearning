import java.io.Serializable;

/**
 * @author YiTse
 * @version 2020.4.30
 */

public class AudioBook extends Item
{
    private String author;
    private String type;

    public AudioBook(String theTitle, int time, int thePrice, String theType, String theAuthor)
    {
        super(theTitle, thePrice, time);
        type = theType;
        author = theAuthor;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void print()
    {
    	super.print();
        System.out.println("    author: " + author);
        System.out.println("    type: " + type);
    }
}
