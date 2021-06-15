package reports;

import employees.*;
import reader.*;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//define arraylist to store the data that will be included in the result csv file
		List<String[]> dataLines = new ArrayList<>();
		
		//Enter paths to Report definition file and Employee data file
		System.out.println("Enter path to JSON data file");
		//String employeeDataFile = ReadFilePath.readFilePathFromConsole();
		String employeeDataFile = "C:\\Users\\dell\\eclipse-workspace\\Performance reports\\data file.json";
		
		System.out.println("Enter path to JSON report definition file");
		//String reportDefFile = ReadFilePath.readFilePathFromConsole();
		String reportDefFile = "C:\\Users\\dell\\eclipse-workspace\\Performance reports\\report definition file.json";
		
		//Define gson object to parse json data to Employee and Report objects
		Gson gson = new Gson();
		
		//read the json report definition file and create report object
		String reportDefinition = ReadFileContent.readJsonContent(reportDefFile);
		PerformanceReport reportData = gson.fromJson(reportDefinition, PerformanceReport.class);
		
		//create list from Sales Employees to store data for all employees from the file
		List<SalesEmployee> list = new ArrayList<SalesEmployee>();
		
		//read the json employee data file and create employees objects
		String employeeData = ReadFileContent.readJsonContent(employeeDataFile);
		
		SalesEmployee[] array = gson.fromJson(employeeData, SalesEmployee[].class);
		for(SalesEmployee empl : array) {
			//System.out.println(empl);
			list.add(empl);
		}
		
		//calculate scores for each employee
		list.forEach(employee -> ((SalesEmployee) employee).calculateScore(reportData.useExperienceMultiplier));
		
		//check does each employee meet the conditions to be added to the report
		//if yes -> add that employee
		boolean addToReport; //this variable is used as decision which record will go into the results file
		//TODO: addToReport variable should be replaced with addToReport method
		for (SalesEmployee i : list) { 
			addToReport = reportData.checkConditions(i.getSalesPeriod(), i.getScore());

			if (addToReport == true) { 
				dataLines.add(new String[] {
						i.getName(), Double.toString(i.getScore()) });
			}
		}
		
		GenerateCSV fileToBeGenerated = new GenerateCSV(dataLines);
		fileToBeGenerated.generateCSVFile();
		
	}

}
