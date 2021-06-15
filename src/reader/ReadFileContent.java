package reader;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileContent {

	public String json;
	 
	//public ReadJson(String json) { this.json = json; }
	 
	/* This method reads json file and return the content as string */
	public static String readJsonContent(String json) throws Exception {
		  
		String rawData = new String(Files.readAllBytes(Paths.get(json)));
		//System.out.println("rawData = " + rawData);
		  
		return rawData;
  
	}
	
}
