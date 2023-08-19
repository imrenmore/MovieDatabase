/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		// TODO: Add the newLine to the writeBuffer...
		writeBuffer.add(newLine);
		
	}
	
	public void saveFile(){
		// TODO: Save all of the lines in the writeBuffer to the file (given in filename)
		try {
			FileWriter fileWriter = new FileWriter("db.txt", true);
			
			for (String line: writeBuffer){
				fileWriter.write(line);
			}
			
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
