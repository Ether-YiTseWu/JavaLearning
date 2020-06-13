public class Demo 
{
	public static void main(String[] args) 
	{
		// Create Objects
		Database myDatabase = new Database();
		Item CD_hello = new CD("Hello", 5, 300, "Adele", 4);
		Item DVD_avengers = new DVD("Avengers: Endgame",181, 240, "Russo Brothers");
		Item ViedeoGame_overwatch = new VideoGame("OverWatch", 12000, 650, "FPS", "Blizzard");
		Item AudioBook_c_plus_primer = new AudioBook("C++ Primer", 500, 500, "Programming", "Stanley B. Lippman");
		
		// Add items to database
		myDatabase.addItem(CD_hello);
		myDatabase.addItem(DVD_avengers);
		myDatabase.addItem(ViedeoGame_overwatch);
		myDatabase.addItem(AudioBook_c_plus_primer);
		
		myDatabase.addComment(CD_hello, "A Beautiful Song");
		myDatabase.addComment(DVD_avengers, "I can't accept it");
		
		myDatabase.list();
		
		// Create CSV file and binary file
		String fileNameCSV = "MultiMedia.csv";
		String fileNameBinary = "MultiMedia.class";
		myDatabase.createFile(fileNameCSV);
		myDatabase.createFile(fileNameBinary);
	    
		// Write something to the file
		myDatabase.writeCSV(fileNameCSV);
		myDatabase.writeBinary(fileNameBinary);
		myDatabase.readBinary(fileNameBinary);
	}
}
