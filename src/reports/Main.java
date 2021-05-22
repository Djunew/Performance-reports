package reports;

import employees.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) throws IOException {
		
		List<String[]> dataLines = new ArrayList<>();
		
		System.out.println("Enter path to JSON data file");
		String dataFile = ReadFile.readFilePathFromConsole();
		//String dataFile = "C:\\Users\\dell\\Desktop\\data file.json";
		
		System.out.println("Enter path to JSON report definition file");
		String reportDefFile = ReadFile.readFilePathFromConsole();
		//String reportDefFile = "C:\\Users\\dell\\Desktop\\report definition file.json";
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		
		//read the json report definition file and create report object
		JSONreportReader reportReader = new JSONreportReader(reportDefFile);
		String reader = reportReader.readJson();
		Report reportConditions = gson.fromJson(reader, Report.class);
		
		//read the json employee data file
		JSONreportReader jsonDataFileReader = new JSONreportReader(dataFile);
		String employeeFileInfo = jsonDataFileReader.readJson();
		//System.out.println("employee info" + employeeFileInfo);
		
		List<SalesEmployee> list = new ArrayList();
		
		SalesEmployee[] array = gson.fromJson(employeeFileInfo, SalesEmployee[].class);
			for(SalesEmployee empl : array) {
				//System.out.println(empl);
				list.add(empl);
			}
				
		//calculate scores for each employee
		list.forEach(employee -> ((SalesEmployee) employee).calculateScore(reportConditions.useExperienceMultiplier));
		
		boolean addToReport = false; //this variable is used as decision which record will go into the results file
				
		//check does each employee meet the conditions to be added to the report
		//if yes -> add that employee
		for (SalesEmployee i : list) { 
			addToReport = reportConditions.checkConditions(i.getSalesPeriod(), i.getScore());
		  
			if (addToReport == true) { 
				dataLines.add(new String[] {
						i.getName(), Double.toString(i.getScore()) });
			}
		}
		 		
		GenerateCSV fileToBeGenerated = new GenerateCSV(dataLines);
		fileToBeGenerated.generateCSVFile();
		
	}

}
