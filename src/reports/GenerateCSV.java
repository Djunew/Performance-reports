package reports;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GenerateCSV {
	
	public List<String[]> jsonData;
	
	public GenerateCSV(List<String[]> jsonData) {
		this.jsonData = jsonData;
	}
	
	public String convertToCSV(String[] data) {
	    return Stream.of(data)
	      //.map(this::escapeSpecialCharacters)
	      .collect(Collectors.joining(","));
	}
	
	public void generateCSVFile() throws IOException {
		
		File csvOutputFile = new File("C:\\Users\\dell\\Downloads\\Result.csv");
		
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			pw.append("Name, Score");
			pw.append("\n");
	        jsonData.stream()
	          .map(this::convertToCSV)
	          .forEach(pw::println);
	    }
	    
		System.out.println("CSV generated successfully!");
	}

}
