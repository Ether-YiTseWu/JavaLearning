import java.awt.Color;

public class DisplayOnlyRed extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
	public DisplayOnlyRed(String name) 
	{
		super(name);
	}

	@Override
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
	    		 int onlyRed = new Color(color.getRed(), 0, 0).getRGB();
	    		 image.setRGB(x, y, onlyRed);
	    	 }
	     }
	}
}
