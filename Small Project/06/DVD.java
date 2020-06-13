import java.io.Serializable;

/**

 * The DVD class represents a DVD object. Information about the 

 * DVD is stored and can be retrieved. We assume that we only deal 

 * with movie DVDs at this stage.

 * 

 * @author Michael Kolling and David J. Barnes

 * @version 2008.03.30

 */

public class DVD extends Item

{
    private String director;
    
    /**
     * Constructor for objects of class DVD
     * @param theTitle The title of this DVD.
     * @param theDirector The director of this DVD.
     * @param time The running time of the main feature.
     */
    public DVD(String theTitle, int time, int thePrice, String theDirector)
    {
        super(theTitle, thePrice, time);
        director = theDirector;
    }

    /**

     * @return The director for this DVD.

     */

    public String getDirector()

    {
        return director;
    }

    /**

     * Print details of this DVD to the text terminal.

     */

    public void print()
    {
    	super.print();
        System.out.println("    director: " + director);
    }

}