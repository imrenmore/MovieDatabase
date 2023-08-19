package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename) throws IOException{
		lines = new ArrayList<>();
		//TODO: Open the filename, read in the data into the lines arraylist, and close the file when done...
		
		FileReader reader= new FileReader("db.txt");
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		while(line!=null) {
			lines.add(line);
			line=br.readLine();
		}
		br.close();
	}
	
	// Methods
	public int getNumberOfLines(){
		return lines.size();
	}
	
	public String getLine(int index){
		return lines.get(index);
	}
}