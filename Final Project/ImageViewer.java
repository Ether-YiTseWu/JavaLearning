import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

/**
 * ImageViewer is the main class of the image viewer application. It builds and
 * displays the application GUI and initialises all other components.
 * 
 * To start the application, create an object of this class.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 3.1
 */
public class ImageViewer
{
    // static fields:
    private static final String VERSION = "Version 3.2";
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    // fields:
    private JFrame frame;
    private JFrame originalImgFrame;
    private ImagePanel imagePanel;
    private JLabel filenameLabel;
    private JLabel statusLabel;
    private JButton smallerButton;
    private JButton largerButton;
    private OFImage currentImage;
    private List<Filter> filters;
    
    private int filterNum = 0, csvWriteNum = 0, openFileNum = 0, openFileNumJudge = 0;
    private String cutSizeX, cutSizeY;
    private int X, Y;
    private JButton cutButton, rotateButton, mirrorButton;
	private PrintWriter outputStream = null;
	private String theCSVPath;
	private ArrayList<String> motionRecord = new ArrayList<String>();
    
    /**
     * Create an ImageViewer and display its GUI on screen.
     */
    public ImageViewer()
    {
        currentImage = null;
        filters = createFilters();
        makeFrame();
    }
    
    // ---- csv ---- By YiTse
    
    public void createCSV()
    {
    	// Create file
    	File file = new File(theCSVPath);
    	try
    	{
    		if(file.createNewFile())
    			System.out.println("Create the file successfully : " + theCSVPath + "\n");
    		else
    			System.out.println("The file, " + theCSVPath + ", has been created");
    	}
    	catch(IOException ioe)
    	{
    		ioe.printStackTrace();
    	}
    }
    
    public void writeCSV()
    {
        try
		{
        	outputStream = new PrintWriter(theCSVPath);
        	outputStream.println("No.,Motion user did");
        	for (int i = 1 ; i <= csvWriteNum ; i++)
        	{
        		outputStream.print(i);
        		outputStream.println(","+motionRecord.get(i-1));
        	}
        }
		catch (FileNotFoundException e)
        {
			e.printStackTrace();
        } 
        outputStream.close();
    }
    
    public void setCSVName(String theCSVName)
    {
    	theCSVPath = theCSVName;
    }
    
    public int getWriteNum()
    {
    	return csvWriteNum;
    }
    
    // ---- implementation of menu functions ----
    
    /**
     * Open function: open a file chooser to select a new image file,
     * and then display the chosen image.
     */
    private void openFile()
    {
    	csvWriteNum ++;
    	motionRecord.add("Open Image");
    	writeCSV();
    	
        int returnVal = fileChooser.showOpenDialog(frame);

        if(returnVal != JFileChooser.APPROVE_OPTION) {
            return;  // cancelled
        }
        File selectedFile = fileChooser.getSelectedFile();
        currentImage = ImageFileManager.loadImage(selectedFile);
        
        if(currentImage == null) {   // image file was not a valid image
            JOptionPane.showMessageDialog(frame,
                    "The file was not in a recognized image file format.",
                    "Image Load Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        imagePanel.setImage(currentImage);
        setButtonsEnabled(true);
        showFilename(selectedFile.getPath());
        showStatus("File loaded.");
        frame.pack();
        
        if (openFileNum >= 1)
        	openFileNumJudge = openFileNum;
        openFileNum ++;
    }

    /**
     * Close function: close the current image.
     */
    private void close()
    {
        if(currentImage != null) 
        {
        	csvWriteNum ++;
        	motionRecord.add("Close Image");
        	writeCSV();
        }
    	
        currentImage = null;
        imagePanel.clearImage();
        showFilename(null);
        setButtonsEnabled(false);
    }

    /**
     * Save As function: save the current image to a file.
     */
    private void saveAs()
    {
        if(currentImage != null) 
        {
            int returnVal = fileChooser.showSaveDialog(frame);
    
            if(returnVal != JFileChooser.APPROVE_OPTION) 
            {
                return;  // cancelled
            }
            File selectedFile = fileChooser.getSelectedFile();
            ImageFileManager.saveImage(currentImage, selectedFile);
            
            showFilename(selectedFile.getPath());
            
        	csvWriteNum ++;
        	motionRecord.add("Save Image");
        	writeCSV();
        }
    }

    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
    	csvWriteNum ++;
    	motionRecord.add("Quit");
    	writeCSV();
    	
        System.exit(0);
    }

    /**
     * Apply a given filter to the current image.
     * 
     * @param filter   The filter object to be applied.
     */
    private void applyFilter(Filter filter)
    {
    	if (openFileNum - openFileNumJudge == 1 && openFileNum > 1)
        	filterNum = 0;
    	
        if(currentImage != null) 
        {
        	if (filterNum == 0)
        	{
        		originalImgFrame = new JFrame("Original Image");
            	File selectedFile = fileChooser.getSelectedFile();
            	ImageIcon originalImg = new ImageIcon(selectedFile.getPath());
            	originalImgFrame.add(new JLabel(originalImg));
            	originalImgFrame.pack();
            	originalImgFrame.setVisible(true);
        	}

            filter.apply(currentImage);
            frame.repaint();
            showStatus("Applied: " + filter.getName());
            
            filterNum ++;
            openFileNum ++;
        	csvWriteNum ++;
        	motionRecord.add("Apply Filter : " + filter.getName());
        	writeCSV();
        }
        else
            showStatus("No image loaded.");
    }

    /**
     * 'About' function: show the 'about' box.
     */
    private void showAbout()
    {
    	csvWriteNum ++;
    	motionRecord.add("Show About");
    	writeCSV();
    	
        JOptionPane.showMessageDialog(frame, 
                    "ImageViewer\n" + VERSION,
                    "About ImageViewer", 
                    JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Make the current picture larger.
     */
    private void makeLarger()
    {
    	
        if(currentImage != null) 
        {
            // create new image with double size
            int width = currentImage.getWidth();
            int height = currentImage.getHeight();
            OFImage newImage = new OFImage(width * 2, height * 2);

            // copy pixel data into new image
            for(int y = 0; y < height; y++) 
            {
                for(int x = 0; x < width; x++) 
                {
                    Color col = currentImage.getPixel(x, y);
                    newImage.setPixel(x * 2, y * 2, col);
                    newImage.setPixel(x * 2 + 1, y * 2, col);
                    newImage.setPixel(x * 2, y * 2 + 1, col);
                    newImage.setPixel(x * 2+1, y * 2 + 1, col);
                }
            }
            
            currentImage = newImage;
            imagePanel.setImage(currentImage);
            frame.pack();
            
        	csvWriteNum ++;
        	motionRecord.add("Make Larger");
        	writeCSV();
        }
        File selectedFile = fileChooser.getSelectedFile();
    	showFilename(selectedFile.getPath());
    }
    

    /**
     * Make the current picture smaller.
     */
    private void makeSmaller()
    {
        if(currentImage != null) 
        {
            // create new image with double size
            int width = currentImage.getWidth() / 2;
            int height = currentImage.getHeight() / 2;
            OFImage newImage = new OFImage(width, height);

            // copy pixel data into new image
            for(int y = 0; y < height; y++)
                for(int x = 0; x < width; x++)
                    newImage.setPixel(x, y, currentImage.getPixel(x * 2, y * 2));
            
            currentImage = newImage;
            imagePanel.setImage(currentImage);
            frame.pack();
            
        	csvWriteNum ++;
        	motionRecord.add("Make Smaller");
        	writeCSV();
        }
        File selectedFile = fileChooser.getSelectedFile();
    	showFilename(selectedFile.getPath());
    }
    
    // By YiTse
    private void cut()
    {
    	if(currentImage != null) 
    	{
        	cutSizeX = JOptionPane.showInputDialog("Please input the cut length of the image\n");
        	cutSizeY = JOptionPane.showInputDialog("Please input the cut width of the image\n");
        	X = Integer.parseInt (cutSizeX);
        	Y = Integer.parseInt (cutSizeY);
            OFImage newImage = new OFImage(X, Y);

            // copy pixel data into new image
            for(int y = 0; y < Y; y++) 
                for(int x = 0; x < X; x++) 
                	newImage.setPixel(x, y, currentImage.getPixel(x, y));
            
            currentImage = newImage;
            imagePanel.setImage(currentImage);
            frame.pack();
            
            csvWriteNum ++;
            motionRecord.add("Cut(" + X + " * " + Y + ")");
        	writeCSV();
    	}
    	File selectedFile = fileChooser.getSelectedFile();
    	showFilename(selectedFile.getPath());
    }
    
    // By YiTse
    private void rotate()
    {
    	if(currentImage != null) 
    	{
            int width = currentImage.getWidth();
            int height = currentImage.getHeight();
            OFImage newImage = new OFImage(height, width);
            
            // copy pixel data into new image (Rotate but need to mirror)
            for(int i = 0; i < height; i++) 
                for(int j = 0; j < width; j++) 
                	newImage.setPixel(i, j, currentImage.getPixel(j, i));
            
            // mirror
            OFImage newNewImage = new OFImage(height, width);
            height = newImage.getHeight();
            width = newImage.getWidth();
            int temp = 0;
            if (width % 2 != 0)
            	temp = 1;	// avoid black line if the width of the image is a odd number
            for(int y = 0; y < height; y++) 
            {
                for(int x = 0; x < (width + temp) / 2; x++) 
                {
                    Color left = newImage.getPixel(x, y);
                    newNewImage.setPixel(x, y, newImage.getPixel(width - 1 - x, y));
                    newNewImage.setPixel(width - 1 - x, y, left);
                }
            }
            
            currentImage = newNewImage;
            imagePanel.setImage(currentImage);
            frame.pack();
    		
        	csvWriteNum ++;
        	motionRecord.add("Rotate 90°");
        	writeCSV();
        	
        	File selectedFile = fileChooser.getSelectedFile();
        	showFilename(selectedFile.getPath());
    	}
    }
    
    private void mirror()
    {
    	if(currentImage != null) 
    	{
            int width = currentImage.getWidth();
            int height = currentImage.getHeight();
            OFImage newImage = new OFImage(width, height);
            int temp = 0;
            if (width % 2 != 0)
            	temp = 1;
            for(int y = 0; y < height; y++) 
            {
                for(int x = 0; x < (width + temp) / 2; x++) 
                {
                    Color left = currentImage.getPixel(x, y);
                    newImage.setPixel(x, y, currentImage.getPixel(width - 1 - x, y));
                    newImage.setPixel(width - 1 - x, y, left);
                }
            }
            currentImage = newImage;
            imagePanel.setImage(currentImage);
            frame.pack();
            
            csvWriteNum ++;
            motionRecord.add("Mirror");
        	writeCSV();
    	}
    }
    
    // ---- support methods ----

    /**
     * Show the file name of the current image in the fils display label.
     * 'null' may be used as a parameter if no file is currently loaded.
     * 
     * @param filename  The file name to be displayed, or null for 'no file'.
     */
    private void showFilename(String filename)
    {
        if(filename == null)
            filenameLabel.setText("No file displayed.");
        else
        {
        	X = currentImage.getWidth();
        	Y = currentImage.getHeight();
        	filenameLabel.setText("<html>File: " + filename + 
        						  ".<br/>The width of the image is "+ X + 
        						  ", and the height of the image is " + Y + "</html>.");
        }
    }
    
    
    /**
     * Show a message in the status bar at the bottom of the screen.
     * @param text The status message.
     */
    private void showStatus(String text)
    {
        statusLabel.setText(text);
    }
    
    
    /**
     * Enable or disable all toolbar buttons.
     * 
     * @param status  'true' to enable the buttons, 'false' to disable.
     */
    private void setButtonsEnabled(boolean status)
    {
        smallerButton.setEnabled(status);
        largerButton.setEnabled(status);
        cutButton.setEnabled(status);
        rotateButton.setEnabled(status);
        mirrorButton.setEnabled(status);
    }
    
    
    /**
     * Create a list with all the known filters.
     * @return The list of filters.
     */
    private List<Filter> createFilters()
    {
        List<Filter> filterList = new ArrayList<>();
        filterList.add(new DarkerFilter("Darker"));
        filterList.add(new LighterFilter("Lighter"));
        filterList.add(new ThresholdFilter("Threshold"));
        filterList.add(new InvertFilter("Invert"));
        filterList.add(new SolarizeFilter("Solarize"));
        filterList.add(new SmoothFilter("Smooth"));
        filterList.add(new PixelizeFilter("Pixelize"));
        filterList.add(new GrayScaleFilter("Grayscale"));
        filterList.add(new EdgeFilter("Edge Detection"));
        filterList.add(new FishEyeFilter("Fish Eye"));
        filterList.add(new DisplayOnlyRed("Display Only Red"));
        filterList.add(new DisplayOnlyGreen("Display Only Green"));
        filterList.add(new DisplayOnlyBlue("Display Only Blue"));
       
        return filterList;
    }
    
    // ---- Swing stuff to build the frame and all its components and menus ----
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));

        makeMenuBar(frame);
        
        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(6, 6));
        
        // Create the image pane in the center
        imagePanel = new ImagePanel();
        imagePanel.setBorder(new EtchedBorder());
        contentPane.add(imagePanel, BorderLayout.CENTER);

        // Create two labels at top and bottom for the file name and status messages
        filenameLabel = new JLabel();
        contentPane.add(filenameLabel, BorderLayout.NORTH);

        statusLabel = new JLabel(VERSION);
        contentPane.add(statusLabel, BorderLayout.SOUTH);
        
        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0, 1));
        
        smallerButton = new JButton("Smaller");
        smallerButton.addActionListener(e -> makeSmaller());
        toolbar.add(smallerButton);
        
        largerButton = new JButton("Larger");
        largerButton.addActionListener(e -> makeLarger());
        toolbar.add(largerButton);
        
        // create the cut/rotate
        cutButton = new JButton("Cut");
        cutButton.addActionListener(e -> cut());
        toolbar.add(cutButton);
        
        rotateButton = new JButton("Rotate 90°");
        rotateButton.addActionListener(e -> rotate());
        toolbar.add(rotateButton);
        
        mirrorButton = new JButton("Mirror");
        mirrorButton.addActionListener(e -> mirror());
        toolbar.add(mirrorButton);

        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);
        
        contentPane.add(flow, BorderLayout.WEST);
        
        // building is done - arrange the components      
        showFilename(null);
        setButtonsEnabled(false);
        frame.pack();
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     * 
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);
        
        item = new JMenuItem("Open...");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            item.addActionListener(e -> openFile());
        menu.add(item);

        item = new JMenuItem("Close");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, SHORTCUT_MASK));
            item.addActionListener(e -> close());
        menu.add(item);
        menu.addSeparator();

        item = new JMenuItem("Save As...");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, SHORTCUT_MASK));
            item.addActionListener(e -> saveAs());
        menu.add(item);
        menu.addSeparator();
        
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(e -> quit());
        menu.add(item);

        // create the Filter menu
        menu = new JMenu("Filter");
        menubar.add(menu);
        
        for(Filter filter : filters) 
        {
            item = new JMenuItem(filter.getName());
            item.addActionListener(e -> applyFilter(filter));
            menu.add(item);
        }

        // create the Help menu
        menu = new JMenu("Help");
        menubar.add(menu);
        
        item = new JMenuItem("About ImageViewer...");
            item.addActionListener(e -> showAbout());
        menu.add(item);
    }
}
