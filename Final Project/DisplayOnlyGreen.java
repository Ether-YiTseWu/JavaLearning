import java.awt.Color;

public class DisplayOnlyGreen extends Filter
{
	private OFImage original;
    private int width;
    private int height;
    
	public DisplayOnlyGreen(String name) 
	{
		super(name);
	}

	public void apply(OFImage image) 
	{
		 original = new OFImage(image);
	     width = original.getWidth();
	     height = original.getHeight();
	     
	     for(int y = 0; y < height; y++) 
	     {
	    	 for(int x = 0; x < width; x++) 
	    	 {
	    		 Color color = new Color(image.getRGB(x,y));
	    		 int onlyGreen = new Color(0, color.getGreen(), 0).getRGB();
	    		 image.setRGB(x, y, onlyGreen);
	    	 }
	     }
	}
}
