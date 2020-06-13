import java.util.ArrayList;

import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
/**
 * The database class provides a facility to store CD and video 
 * objects. A list of all CDs and videos can be printed to the
 * terminal.
 * 
 * This version does not save the data to disk, and it does not
 * provide any search functions.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Database
{
    private ArrayList<Item> items;
    
    /**
     * Construct an empty Database.
     */
    public Database()
    {
        items = new ArrayList<Item>();
    }
    
    /**
     * Made by YiTse
     */
    public void addComment(Item item, String comment)
    {
    	item.setComment(comment);
    }
    
    /**
     * Made by YiTse
     */
    public void createFile(String theFileName)
    {
    	// Create file
    	File file = new File(theFileName);
    	try
    	{
    		if(file.createNewFile())
    			System.out.println("Create " + theFileName + " successfully");
    		else
    			System.out.println("The file, " + theFileName + ", has been created");
    	}
    	catch(IOException ioe)
    	{
    		ioe.printStackTrace();
    	}
    }
    /**
     * Made by YiTse
     */
    public void writeCSV(String theFileName)
    {
    	PrintWriter outputStream = null;
		try
		{
			outputStream = new PrintWriter(theFileName);
			outputStream.println("Item Type,Title,Playing Time,Price,Comment");
			for(Item item : items)
				outputStream.println(item.getClass().getName() + "," + item.getTitle() + "," + 
									 item.getPlayingTime() + "," + item.getPrice() + "," + item.getComment());
			
			// Input by user
			Scanner keyboard = new Scanner (System.in);
			String []inputHint = {"item name", "item title", "item playing time", "item price", "item comment"};
			System.out.println("\nPlease input the new item information which will be written in " + theFileName);
			for (int i = 0 ; i < 5 ; i++)
	        {
	            String line = new String();
	            System.out.print("Please input " + inputHint[i] + " : ");
	            line = keyboard.nextLine();
	            outputStream.print(line + ",");
	        }
			System.out.println("Write " + theFileName + " successfully\n");
			
			// Close
			outputStream.close();
        }
		catch (FileNotFoundException e)
        {
			System.out.println("Write " + theFileName + " unsuccessfully\n");
			e.printStackTrace();
        } 
    }
    /**
     * Made by YiTse
     */
    public void writeBinary(String theFileName)
    {
    	ObjectOutputStream outputStream = null;
    	try 
    	{
    		outputStream = new ObjectOutputStream (new FileOutputStream (theFileName));
			for(Item item : items)
				outputStream.writeObject(item);
			
			// Input by user
			Scanner keyboard = new Scanner (System.in);
			String []inputHint = {"item title", "item playing time", "item price", "item comment"};
			System.out.println("Please input the new item information which will be written in " + theFileName);
	
			System.out.print("Please input " + inputHint[0] + " : ");
			String title = keyboard.nextLine();
			
			System.out.print("Please input " + inputHint[1] + " : ");
			int playingTime = keyboard.nextInt();
			
			System.out.print("Please input " + inputHint[2] + " : ");
			int price = keyboard.nextInt();
			
			System.out.print("Please input " + inputHint[3] + " : ");
			String comment = keyboard.nextLine();
			Item binaryItem = new Item(title, price, playingTime);
			binaryItem.setComment(comment);
	
			outputStream.writeObject(binaryItem);
			System.out.println("Write " + theFileName + " successfully");
			outputStream.close();
		} 
    	catch (IOException e) 
    	{
    		System.out.println("Write " + theFileName + " unsuccessfully");
			e.printStackTrace();
		}
    }
    
    /**
     * Made by YiTse
     */
    public void readBinary(String theFileName)
    {
    	ObjectInputStream inputStream = null;
    	try 
    	{
    		inputStream = new ObjectInputStream  (new FileInputStream  (theFileName));
    		System.out.print("\n");
    		for (int i = 0 ; i < items.size() + 1; i++)
    		{
    			Item read = (Item) inputStream.readObject();
    			read.print();
    			System.out.print("\n");
    		}
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    	catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
    }
    
    /**
     * Add an item to the database.
     * @param theItem The item to be added.
     */
    public void addItem(Item theItem)
    {
        items.add(theItem);
    }

    /**
     * Print a list of all currently stored CDs and videos to the
     * text terminal.
     */
    public void list()
    {
        for(Item item : items)
        {
        	item.print();
        	System.out.print("\n");
        }
    }

}