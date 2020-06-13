import java.io.Serializable;

/**

 * The Item class represents a multi-media item.

 * Information about the item is stored and can be retrieved.

 * This class serves as a superclass for more specific itms.

 * 

 * @author Michael Kolling and David J. Barnes

 * @version 2008.03.30

 */

public class Item implements Serializable
{
    private String title;
    private int playingTime;
    private int price;
    private boolean gotIt;
    private String comment;

    /**

     * Initialise the fields of the item.

     * @param theTitle The title of this item.

     * @param time The running time of this item.

     */

    public Item(String theTitle, int thePrice, int time)
    {
        title = theTitle;
        price = thePrice;
        playingTime = time;
        gotIt = false;
        comment = "<no comment>";
    }
    
    public void setPrice(int price)
    {
    	this.price = price;
    }

    /**

     * Enter a comment for this item.

     * @param comment The comment to be entered.

     */

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**

     * @return The comment for this item.

     */
    public String getTitle()
    {
        return title;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public int getPlayingTime()
    {
        return playingTime;
    }

    public String getComment()
    {
        return comment;
    }

    /**

     * Set the flag indicating whether we own this item.

     * @param ownIt true if we own the item, false otherwise.

     */

    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**

     * @return Information whether we own a copy of this item.

     */

    public boolean getOwn()
    {
        return gotIt;
    }

    /**

     * Print details of this item to the text terminal.

     */

    public void print()
    {
        System.out.print(title + " (" + playingTime + " mins)" + ", price is " + price);

        if(gotIt) 
            System.out.println("*");
        else 
            System.out.println();

        System.out.println("    " + comment);
    }

}